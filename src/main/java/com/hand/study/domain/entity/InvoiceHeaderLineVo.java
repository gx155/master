package com.hand.study.domain.entity;

import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 头行打平导出
 * @date: 2022/7/11 16:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelSheet(zh = "sheet页",en = "demo")
public class InvoiceHeaderLineVo {

    @ApiModelProperty(value = "发票单号", required = true)
    @ExcelColumn
    private String invoiceNumber;

    @ApiModelProperty(value = "公司名称")
    @ExcelColumn
    private String companyName;

    @ApiModelProperty(value = "员工名称")
    @ExcelColumn
    private String employeeName;

    @ApiModelProperty(value = "岗位名称")
    @ExcelColumn
    private String positionName;

    @ApiModelProperty(value = "核算主体名称")
    @ExcelColumn
    private String accEntityName;

    @ApiModelProperty(value = "发票类型名称")
    @ExcelColumn
    private String invoiceType;

    @MultiLanguageField
    @ApiModelProperty(value = "交易附言(多语言)")
    @ExcelColumn
    private String invoiceTransaction;

    @ApiModelProperty(value = "行号")
    @ExcelColumn
    private String lineNumber;

    @ApiModelProperty(value = "金额")
    @ExcelColumn
    private BigDecimal amount;

    @ApiModelProperty(value = "付款方式名称")
    @ExcelColumn
    private String invoiceMethod;

}
