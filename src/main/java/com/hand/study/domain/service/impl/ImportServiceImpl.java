package com.hand.study.domain.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;

import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 导入
 * @date: 2022/7/8 11:25
 */
@ImportService(templateCode = "PAYMENT-37799")
public class ImportServiceImpl implements IDoImportService {

    @Resource
    private ObjectMapper objectMapper;
    @Autowired
    private PaymentHeader37799Repository paymentHeader37799Repository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean doImport(String data) {
        System.out.println(data);

        Map<String,String> employee37799 = new HashMap<>(16);
        employee37799.put("employee37799", "789987");
        //编码生成
        String code = codeRuleBuilder.generateCode("HZERO.37799.PAYMANET.NUMBER",employee37799);


        PaymentHeader37799 paymentHeader37799;
        try {
            paymentHeader37799 = objectMapper.readValue(data,PaymentHeader37799.class);
        } catch (IOException e) {
            return false;
        }
        paymentHeader37799.setPaymentNumber(code);
        paymentHeader37799.setPaymentTransaction("string");
        paymentHeader37799Repository.insert(paymentHeader37799);
        return true;
    }

    @Override
    public void onStart() {
        IDoImportService.super.onStart();
    }

    @Override
    public void onFinish() {
        IDoImportService.super.onFinish();
    }
}
