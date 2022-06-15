package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.TransferLine;

import java.util.List;

/**
 * 调拨单行表(TransferLine)资源库
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:35
 */
public interface TransferLineRepository extends BaseRepository<TransferLine> {
    /**
     * 查询
     *
     * @param transferLine 查询条件
     * @return 返回值
     */
    List<TransferLine> selectList(TransferLine transferLine);

    /**
     * 根据主键查询（可关联表）
     *
     * @param transferLineId 主键
     * @return 返回值
     */
    TransferLine selectByPrimary(Long transferLineId);
}
