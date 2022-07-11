package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.MoInvoiceType;
import com.hand.study.domain.repository.MoInvoiceTypeRepository;
import com.hand.study.infra.mapper.MoInvoiceTypeMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应付发票类型(MoInvoiceType)资源库
 *
 * @author gx
 * @since 2022-07-11 12:24:34
 */
@Component
public class MoInvoiceTypeRepositoryImpl extends BaseRepositoryImpl<MoInvoiceType> implements MoInvoiceTypeRepository {
    @Resource
    private MoInvoiceTypeMapper moInvoiceTypeMapper;

    @Override
    public List<MoInvoiceType> selectList(MoInvoiceType moInvoiceType) {
        return moInvoiceTypeMapper.selectList(moInvoiceType);
    }

    @Override
    public MoInvoiceType selectByPrimary(Long moInvoiceTypeId) {
        MoInvoiceType moInvoiceType = new MoInvoiceType();
        moInvoiceType.setMoInvoiceTypeId(moInvoiceTypeId);
        List<MoInvoiceType> moInvoiceTypes = moInvoiceTypeMapper.selectList(moInvoiceType);
        if (moInvoiceTypes.size() == 0) {
            return null;
        }
        return moInvoiceTypes.get(0);
    }

}

