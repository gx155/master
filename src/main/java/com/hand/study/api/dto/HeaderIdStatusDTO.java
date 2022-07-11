package com.hand.study.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 状态更新
 * @date: 2022/7/6 17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeaderIdStatusDTO {
    private Long headerId;
    private String status;
}
