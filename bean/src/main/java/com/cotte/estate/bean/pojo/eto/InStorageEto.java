package com.cotte.estate.bean.pojo.eto;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class InStorageEto {
    private String customerName;

    private String code;

    private String item;

    private String poNum;

    private String part;

    private String orderColor;

    private String bake;

    private BigDecimal count;
    // 订单组件数
    private Integer orderPartSumCount;
    // 组件数
    private BigDecimal bunchCount;

    private String unit;

    private String inCount;

    private String incomingType;

    private String badReason;

    private String time;
}
