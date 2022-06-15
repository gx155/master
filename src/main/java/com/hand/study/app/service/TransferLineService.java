package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.TransferLine;

import java.util.List;

/**
 * 调拨单行表(TransferLine)应用服务
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:35
 */
public interface TransferLineService {

    /**
     * 查询数据
     *
     * @param pageRequest   分页参数
     * @param transferLines 查询条件
     * @return 返回值
     */
    Page<TransferLine> selectList(PageRequest pageRequest, TransferLine transferLines);

    /**
     * 保存数据
     *
     * @param transferLines 数据
     */
    void saveData(List<TransferLine> transferLines);

}

