package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.TransferHeader;

import java.util.List;

/**
 * 调拨头信息表(TransferHeader)应用服务
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:33
 */
public interface TransferHeaderMapper extends BaseMapper<TransferHeader> {
    /**
     * 基础查询
     *
     * @param transferHeader 查询条件
     * @return 返回值
     */
    List<TransferHeader> selectList(TransferHeader transferHeader);
}

