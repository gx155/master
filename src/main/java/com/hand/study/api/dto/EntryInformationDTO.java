package com.hand.study.api.dto;

import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.entity.PaymentLine37799;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 头行信息录入
 * @date: 2022/7/5 17:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryInformationDTO {
    PaymentHeader37799 paymentHeader37799;
    List<PaymentLine37799> paymentLine37799;
}
