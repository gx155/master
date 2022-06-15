package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.TransferHeader;
import com.hand.study.domain.repository.TransferHeaderRepository;
import com.hand.study.infra.mapper.TransferHeaderMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 调拨头信息表(TransferHeader)资源库
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:33
 */
@Component
public class TransferHeaderRepositoryImpl extends BaseRepositoryImpl<TransferHeader> implements TransferHeaderRepository {
    @Resource
    private TransferHeaderMapper transferHeaderMapper;

    @Override
    public List<TransferHeader> selectList(TransferHeader transferHeader) {
        return transferHeaderMapper.selectList(transferHeader);
    }

    @Override
    public TransferHeader selectByPrimary(Long transferHeaderId) {
        TransferHeader transferHeader = new TransferHeader();
        transferHeader.setTransferHeaderId(transferHeaderId);
        List<TransferHeader> transferHeaders = transferHeaderMapper.selectList(transferHeader);
        if (transferHeaders.size() == 0) {
            return null;
        }
        return transferHeaders.get(0);
    }

}

