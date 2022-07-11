package com.hand.study.api.controller.v1;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.EntryInformationDTO;
import com.hand.study.api.dto.ExportSheet;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.app.service.PaymentHeader37799Service;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.entity.PaymentHeader37799Vo;
import com.hand.study.domain.repository.PaymentHeader37799Repository;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
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




    @ApiOperation(value = "订单汇总查询API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/requisition-main")
    public List<PaymentHeader37799Vo> selectDataByPaymentTransaction(@PathVariable Long organizationId, @RequestBody AggregateQueryDTO aggregateQueryDTO){
        return paymentHeader37799Repository.selectDataByPaymentTransaction(aggregateQueryDTO);
    }

    /**
     * 付款单头查询API
     * @param organizationId
     * @param headerId
     * @return
     */
    @ApiOperation(value = "付款单头查询API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{headerId}")
    public ResponseEntity<PaymentHeader37799> selectInfoByHeaderId(@PathVariable Long organizationId, @PathVariable("headerId") Long headerId){
        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Repository.selectByHeaderId(headerId);
        return Results.success(paymentHeader37799);
    }

    @ApiOperation(value = "付款单状态API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/StatusUpdate")
    public void StatusUpdate(@PathVariable Long organizationId, @RequestBody HeaderIdStatusDTO headerIdStatusDTO){
        paymentHeader37799Service.statusUpdateByHeaderId(headerIdStatusDTO);

    }

    @ApiOperation(value = "付款单删除API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public void paymentSlipDelete(@PathVariable Long organizationId,@RequestBody PaymentHeader37799 paymentHeader37799){
        SecurityTokenHelper.validToken(paymentHeader37799);
        paymentHeader37799Service.deleteSlipByHeaderId(paymentHeader37799.getHeaderId());
    }

    @ApiOperation(value = "付款单保存/更新API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<PaymentHeader37799> save(@PathVariable Long organizationId, @RequestBody PaymentHeader37799 paymentHeader37799) {
        validObject(paymentHeader37799);
        SecurityTokenHelper.validTokenIgnoreInsert(paymentHeader37799);
        paymentHeader37799.setTenantId(organizationId);
        paymentHeader37799Service.saveData(paymentHeader37799);
        return Results.success(paymentHeader37799);
    }

    @ApiOperation(value = "导出")
    @Permission(permissionLogin = true)
    @GetMapping("/export-all")
    @ExcelExport(PaymentHeader37799.class)
    public ResponseEntity<List<PaymentHeader37799>> complexSelect(
            @PathVariable Long organizationId,
            ExportParam exportParam,
            HttpServletResponse response){
        return Results.success(paymentHeader37799Repository.selectAll());
    }

    @ApiOperation(value = "RTF报表数据导出")
    @Permission(permissionLogin = true)
    @GetMapping("/rtf-export")
    public ResponseEntity<List<ExportSheet>> rtfExport(
            @PathVariable Long organizationId
){
        return Results.success(paymentHeader37799Service.selectRTFData());
    }


//    @ApiOperation(value = "头行信息录入")
//    @Permission(level = ResourceLevel.ORGANIZATION)
//    @PostMapping("/EntryInformationInsert")
//    public ResponseEntity EntryInformationInsert(@PathVariable Long organizationId, @RequestBody EntryInformationDTO entryInformationDTO){
//        paymentHeader37799Repository.insertDate(entryInformationDTO);
//        return Results.success();
//    }

//    @ApiOperation(value = "头行信息查看")
//    @Permission(level = ResourceLevel.ORGANIZATION)
//    @GetMapping("/EntryInformationSelect/{headerId}")
//    public ResponseEntity<EntryInformationDTO> EntryInformationSelect(@PathVariable Long organizationId, @PathVariable("headerId") Long headerId){
//        EntryInformationDTO entryInformation = paymentHeader37799Repository.selectAllByHeaderId(headerId);
//        return Results.success(entryInformation);
//    }

//    @ApiOperation(value = "头行信息编辑")
//    @PostMapping("/EntryInformationUpdate")
//    public ResponseEntity EntryInformationUpdate(@PathVariable Long organizationId, @RequestBody EntryInformationDTO entryInformationDTO){
//        paymentHeader37799Repository.updateEntryInformation(entryInformationDTO);
//        return Results.success();
//    }
}

