package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.TransferLine;

import java.util.List;

/**
 * 调拨单行表(TransferLine)应用服务
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:34
 */
public interface TransferLineMapper extends BaseMapper<TransferLine> {
    /**
     * 基础查询
     *
     * @param transferLine 查询条件
     * @return 返回值
     */
    List<TransferLine> selectList(TransferLine transferLine);
}

