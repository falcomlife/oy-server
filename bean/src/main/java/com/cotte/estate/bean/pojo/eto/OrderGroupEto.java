package com.cotte.estate.bean.pojo.eto;

import lombok.Data;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderGroupEto {
    private String customerName;
    private String code;
    private String serialNo;
    private String poNum;
    private String productNo;
    private BigDecimal count;
    private BigDecimal price;
    private BigDecimal sum;
    private Integer orderCount;
    private BigDecimal partSumCount;
    private Date createTime;
    private String time;
    // 入库明细行（主子表中的子行）字段：item号
    private String item;
    // 入库数量
    private BigDecimal inStorageCount;
    // 余量 = 入库数量 - 订单明细组件数 × 1.03
    private BigDecimal remainCount;
}
