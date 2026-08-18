package com.sorawingwind.storage.dao;

import com.cotte.estate.bean.pojo.doo.storage.InStorageDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estate.bean.pojo.eto.OrderEto;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.ebean.Ebean;
import io.ebean.ExpressionList;
import io.ebean.SqlRow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderDao {

    public OrderDo getById(String id) {
        return Ebean.createQuery(OrderDo.class).where().idEq(id).findOne();
    }

    public List<OrderDo> getByPage(int pageIndex, int pageSize, String customerNameItem, String code, String inCode, String outCode, String incomingType, String po, String item, String starttime, String endtime, String inStarttime, String inEndtime, String outStarttime, String outEndtime, String deliveryStart, String deliveryEnd) {

        StringBuffer sb = new StringBuffer();
        sb.append(" select DISTINCT o.id,o.code,o.customer_name,o.image,o.po_num,o.item,o.part,o.count,o.part_sum_count,o.price,o.sum,o.create_time,o.modified_time,o.is_delete,o.delivery_time,o.order_group_id from b_order as o ");
        sb.append(" left join b_in_storage as i on o.id = i.order_id ");
        sb.append(" left join b_out_storage as ou on i.id = ou.in_storage_id ");
        sb.append(" where ");
        sb.append(" o.is_delete = false");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = '" + customerNameItem + "'");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and o.create_time >= '" + starttime + "' ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and o.create_time <= '" + endtime + "' ");
        }
        if (StringUtils.isNotBlank(deliveryStart)) {
            sb.append(" and o.delivery_time >= '" + deliveryStart + "' ");
        }
        if (StringUtils.isNotBlank(deliveryEnd)) {
            sb.append(" and o.delivery_time <= '" + deliveryEnd + "' ");
        }
        if (StringUtils.isNotBlank(inStarttime)) {
            sb.append(" and i.create_time >= '" + inStarttime + "' ");
        }
        if (StringUtils.isNotBlank(inEndtime)) {
            sb.append(" and i.create_time <= '" + inEndtime + "' ");
        }
        if (StringUtils.isNotBlank(outStarttime)) {
            sb.append(" and ou.create_time >= '" + outStarttime + "' ");
        }
        if (StringUtils.isNotBlank(outEndtime)) {
            sb.append(" and ou.create_time <= '" + outEndtime + "' ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and o.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(po)) {
            sb.append(" and o.po_num like '%" + po + "%' ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like '%" + item + "%' ");
        }
        if (StringUtils.isNotBlank(inCode)) {
            sb.append(" and i.code like '%" + inCode + "%' ");
        }
        if (StringUtils.isNotBlank(outCode)) {
            sb.append(" and ou.code like '%" + outCode + "%' ");
        }
        if (StringUtils.isNotBlank(incomingType)) {
            sb.append(" and i.incoming_type = '" + incomingType + "' ");
        }
        if (StringUtils.isBlank(customerNameItem)) {
            sb.append(" order by o.create_time desc ");
        } else {
            sb.append(" order by o.po_num desc ,o.create_time desc");
        }
        List<SqlRow> rows = Ebean.createSqlQuery(sb.toString()).setFirstRow((pageIndex - 1) * pageSize).setMaxRows(pageSize).findList();
        return rows.stream().map(row -> {
            OrderDo o = new OrderDo();
            o.setId(row.getString("id"));
            o.setCode(row.getString("code"));
            o.setCreateTime(row.getDate("create_time"));
            o.setCustomerName(row.getString("customer_name"));
            o.setModifiedTime(row.getDate("modified_time"));
            o.setDeliveryTime(row.getDate("delivery_time"));
            o.setCount(row.getBigDecimal("count"));
            o.setImage(row.getString("image"));
            o.setItem(row.getString("item"));
            o.setPart(row.getString("part"));
            o.setPartSumCount(row.getBigDecimal("part_sum_count"));
            o.setPoNum(row.getString("po_num"));
            o.setPrice(row.getBigDecimal("price"));
            o.setSum(row.getBigDecimal("sum"));
            o.setOrderGroupId(row.getString("order_group_id"));
            return o;
        }).collect(Collectors.toList());
    }

    public int getCountByPage(int pageIndex, int pageSize, String customerNameItem, String code, String inCode, String outCode, String incomingType, String po, String item, String starttime, String endtime, String inStarttime, String inEndtime, String outStarttime, String outEndtime, String deliveryStart, String deliveryEnd) {

        StringBuffer sb = new StringBuffer();
        sb.append(" select DISTINCT o.id,o.code,o.customer_name,o.image,o.po_num,o.item,o.part,o.count,o.part_sum_count,o.price,o.sum,o.create_time,o.modified_time,o.is_delete,o.order_group_id from b_order as o ");
        sb.append(" left join b_in_storage as i on o.id = i.order_id ");
        sb.append(" left join b_out_storage as ou on i.id = ou.in_storage_id ");
        sb.append(" where ");
        sb.append(" o.is_delete = false");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = '" + customerNameItem + "'");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and o.create_time >= '" + starttime + "' ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and o.create_time <= '" + endtime + "' ");
        }
        if (StringUtils.isNotBlank(deliveryStart)) {
            sb.append(" and o.delivery_time >= '" + deliveryStart + "' ");
        }
        if (StringUtils.isNotBlank(deliveryEnd)) {
            sb.append(" and o.delivery_time <= '" + deliveryEnd + "' ");
        }
        if (StringUtils.isNotBlank(inStarttime)) {
            sb.append(" and i.create_time >= '" + inStarttime + "' ");
        }
        if (StringUtils.isNotBlank(inEndtime)) {
            sb.append(" and i.create_time <= '" + inEndtime + "' ");
        }
        if (StringUtils.isNotBlank(outStarttime)) {
            sb.append(" and ou.create_time >= '" + outStarttime + "' ");
        }
        if (StringUtils.isNotBlank(outEndtime)) {
            sb.append(" and ou.create_time <= '" + outEndtime + "' ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and o.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(po)) {
            sb.append(" and o.po_num like '%" + po + "%' ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like '%" + item + "%' ");
        }
        if (StringUtils.isNotBlank(inCode)) {
            sb.append(" and i.code like '%" + inCode + "%' ");
        }
        if (StringUtils.isNotBlank(outCode)) {
            sb.append(" and ou.code like '%" + outCode + "%' ");
        }
        if (StringUtils.isNotBlank(incomingType)) {
            sb.append(" and i.incoming_type = '" + incomingType + "' ");
        }
        if (StringUtils.isBlank(customerNameItem)) {
            sb.append(" order by o.create_time desc ");
        } else {
            sb.append(" order by o.po_num desc ,o.create_time desc");
        }
        return Ebean.createSqlQuery(sb.toString()).findList().size();
    }

    public void save(OrderDo doo) {
        Ebean.save(doo);
    }

    public void update(OrderDo doo) {
        Ebean.update(doo);
    }

    public void updateAll(List<OrderDo> list) {
        Ebean.updateAll(list);
    }

    public Integer getCountBetweenTimes(Date start, Date end) {
        return Ebean.createQuery(OrderDo.class).where().ge("create_time", start).lt("create_time", end).findCount();
    }

    public List<SqlRow> getCountBetweenTimesWithColor(String startStr, String endStr) {
        return Ebean.createSqlQuery("select color,sum( `part_sum_count` ) as count from `b_order` where part_sum_count is not null and create_time >= :start and create_time <= :end and is_delete = 0 GROUP BY color order by count asc").setParameter("start", startStr).setParameter("end", endStr).findList();
    }

    public List<SqlRow> getCountBetweenTimesWithCustomer(String startStr, String endStr) {
        return Ebean.createSqlQuery("select customer_name,sum( `part_sum_count` ) as count from `b_order` where part_sum_count is not null and create_time >= :start and create_time <= :end and is_delete = 0 GROUP BY customer_name order by count desc").setParameter("start", startStr).setParameter("end", endStr).findList();
    }

    public List<OrderDo> getByCode(String code) {
        return Ebean.createQuery(OrderDo.class).where().like("code", "%" + code + "%").eq("is_delete", false).findList();
    }

    public List<OrderDo> getExcels(String customerNameItem, String code, String inCode, String outCode, String incomingType, String po, String item, String starttime, String endtime, String inStarttime, String inEndtime, String outStarttime, String outEndtime, String deliveryStart, String deliveryEnd) {

        StringBuffer sb = new StringBuffer();
        sb.append(" select DISTINCT o.id,o.code,o.customer_name,o.image,o.po_num,o.item,o.part,o.count,o.part_sum_count,o.price,o.sum,o.create_time,o.modified_time,o.delivery_time,o.is_delete,o.order_group_id from b_order as o ");
        sb.append(" left join b_in_storage as i on o.id = i.order_id ");
        sb.append(" left join b_out_storage as ou on i.id = ou.in_storage_id ");
        sb.append(" where ");
        sb.append(" o.is_delete = false");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = '" + customerNameItem + "'");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and o.create_time >= '" + starttime + "' ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and o.create_time <= '" + endtime + "' ");
        }
        if (StringUtils.isNotBlank(deliveryStart)) {
            sb.append(" and o.delivery_time >= '" + deliveryStart + "' ");
        }
        if (StringUtils.isNotBlank(deliveryEnd)) {
            sb.append(" and o.delivery_time <= '" + deliveryEnd + "' ");
        }
        if (StringUtils.isNotBlank(inStarttime)) {
            sb.append(" and i.create_time >= '" + inStarttime + "' ");
        }
        if (StringUtils.isNotBlank(inEndtime)) {
            sb.append(" and i.create_time <= '" + inEndtime + "' ");
        }
        if (StringUtils.isNotBlank(outStarttime)) {
            sb.append(" and ou.create_time >= '" + outStarttime + "' ");
        }
        if (StringUtils.isNotBlank(outEndtime)) {
            sb.append(" and ou.create_time <= '" + outEndtime + "' ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and o.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(po)) {
            sb.append(" and o.po_num like '%" + po + "%' ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like '%" + item + "%' ");
        }
        if (StringUtils.isNotBlank(inCode)) {
            sb.append(" and i.code like '%" + inCode + "%' ");
        }
        if (StringUtils.isNotBlank(outCode)) {
            sb.append(" and ou.code like '%" + outCode + "%' ");
        }
        if (StringUtils.isNotBlank(incomingType)) {
            sb.append(" and i.incoming_type = '" + incomingType + "' ");
        }
        if (StringUtils.isBlank(customerNameItem)) {
            sb.append(" order by o.create_time desc ");
        } else {
            sb.append(" order by o.po_num desc ,o.create_time desc");
        }
        List<SqlRow> rows = Ebean.createSqlQuery(sb.toString()).findList();
        return rows.stream().map(row -> {
            OrderDo o = new OrderDo();
            o.setId(row.getString("id"));
            o.setCode(row.getString("code"));
            o.setCreateTime(row.getDate("create_time"));
            o.setCustomerName(row.getString("customer_name"));
            o.setModifiedTime(row.getDate("modified_time"));
            o.setDeliveryTime(row.getDate("delivery_time"));
            o.setCount(row.getBigDecimal("count"));
            o.setImage(row.getString("image"));
            o.setItem(row.getString("item"));
            o.setPart(row.getString("part"));
            o.setPartSumCount(row.getBigDecimal("part_sum_count"));
            o.setPoNum(row.getString("po_num"));
            o.setPrice(row.getBigDecimal("price"));
            o.setSum(row.getBigDecimal("sum"));
            o.setOrderGroupId(row.getString("order_group_id"));
            return o;
        }).collect(Collectors.toList());
    }

    public List<String> loadParts() {
        return Ebean.createQuery(OrderDo.class).where().eq("is_delete", false).findList().stream().map(OrderDo::getPart).filter(item -> StringUtils.isNotBlank(item)).distinct().collect(Collectors.toList());
    }

    public List<String> loadPonums() {
        return Ebean.createQuery(OrderDo.class).where().eq("is_delete", false).findList().stream().map(OrderDo::getPoNum).filter(item -> StringUtils.isNotBlank(item)).distinct().collect(Collectors.toList());
    }

    public List<String> loadItems() {
        return Ebean.createQuery(OrderDo.class).where().eq("is_delete", false).findList().stream().map(OrderDo::getItem).filter(item -> StringUtils.isNotBlank(item)).distinct().collect(Collectors.toList());
    }

    public List<String> loadPonumItems(String item) {
        List<OrderDo> orders = Ebean.createQuery(OrderDo.class).where().eq("item", item).eq("is_delete", false).findList();
        return orders.stream().map(OrderDo::getPart).filter(i -> StringUtils.isNotBlank(i)).distinct().collect(Collectors.toList());
    }

    public Map<String, String> loadInfoByItemPart(String item, String part) {
        List<OrderDo> orderDos = Ebean.createQuery(OrderDo.class).where().eq("item", item).eq("part", part).eq("is_delete", false).findList();
        OrderDo doo = null;
        if (orderDos != null && !orderDos.isEmpty()) {
            doo = orderDos.get(0);
            Map<String, String> map = new HashMap<>();
            map.put("partCount", doo.getPartSumCount().divide(doo.getCount(), 0, BigDecimal.ROUND_HALF_UP).toString());
            return map;
        } else {
            return null;
        }
    }

    public List<InStorageDo> getInStorageByOrderIds(List<String> orderIds, String inCode, String inStarttime, String inEndtime) {
        ExpressionList<InStorageDo> el = Ebean.createQuery(InStorageDo.class).where().in("order_id", orderIds);
        if (StringUtils.isNotBlank(inCode)) {
            el.like("code", "%" + inCode + "%");
        }
        if (StringUtils.isNotBlank(inStarttime)) {
            el.ge("create_time", inStarttime);
        }
        if (StringUtils.isNotBlank(inEndtime)) {
            el.le("create_time", inEndtime);
        }
        return el.eq("is_delete", 0).findList();
    }

    public List<OutStorageDo> getOutStorageByInStorageIds(List<String> inStorageIds, String outCode, String outStarttime, String outEndtime) {
        ExpressionList<OutStorageDo> el = Ebean.createQuery(OutStorageDo.class).where().in("in_storage_id", inStorageIds);
        if (StringUtils.isNotBlank(outCode)) {
            el.like("code", "%" + outCode + "%");
        }
        if (StringUtils.isNotBlank(outStarttime)) {
            el.ge("create_time", outStarttime);
        }
        if (StringUtils.isNotBlank(outEndtime)) {
            el.le("create_time", outEndtime);
        }
        return el.eq("is_delete", 0).findList();
    }
}
