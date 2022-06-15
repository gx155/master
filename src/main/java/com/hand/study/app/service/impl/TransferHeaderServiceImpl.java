package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.TransferHeaderService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.TransferHeader;
import com.hand.study.domain.repository.TransferHeaderRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 调拨头信息表(TransferHeader)应用服务
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:34
 */
@Service
public class TransferHeaderServiceImpl implements TransferHeaderService {
    @Autowired
    private TransferHeaderRepository transferHeaderRepository;

    @Override
    public Page<TransferHeader> selectList(PageRequest pageRequest, TransferHeader transferHeader) {
        return PageHelper.doPageAndSort(pageRequest, () -> transferHeaderRepository.selectList(transferHeader));
    }

    @Override
    public void saveData(List<TransferHeader> transferHeaders) {
        List<TransferHeader> insertList = transferHeaders.stream().filter(line -> line.getTransferHeaderId() == null).collect(Collectors.toList());
        List<TransferHeader> updateList = transferHeaders.stream().filter(line -> line.getTransferHeaderId() != null).collect(Collectors.toList());
        transferHeaderRepository.batchInsertSelective(insertList);
        transferHeaderRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

