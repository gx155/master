package com.hand.study.api.controller.v1;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 获取单据默认数据
 * @date: 2022/7/5 13:02
 */
@Api(
        tags = {"Api document getDocInitInfo"}
)
@RestController("DocumentController.v1")
@RequestMapping({"/v1/{organizationId}/document"})
public class DocumentController {

}
