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
import com.hand.study.app.service.TransferLineService;
import com.hand.study.domain.entity.TransferLine;
import com.hand.study.domain.repository.TransferLineRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 调拨单行表(TransferLine)表控制层
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:35
 */

@RestController("transferLineController.v1")
@RequestMapping("/v1/{organizationId}/transfer-lines")
public class TransferLineController extends BaseController {

    @Autowired
    private TransferLineRepository transferLineRepository;

    @Autowired
    private TransferLineService transferLineService;

    @ApiOperation(value = "调拨单行表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<TransferLine>> list(TransferLine transferLine, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = TransferLine.FIELD_TRANSFER_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<TransferLine> list = transferLineService.selectList(pageRequest, transferLine);
        return Results.success(list);
    }

    @ApiOperation(value = "调拨单行表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{transferLineId}")
    public ResponseEntity<TransferLine> detail(@PathVariable Long transferLineId) {
        TransferLine transferLine = transferLineRepository.selectByPrimary(transferLineId);
        return Results.success(transferLine);
    }

    @ApiOperation(value = "创建或更新调拨单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<TransferLine>> save(@PathVariable Long organizationId, @RequestBody List<TransferLine> transferLines) {
        validObject(transferLines);
        SecurityTokenHelper.validTokenIgnoreInsert(transferLines);
        transferLineService.saveData(transferLines);
        return Results.success(transferLines);
    }

    @ApiOperation(value = "删除调拨单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody List<TransferLine> transferLines) {
        SecurityTokenHelper.validToken(transferLines);
        transferLineRepository.batchDeleteByPrimaryKey(transferLines);
        return Results.success();
    }

}

