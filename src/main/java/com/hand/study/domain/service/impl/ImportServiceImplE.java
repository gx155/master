package com.hand.study.domain.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.study.domain.entity.*;
import com.hand.study.domain.repository.*;
import com.hand.study.infra.util.HeaderAndLineStatus;
import io.choerodon.core.exception.CommonException;
import org.hzero.boot.imported.app.service.IBatchImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 导入
 * @date: 2022/7/8 11:25
 */
@ImportService(templateCode = "INVOICE-37799")
public class ImportServiceImplE implements IBatchImportService {

    @Resource
    private ObjectMapper objectMapper;
    @Autowired
    private InvoiceHeader37799Repository invoiceHeader37799Repository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private OrgPositionRepository orgPositionRepository;

    @Autowired
    private MoInvoiceTypeRepository moInvoiceTypeRepository;

    @Autowired
    private OrgUnitRepository orgUnitRepository;

    @Autowired
    private AccountingEntityRepository accountingEntityRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean doImport(List<String> data) {
        //公司
        Map<String , Long > companyMap = companyRepository.selectAll().stream().collect(Collectors.toMap(Company::getCompanyShortName,Company::getCompanyId));
        //员工
        Map<String, Long> employeeMap = employeeRepository.selectAll().stream().collect(Collectors.toMap(Employee::getName,Employee::getEmployeeId));
        //岗位
        Map<String, Long> positionMap = orgPositionRepository.selectAll().stream().collect(Collectors.toMap(OrgPosition::getDescription,OrgPosition::getPositionId));
        //核算主体
        Map<String, Long> accEntityMap = accountingEntityRepository.selectAll().stream().collect(Collectors.toMap(AccountingEntity::getAccEntityName,AccountingEntity::getAccEntityId));
        //发票类型
        Map<String, Long> moInvoiceTypeMap = moInvoiceTypeRepository.selectAll().stream().collect(Collectors.toMap(MoInvoiceType::getInvoiceType,MoInvoiceType::getMoInvoiceTypeId));
        //付款方式
        paymentMethodRepository.selectAll().stream().collect(Collectors.toMap(PaymentMethod::getPaymentMethodId,PaymentMethod::getPayMethodCode));
        data.forEach(data1 ->{
            InvoiceHeaderLineVo invoiceHeaderLineVo = new InvoiceHeaderLineVo();
            try {
                invoiceHeaderLineVo = objectMapper.readValue(data1,InvoiceHeaderLineVo.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (invoiceHeaderLineVo.getCompanyName() == null || invoiceHeaderLineVo.getEmployeeName() == null
                    || invoiceHeaderLineVo.getPositionName() == null || invoiceHeaderLineVo.getAccEntityName() == null
            ){
                throw new CommonException("hfins.fm.error.common.06.37799");
            }

            Map<String,String> employee37799 = new HashMap<>(16);

            InvoiceHeader37799 invoiceHeader37799 = new InvoiceHeader37799();
            invoiceHeader37799.setCompanyId(companyMap.get(invoiceHeaderLineVo.getCompanyName()));
            invoiceHeader37799.setEmployeeId(employeeMap.get(invoiceHeaderLineVo.getEmployeeName()));
            invoiceHeader37799.setPositionId(positionMap.get(invoiceHeaderLineVo.getEmployeeName()));
            invoiceHeader37799.setAccEntityId(accEntityMap.get(invoiceHeaderLineVo.getAccEntityName()));
            invoiceHeader37799.setInvoiceType(moInvoiceTypeMap.get(invoiceHeaderLineVo.getInvoiceType()).toString());
            invoiceHeader37799.setInvoiceTransaction(invoiceHeaderLineVo.getInvoiceTransaction());
            invoiceHeader37799.setDateOfApplication(new Date());
            invoiceHeader37799.setInvoiceStatus(HeaderAndLineStatus.FIELD_NEW);
            employee37799.put("employee37799", String.valueOf(invoiceHeader37799.getEmployeeId()));
            //编码生成
            String code = codeRuleBuilder.generateCode("HZERO.37799.INVOICE.NUMBER",employee37799);


            invoiceHeader37799.setInvoiceNumber(code);

            invoiceHeader37799Repository.insert(invoiceHeader37799);
        });

        return true;
    }

}
