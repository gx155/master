package com.hand.study.infra.repository.impl;

import com.hand.study.domain.entity.InvoiceHeader37799;
import com.hand.study.domain.repository.InvoiceHeader37799Repository;
import com.hand.study.infra.util.HeaderAndLineStatus;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.DetailsHelper;
import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.InvoiceLine37799;
import com.hand.study.domain.repository.InvoiceLine37799Repository;
import com.hand.study.infra.mapper.InvoiceLine37799Mapper;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单据行表(InvoiceLine37799)资源库
 *
 * @author gx
 * @since 2022-07-11 10:45:00
 */
@Component
public class InvoiceLine37799RepositoryImpl extends BaseRepositoryImpl<InvoiceLine37799> implements InvoiceLine37799Repository {
    @Resource
    private InvoiceLine37799Mapper invoiceLine37799Mapper;
    @Autowired
    private InvoiceLine37799Repository invoiceLine37799Repository;

    @Autowired
    private InvoiceHeader37799Repository invoiceHeader37799Repository;

    @Override
    public List<InvoiceLine37799> selectList(InvoiceLine37799 invoiceLine37799) {
        return invoiceLine37799Mapper.selectList(invoiceLine37799);
    }

    @Override
    public InvoiceLine37799 selectByPrimary(Long lineId) {
        InvoiceLine37799 invoiceLine37799 = new InvoiceLine37799();
        invoiceLine37799.setLineId(lineId);
        List<InvoiceLine37799> invoiceLine37799s = invoiceLine37799Mapper.selectList(invoiceLine37799);
        if (invoiceLine37799s.size() == 0) {
            return null;
        }
        return invoiceLine37799s.get(0);
    }

    @Override
    public void deleteByLineId(Long lineId) {
        List<InvoiceLine37799> invoiceLine37799s = invoiceLine37799Repository.selectByCondition(
                Condition.builder(InvoiceLine37799.class)
                        .andWhere(Sqls.custom().andEqualTo(InvoiceLine37799.FIELD_LINE_ID, lineId)).build()
        );
        Long headerId = invoiceLine37799s.get(0).getHeaderId();
        InvoiceHeader37799 invoiceHeader37799 = invoiceHeader37799Repository.selectByCondition(Condition.builder(InvoiceHeader37799.class)
                .andWhere(Sqls.custom().andEqualTo(InvoiceHeader37799.FIELD_HEADER_ID, headerId)).build()).get(0);

        if (ObjectUtils.isEmpty(invoiceLine37799s)){
            throw new CommonException("hfins.fm.error.common.37799");
        }
        invoiceLine37799s.forEach(invoiceLine37799 -> {

        });
        if(invoiceHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
            throw new CommonException("hfins.fm.error.common.02.37799");
        };
        if (!(HeaderAndLineStatus.FIELD_NEW.equals(invoiceHeader37799.getInvoiceStatus()) || HeaderAndLineStatus.FIELD_REJECT.equals(invoiceHeader37799.getInvoiceStatus())) ){
            throw new CommonException("hfins.fm.error.state1.37799");
        }

        invoiceLine37799Repository.batchDeleteByPrimaryKey(invoiceLine37799s);
    }

}

