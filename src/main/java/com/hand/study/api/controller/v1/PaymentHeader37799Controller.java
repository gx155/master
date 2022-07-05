package com.hand.study.api.controller.v1;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.EntryInformationDTO;
import com.hand.study.domain.entity.PaymentHeader37799Vo;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.mule.weave.v2.mapping.MappingCodeGenerator;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.opensaml.xml.security.x509.X509Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hand.study.app.service.PaymentHeader37799Service;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 单据表(PaymentHeader37799)表控制层
 *
 * @author gx
 * @since 2022-07-05 12:42:33
 */

@RestController("paymentHeader37799Controller.v1")
@RequestMapping("/v1/{organizationId}/payment-header37799s")
public class PaymentHeader37799Controller extends BaseController {

    @Autowired
    private PaymentHeader37799Repository paymentHeader37799Repository;

    @Autowired
    private PaymentHeader37799Service paymentHeader37799Service;

    @ApiOperation(value = "单据表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<PaymentHeader37799>> list(PaymentHeader37799 paymentHeader37799, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = PaymentHeader37799.FIELD_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<PaymentHeader37799> list = paymentHeader37799Service.selectList(pageRequest, paymentHeader37799);
        return Results.success(list);
    }

    @ApiOperation(value = "单据表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{headerId}")
    public ResponseEntity<PaymentHeader37799> detail(@PathVariable Long headerId) {
        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Repository.selectByPrimary(headerId);
        return Results.success(paymentHeader37799);
    }

    @ApiOperation(value = "创建或更新单据表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<PaymentHeader37799>> save(@PathVariable Long organizationId, @RequestBody List<PaymentHeader37799> paymentHeader37799s) {
        validObject(paymentHeader37799s);
        SecurityTokenHelper.validTokenIgnoreInsert(paymentHeader37799s);
        paymentHeader37799s.forEach(item -> item.setTenantId(organizationId));
        paymentHeader37799Service.saveData(paymentHeader37799s);
        return Results.success(paymentHeader37799s);
    }

    @ApiOperation(value = "删除单据表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody List<PaymentHeader37799> paymentHeader37799s) {
        SecurityTokenHelper.validToken(paymentHeader37799s);
        paymentHeader37799Repository.batchDeleteByPrimaryKey(paymentHeader37799s);
        return Results.success();
    }

    @ApiOperation(value = "订单汇总查询")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/requisition-main")
    public List<PaymentHeader37799Vo> selectDataByPaymentTransaction(@PathVariable Long organizationId, @RequestBody AggregateQueryDTO aggregateQueryDTO){
        return paymentHeader37799Repository.selectDataByPaymentTransaction(aggregateQueryDTO);
    }

    @ApiOperation(value = "头行信息录入")
    @PostMapping("/EntryInformationInsert")
    public ResponseEntity EntryInformationInsert(@PathVariable Long organizationId, @RequestBody EntryInformationDTO entryInformationDTO){
        paymentHeader37799Repository.insertDate(entryInformationDTO);
        return Results.success();
    }

    @ApiOperation(value = "头行信息查看")
    @GetMapping("/EntryInformationSelect")
    public ResponseEntity<EntryInformationDTO> EntryInformationSelect(@PathVariable Long organizationId, @PathVariable Long paymentNumber){
        EntryInformationDTO entryInformation = paymentHeader37799Repository.selectByPaymentNumber(paymentNumber);
        return Results.success(entryInformation);
    }

    @ApiOperation(value = "头行信息编辑")
    @PostMapping("/EntryInformationUpdate")
    public ResponseEntity EntryInformationUpdate(@PathVariable Long organizationId, @RequestBody EntryInformationDTO entryInformationDTO){
        paymentHeader37799Repository.updateEntryInformation(entryInformationDTO);
        return Results.success();
    }
}

