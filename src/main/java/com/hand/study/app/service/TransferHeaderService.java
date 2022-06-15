package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.TransferHeader;

import java.util.List;

/**
 * 调拨头信息表(TransferHeader)应用服务
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:34
 */
public interface TransferHeaderService {

    /**
     * 查询数据
     *
     * @param pageRequest     分页参数
     * @param transferHeaders 查询条件
     * @return 返回值
     */
    Page<TransferHeader> selectList(PageRequest pageRequest, TransferHeader transferHeaders);

    /**
     * 保存数据
     *
     * @param transferHeaders 数据
     */
    void saveData(List<TransferHeader> transferHeaders);

}

