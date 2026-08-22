package com.cotte.estate.bean.pojo.ao.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName orderAO
 * @description: 订单
 * @author: sora
 * @date: 2022-06-26
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderAo {
    @Id
    @GeneratedValue(generator="uuidGenerator")
    private String id;

    private String orderGroupId;

    private String orderGroupCode;

    private String code;

    private String customerName;

    private String customerNameId;

    private String image;

    private String poNum;

    private String item;

    private String part;

    private String productNo;

    private String color;

    private String bake;

    private String bakeId;

    private String colorId;

    private BigDecimal count;

    //订单组件总数
    private BigDecimal partSumCount;

    private Integer partSumCountCal;

    private Integer outStroageGoodsSumCount;

    //出库类型为打底的组件数
    private Integer outStroagePrimingSumCount;

    //出库类型为打底的组件数/订单总数=打底比率
    private BigDecimal outStroagePrimingSumCountRatio;

    private BigDecimal outStroageSumCount;

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

    private Boolean incomingBigger;

    private Boolean outStorageBigger;
    // 交货时间
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date deliveryTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    private Integer isDelete;
}
