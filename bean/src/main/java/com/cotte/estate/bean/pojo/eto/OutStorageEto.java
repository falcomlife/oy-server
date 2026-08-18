package com.cotte.estate.bean.pojo.eto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.date.DateDateConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OutStorageEto {
    private String code;
    private String orderCode;
    private String customerName;
    private String poNum;
    private String item;
    private String part;
    private String color;
    private String bake;
    private String count;
    private Integer orderPartSumCount;
    private String inCount;
    private String outCount;
    private BigDecimal bunchCount;
    private Integer leftPartSumCount;
    private String outType;
    private String time;
}
