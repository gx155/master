package com.hand.study.infra.repository.impl;

import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.DetailsHelper;
import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentLine37799Repository;
import com.hand.study.infra.mapper.PaymentLine37799Mapper;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单据行表(PaymentLine37799)资源库
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */
@Component
public class PaymentLine37799RepositoryImpl extends BaseRepositoryImpl<PaymentLine37799> implements PaymentLine37799Repository {
    @Resource
    private PaymentLine37799Mapper paymentLine37799Mapper;

    @Autowired
    private PaymentLine37799Repository paymentLine37799Repository;

    @Autowired
    private PaymentHeader37799Repository paymentHeader37799Repository;

    @Override
    public List<PaymentLine37799> selectList(PaymentLine37799 paymentLine37799) {
        return paymentLine37799Mapper.selectList(paymentLine37799);
    }

    @Override
    public PaymentLine37799 selectByPrimary(Long lineId) {
        PaymentLine37799 paymentLine37799 = new PaymentLine37799();
        paymentLine37799.setLineId(lineId);
        List<PaymentLine37799> paymentLine37799s = paymentLine37799Mapper.selectList(paymentLine37799);
        if (paymentLine37799s.size() == 0) {
            return null;
        }
        return paymentLine37799s.get(0);
    }

    @Override
    public void deleteByLineId(Long lineId) {
        PaymentLine37799 paymentLine37799 = paymentLine37799Repository.selectByCondition(Condition.builder(PaymentLine37799.class)
                .andWhere(Sqls.custom().andEqualTo(PaymentLine37799.FIELD_LINE_ID, lineId)).build()).get(0);
        if (ObjectUtils.isEmpty(paymentLine37799)){
            throw new CommonException("hfins.fm.error.common.37799");
        }


        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Repository.selectByCondition(Condition.builder(PaymentHeader37799.class)
                .andWhere(Sqls.custom().andEqualTo(PaymentHeader37799.FIELD_HEADER_ID, paymentLine37799.getHeaderId())).build()).get(0);
        //校验当前用户
        if(paymentHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
            throw new CommonException("hfins.fm.error.common.02.37799");
        }

        if (!("NEW".equals(paymentHeader37799.getPaymentStatus())  || "REJECTED".equals(paymentHeader37799.getPaymentStatus())) ){
            throw new CommonException("hfins.fm.error.state1.37799");
        }


        paymentLine37799Mapper.deleteByPrimaryKey(lineId);
    }

}

