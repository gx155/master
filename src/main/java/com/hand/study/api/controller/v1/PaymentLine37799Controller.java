package com.hand.study.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hand.study.app.service.PaymentLine37799Service;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentLine37799Repository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 单据行表(PaymentLine37799)表控制层
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */

@RestController("paymentLine37799Controller.v1")
@RequestMapping("/v1/{organizationId}/payment-line37799s")
public class PaymentLine37799Controller extends BaseController {

    @Autowired
    private PaymentLine37799Repository paymentLine37799Repository;

    @Autowired
    private PaymentLine37799Service paymentLine37799Service;

    @ApiOperation(value = "付款单行查询API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{headerId}")
    public ResponseEntity<Page<PaymentLine37799>> list(@PathVariable Long organizationId, @PathVariable("headerId") Long headerId, @ApiIgnore @SortDefault(value = PaymentLine37799.FIELD_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<PaymentLine37799> list = paymentLine37799Service.selectList(pageRequest, headerId);
        return Results.success(list);
    }

    @ApiOperation(value = "付款单行删除API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public void remove(@PathVariable Long organizationId,@RequestBody PaymentLine37799 paymentLine37799) {
        SecurityTokenHelper.validToken(paymentLine37799);
        paymentLine37799Repository.deleteByLineId(paymentLine37799.getLineId());
    }

//    @ApiOperation(value = "单据行表明细")
//    @Permission(level = ResourceLevel.ORGANIZATION)
//    @GetMapping("/{lineId}")
//    public ResponseEntity<PaymentLine37799> detail(@PathVariable Long lineId) {
//        PaymentLine37799 paymentLine37799 = paymentLine37799Repository.selectByPrimary(lineId);
//        return Results.success(paymentLine37799);
//    }

    @ApiOperation(value = "创建或更新单据行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<PaymentLine37799>> save(@PathVariable Long organizationId, @RequestBody List<PaymentLine37799> paymentLine37799s) {
        validObject(paymentLine37799s);
        SecurityTokenHelper.validTokenIgnoreInsert(paymentLine37799s);
        paymentLine37799s.forEach(item -> item.setTenantId(organizationId));
        paymentLine37799Service.saveData(paymentLine37799s);
        return Results.success(paymentLine37799s);
    }


}

