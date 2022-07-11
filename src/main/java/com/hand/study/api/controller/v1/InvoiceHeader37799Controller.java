package com.hand.study.api.controller.v1;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.domain.entity.InvoiceHeaderLineVo;
import com.hand.study.domain.entity.PaymentHeader37799;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
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
import com.hand.study.app.service.InvoiceHeader37799Service;
import com.hand.study.domain.entity.InvoiceHeader37799;
import com.hand.study.domain.repository.InvoiceHeader37799Repository;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单据表(InvoiceHeader37799)表控制层
 *
 * @author gx
 * @since 2022-07-11 10:44:25
 */

@RestController("invoiceHeader37799Controller.v1")
@RequestMapping("/v1/{organizationId}/invoice-header37799s")
public class InvoiceHeader37799Controller extends BaseController {

    @Autowired
    private InvoiceHeader37799Repository invoiceHeader37799Repository;

    @Autowired
    private InvoiceHeader37799Service invoiceHeader37799Service;

    @ApiOperation(value = "订单汇总查询API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<InvoiceHeader37799>> list(AggregateQueryDTO aggregateQueryDTO, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = InvoiceHeader37799.FIELD_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<InvoiceHeader37799> list = invoiceHeader37799Service.selectInfoList(pageRequest, aggregateQueryDTO);
        return Results.success(list);
    }

    @ApiOperation(value = "发票单头查询API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/detail/{headerId}")
    public ResponseEntity<InvoiceHeader37799> detail(@PathVariable Long headerId) {
        InvoiceHeader37799 invoiceHeader37799 = invoiceHeader37799Repository.selectByPrimary(headerId);
        return Results.success(invoiceHeader37799);
    }

    @ApiOperation(value = "发票单状态API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/StatusUpdate")
    public void StatusUpdate(@PathVariable Long organizationId, @RequestBody HeaderIdStatusDTO headerIdStatusDTO){
        invoiceHeader37799Service.statusUpdateByHeaderId(headerIdStatusDTO);

    }

    @ApiOperation(value = "发票单删除API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody InvoiceHeader37799 invoiceHeader37799s) {
        SecurityTokenHelper.validToken(invoiceHeader37799s);
        invoiceHeader37799Repository.deleteDataByHeaderId(invoiceHeader37799s.getHeaderId());
        return Results.success();
    }

    @ApiOperation(value = "发票单保存/更新 API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<InvoiceHeader37799> save(@PathVariable Long organizationId, @RequestBody InvoiceHeader37799 invoiceHeader37799) {
        validObject(invoiceHeader37799);
        SecurityTokenHelper.validTokenIgnoreInsert(invoiceHeader37799);
        invoiceHeader37799.setTenantId(organizationId);
        invoiceHeader37799Service.saveData(invoiceHeader37799);
        return Results.success(invoiceHeader37799);
    }

    @ApiOperation(value = "导出")
    @Permission(permissionLogin = true)
    @GetMapping("/export-all")
    @ExcelExport(InvoiceHeaderLineVo.class)
    public ResponseEntity<List<InvoiceHeaderLineVo>> complexSelect(
            @PathVariable Long organizationId,
            ExportParam exportParam,
            HttpServletResponse response){
        return Results.success(invoiceHeader37799Repository.selectAllDate());
    }


}

