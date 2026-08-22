package com.cotte.estate.bean.pojo.ao.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
*@description: 订单管理导出参数
*@author: sorawingwind
*@date: 2026/8/22
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderGroupExcelAo {

    private String customerNameItem;
    private String code;
    private String po;
    private String color;
    private String starttime;
    private String endtime;
}
