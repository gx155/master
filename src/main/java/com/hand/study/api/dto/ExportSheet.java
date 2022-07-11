package com.hand.study.api.dto;

import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 导出
 * @date: 2022/7/8 10:34
 */
@ExcelSheet(zh = "sheet页",en = "demo")
public class ExportSheet {


    @ApiModelProperty(value = "付款单号", required = true)
    @ExcelColumn
    private String paymentNumber;

    @ApiModelProperty(value = "单据状态")
    @ExcelColumn
    private String paymentStatus;


    @ApiModelProperty(value = "行号")
    @ExcelColumn
    private String lineNumber;

    @ApiModelProperty(value = "是否支付标志")
    @ExcelColumn
    private String payFlag;

    @ApiModelProperty(value = "付款方式")
    @ExcelColumn
    private String paymentMethod;

    @ApiModelProperty(value = "金额")
    @ExcelColumn
    private BigDecimal amount;

    @ApiModelProperty(value = "支付完成日期")
    @ExcelColumn
    private Date paymentDate;

    @ApiModelProperty(value = "描述")
    @ExcelColumn
    private String description;

}
