package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.TransferHeader;

import java.util.List;

/**
 * 调拨头信息表(TransferHeader)资源库
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:33
 */
public interface TransferHeaderRepository extends BaseRepository<TransferHeader> {
    /**
     * 查询
     *
     * @param transferHeader 查询条件
     * @return 返回值
     */
    List<TransferHeader> selectList(TransferHeader transferHeader);

    /**
     * 根据主键查询（可关联表）
     *
     * @param transferHeaderId 主键
     * @return 返回值
     */
    TransferHeader selectByPrimary(Long transferHeaderId);
}
