package com.cotte.estate.bean.pojo.eto;

import lombok.Data;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class OrderEto {
    private String code;
    private String customerName;
    private String poNum;
    private String item;
    private String part;
    private String color;
    private String bake;
    private BigDecimal count;
    private BigDecimal price;
    private BigDecimal sum;
    private BigDecimal partSumCount;
    private Integer partSumCountCal;
    private Integer outStroageGoodsSumCount;
    //组件总数-已出库良品组件总数
    private Integer partSumCountSubOutStroageGoodsSumCount;
    //出库组件超过订单组件的数量
    private Integer overPartSumCount;
    // 返镀数量
    private Integer replatCount;
    // 返镀比率
    private BigDecimal replatRatio;
    // 来料异常数量
    private Integer incomingCount;
    // 来料异常比率
    private BigDecimal incomingRatio;
    //出库类型为打底的组件数
    private Integer outStroagePrimingSumCount;
    //出库类型为打底的组件数/订单总数=打底比率
    private BigDecimal outStroagePrimingSumCountRatio;
    private String delTime;
    private Date deliveryTime;
    private String time;
}
