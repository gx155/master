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
import com.hand.study.app.service.TransferHeaderService;
import com.hand.study.domain.entity.TransferHeader;
import com.hand.study.domain.repository.TransferHeaderRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 调拨头信息表(TransferHeader)表控制层
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:34
 */

@RestController("transferHeaderController.v1")
@RequestMapping("/v1/{organizationId}/transfer-headers")
public class TransferHeaderController extends BaseController {

    @Autowired
    private TransferHeaderRepository transferHeaderRepository;

    @Autowired
    private TransferHeaderService transferHeaderService;

    @ApiOperation(value = "调拨头信息表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<TransferHeader>> list(TransferHeader transferHeader, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = TransferHeader.FIELD_TRANSFER_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<TransferHeader> list = transferHeaderService.selectList(pageRequest, transferHeader);
        return Results.success(list);
    }

    @ApiOperation(value = "调拨头信息表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{transferHeaderId}")
    public ResponseEntity<TransferHeader> detail(@PathVariable Long transferHeaderId) {
        TransferHeader transferHeader = transferHeaderRepository.selectByPrimary(transferHeaderId);
        return Results.success(transferHeader);
    }

    @ApiOperation(value = "创建或更新调拨头信息表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<TransferHeader>> save(@PathVariable Long organizationId, @RequestBody List<TransferHeader> transferHeaders) {
        validObject(transferHeaders);
        SecurityTokenHelper.validTokenIgnoreInsert(transferHeaders);
        transferHeaderService.saveData(transferHeaders);
        return Results.success(transferHeaders);
    }

    @ApiOperation(value = "删除调拨头信息表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody List<TransferHeader> transferHeaders) {
        SecurityTokenHelper.validToken(transferHeaders);
        transferHeaderRepository.batchDeleteByPrimaryKey(transferHeaders);
        return Results.success();
    }

}

