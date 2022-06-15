package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.TransferLineService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.TransferLine;
import com.hand.study.domain.repository.TransferLineRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 调拨单行表(TransferLine)应用服务
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:35
 */
@Service
public class TransferLineServiceImpl implements TransferLineService {
    @Autowired
    private TransferLineRepository transferLineRepository;

    @Override
    public Page<TransferLine> selectList(PageRequest pageRequest, TransferLine transferLine) {
        return PageHelper.doPageAndSort(pageRequest, () -> transferLineRepository.selectList(transferLine));
    }

    @Override
    public void saveData(List<TransferLine> transferLines) {
        List<TransferLine> insertList = transferLines.stream().filter(line -> line.getTransferLineId() == null).collect(Collectors.toList());
        List<TransferLine> updateList = transferLines.stream().filter(line -> line.getTransferLineId() != null).collect(Collectors.toList());
        transferLineRepository.batchInsertSelective(insertList);
        transferLineRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

