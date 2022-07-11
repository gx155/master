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
import com.hand.study.app.service.InvoiceLine37799Service;
import com.hand.study.domain.entity.InvoiceLine37799;
import com.hand.study.domain.repository.InvoiceLine37799Repository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 单据行表(InvoiceLine37799)表控制层
 *
 * @author gx
 * @since 2022-07-11 10:45:01
 */

@RestController("invoiceLine37799Controller.v1")
@RequestMapping("/v1/{organizationId}/invoice-line37799s")
public class InvoiceLine37799Controller extends BaseController {

    @Autowired
    private InvoiceLine37799Repository invoiceLine37799Repository;

    @Autowired
    private InvoiceLine37799Service invoiceLine37799Service;

    @ApiOperation(value = "发票单行查询API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("lineId")
    public ResponseEntity<Page<InvoiceLine37799>> list(@PathVariable(value = "lineId") Long lineId, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = InvoiceLine37799.FIELD_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<InvoiceLine37799> list = invoiceLine37799Service.selectList(pageRequest, lineId);
        return Results.success(list);
    }

    @ApiOperation(value = "发票单行删除API")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody InvoiceLine37799 invoiceLine37799) {
        SecurityTokenHelper.validToken(invoiceLine37799);
        invoiceLine37799Repository.deleteByLineId(invoiceLine37799.getLineId());
        return Results.success();
    }

    @ApiOperation(value = "单据行表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{lineId}")
    public ResponseEntity<InvoiceLine37799> detail(@PathVariable Long lineId) {
        InvoiceLine37799 invoiceLine37799 = invoiceLine37799Repository.selectByPrimary(lineId);
        return Results.success(invoiceLine37799);
    }

    @ApiOperation(value = "创建或更新单据行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<InvoiceLine37799>> save(@PathVariable Long organizationId, @RequestBody List<InvoiceLine37799> invoiceLine37799s) {
        validObject(invoiceLine37799s);
        SecurityTokenHelper.validTokenIgnoreInsert(invoiceLine37799s);
        invoiceLine37799s.forEach(item -> item.setTenantId(organizationId));
        invoiceLine37799Service.saveData(invoiceLine37799s);
        return Results.success(invoiceLine37799s);
    }



}

