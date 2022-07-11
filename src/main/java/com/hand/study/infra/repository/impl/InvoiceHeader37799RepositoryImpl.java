package com.hand.study.infra.repository.impl;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.domain.entity.*;
import com.hand.study.domain.repository.*;
import com.hand.study.infra.mapper.InvoiceHeader37799Mapper;
import com.hand.study.infra.util.HeaderAndLineStatus;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.DetailsHelper;
import org.hzero.boot.platform.lov.adapter.LovAdapter;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单据表(InvoiceHeader37799)资源库
 *
 * @author gx
 * @since 2022-07-11 10:44:25
 */
@Component
public class InvoiceHeader37799RepositoryImpl extends BaseRepositoryImpl<InvoiceHeader37799> implements InvoiceHeader37799Repository {
    @Resource
    private InvoiceHeader37799Mapper invoiceHeader37799Mapper;

    @Autowired
    private InvoiceHeader37799Repository invoiceHeader37799Repository;

    @Autowired
    private InvoiceLine37799Repository invoiceLine37799Repository;

    @Autowired
    private LovAdapter lovAdapter;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MoInvoiceTypeRepository moInvoiceTypeRepository;

    @Autowired
    private OrgUnitRepository orgUnitRepository;

    @Autowired
    private AccountingEntityRepository accountingEntityRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<InvoiceHeader37799> selectList(InvoiceHeader37799 invoiceHeader37799) {
        return invoiceHeader37799Mapper.selectList(invoiceHeader37799);
    }

    @Override
    public InvoiceHeader37799 selectByPrimary(Long headerId) {
        InvoiceHeader37799 invoiceHeader37799 = new InvoiceHeader37799();
        invoiceHeader37799.setHeaderId(headerId);
        InvoiceHeader37799 invoiceHeader37799s = invoiceHeader37799Mapper.selectList(invoiceHeader37799).get(0);
        //状态翻译
        invoiceHeader37799s.setInvoiceStatus(lovAdapter.queryLovMeaning("HZERO.37799.INVOICE.STATUS",0L,invoiceHeader37799s.getInvoiceStatus()));
        return invoiceHeader37799s;
    }

    @Override
    public List<InvoiceHeader37799> selectInfoList(AggregateQueryDTO aggregateQueryDTO) {
        List<InvoiceHeader37799> invoiceHeader37799s = invoiceHeader37799Mapper.selectAllList(aggregateQueryDTO);
        invoiceHeader37799s.forEach(invoiceHeader37799 -> {
            //发票类型
            invoiceHeader37799.setInvoiceType(moInvoiceTypeRepository.selectByCondition(Condition.builder(MoInvoiceType.class).andWhere(Sqls.custom().andEqualTo(MoInvoiceType.FIELD_INVOICE_TYPE,invoiceHeader37799.getInvoiceType())).build()).get(0).getInvoiceType());
            //申请人
            invoiceHeader37799.setEmployeeName(
                    employeeRepository.selectByCondition(Condition.builder(Employee.class).andWhere(Sqls.custom().andEqualTo(Employee.FIELD_EMPLOYEE_ID,invoiceHeader37799.getEmployeeId())).build()).get(0).getName()
            );
            //部门 核算主体
            invoiceHeader37799.setUnitAccEntityName(orgUnitRepository.selectByCondition(Condition.builder(OrgUnit.class).andWhere(Sqls.custom().andEqualTo(OrgUnit.FIELD_COMPANY_ID,invoiceHeader37799.getCompanyId())).build()).get(0).getDescription() + "/" +
            accountingEntityRepository.selectByCondition(Condition.builder(AccountingEntity.class).andWhere(Sqls.custom().andEqualTo(AccountingEntity.FIELD_ACC_ENTITY_ID,invoiceHeader37799.getAccEntityId())).build()).get(0).getAccEntityName());
            orgUnitRepository.selectByCondition(Condition.builder(OrgUnit.class).andWhere(Sqls.custom().andEqualTo(OrgUnit.FIELD_COMPANY_ID,invoiceHeader37799.getCompanyId())).build());

            //状态翻译
            invoiceHeader37799.setInvoiceStatus(lovAdapter.queryLovMeaning("HZERO.37799.INVOICE.STATUS",0L,invoiceHeader37799.getInvoiceStatus()));
        });
        return invoiceHeader37799s;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteDataByHeaderId(Long headerId) {
        InvoiceHeader37799 invoiceHeader37799 = invoiceHeader37799Repository.selectByPrimary(headerId);

        //校验订单是否存在
        if (ObjectUtils.isEmpty(invoiceHeader37799)) {
            throw new CommonException("hfins.fm.error.common.37799");
        }
        //当前用户是否与单据创建人一致
        if(invoiceHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
            throw new CommonException("hfins.fm.error.common.02.37799");
        };
        //校验当前单据数据库状态是否为NEW/REJECTED
        if (!(HeaderAndLineStatus.FIELD_NEW.equals(invoiceHeader37799.getInvoiceStatus()) || HeaderAndLineStatus.FIELD_REJECT.equals(invoiceHeader37799.getInvoiceStatus())) ){
            throw new CommonException("hfins.fm.error.state1.37799");
        }

        List<InvoiceLine37799> invoiceLine37799s = invoiceLine37799Repository.selectByCondition(
                Condition.builder(InvoiceLine37799.class)
                        .andWhere(Sqls.custom().andEqualTo(InvoiceLine37799.FIELD_HEADER_ID, headerId)).build()
        );
        invoiceLine37799Repository.batchDeleteByPrimaryKey(invoiceLine37799s);
        invoiceHeader37799Repository.deleteByPrimaryKey(headerId);
    }

    @Override
    public List<InvoiceHeaderLineVo> selectAllDate() {
        return invoiceHeader37799Mapper.selectAllDate();
    }


}

