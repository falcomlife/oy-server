package com.cotte.estate.bean.pojo.doo.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderGroupDo
 * @description: 订单组（多个订单组合成一个订单组）
 * @author: sora
 * @date: 2026-08-18
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name="`b_order_group`")
public class OrderGroupDo {
    @Id
    @GeneratedValue(generator="uuidGenerator")
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "image")
    private String image;
    @Column(name = "po_num")
    private String poNum;
    @Column(name = "product_no")
    private String productNo;
    @Column(name = "count")
    private BigDecimal count;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "sum")
    private BigDecimal sum;
    @Column(name = "serial_no")
    private String serialNo;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "modified_time")
    private Date modifiedTime;
    @Column(name = "is_delete")
    private Integer isDelete;
}
