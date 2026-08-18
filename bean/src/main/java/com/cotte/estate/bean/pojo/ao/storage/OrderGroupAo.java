package com.cotte.estate.bean.pojo.ao.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderGroupAo
 * @description: 订单组
 * @author: sora
 * @date: 2026-08-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderGroupAo {
    @Id
    private String id;

    private String code;

    private String customerName;

    private String customerNameId;

    private String image;

    private String poNum;

    private BigDecimal count;

    // 组内订单数
    private Integer orderCount;

    // 组内订单组件总数合计
    private BigDecimal partSumCount;

    // 创建订单组时同步创建的组内订单
    private List<OrderAo> orders;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    private Integer isDelete;
}
