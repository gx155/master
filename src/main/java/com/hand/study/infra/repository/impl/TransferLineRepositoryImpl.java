package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.TransferLine;
import com.hand.study.domain.repository.TransferLineRepository;
import com.hand.study.infra.mapper.TransferLineMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 调拨单行表(TransferLine)资源库
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:35
 */
@Component
public class TransferLineRepositoryImpl extends BaseRepositoryImpl<TransferLine> implements TransferLineRepository {
    @Resource
    private TransferLineMapper transferLineMapper;

    @Override
    public List<TransferLine> selectList(TransferLine transferLine) {
        return transferLineMapper.selectList(transferLine);
    }

    @Override
    public TransferLine selectByPrimary(Long transferLineId) {
        TransferLine transferLine = new TransferLine();
        transferLine.setTransferLineId(transferLineId);
        List<TransferLine> transferLines = transferLineMapper.selectList(transferLine);
        if (transferLines.size() == 0) {
            return null;
        }
        return transferLines.get(0);
    }

}

