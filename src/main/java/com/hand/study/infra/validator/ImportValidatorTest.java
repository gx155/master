package com.hand.study.infra.validator;

import org.hzero.boot.imported.app.service.ValidatorHandler;
import org.hzero.boot.imported.infra.validator.annotation.ImportValidator;
import org.hzero.boot.imported.infra.validator.annotation.ImportValidators;

import java.util.Map;


/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 导入
 * @date: 2022/7/8 14:18
 */
@ImportValidators({
        @ImportValidator(templateCode = "PAYMENT-37799")
})
public class ImportValidatorTest extends ValidatorHandler {

    @Override
    public boolean validate(String data) {
        //获取自定义参数
        Map args = getArgs();

        System.out.println("==========校验=========");
        //错误信息
        addErrorMsg("数据有问题！");
        return true;
    }
}
