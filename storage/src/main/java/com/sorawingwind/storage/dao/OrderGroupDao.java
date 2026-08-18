package com.sorawingwind.storage.dao;

import com.cotte.estate.bean.pojo.doo.storage.OrderGroupDo;
import io.ebean.Ebean;
import io.ebean.ExpressionList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderGroupDao {

    public OrderGroupDo getById(String id) {
        return Ebean.createQuery(OrderGroupDo.class).where().idEq(id).findOne();
    }

    public List<OrderGroupDo> getByPage(int pageIndex, int pageSize, String customerNameItem, String code, String po, String starttime, String endtime) {
        ExpressionList<OrderGroupDo> el = Ebean.createQuery(OrderGroupDo.class).where().eq("is_delete", false);
        if (StringUtils.isNotBlank(customerNameItem)) {
            el.eq("customer_name", customerNameItem);
        }
        if (StringUtils.isNotBlank(code)) {
            el.like("code", "%" + code + "%");
        }
        if (StringUtils.isNotBlank(po)) {
            el.like("po_num", "%" + po + "%");
        }
        if (StringUtils.isNotBlank(starttime)) {
            el.ge("create_time", starttime);
        }
        if (StringUtils.isNotBlank(endtime)) {
            el.le("create_time", endtime);
        }
        return el.orderBy().desc("create_time").setFirstRow((pageIndex - 1) * pageSize).setMaxRows(pageSize).findList();
    }

    public int getCountByPage(String customerNameItem, String code, String po, String starttime, String endtime) {
        ExpressionList<OrderGroupDo> el = Ebean.createQuery(OrderGroupDo.class).where().eq("is_delete", false);
        if (StringUtils.isNotBlank(customerNameItem)) {
            el.eq("customer_name", customerNameItem);
        }
        if (StringUtils.isNotBlank(code)) {
            el.like("code", "%" + code + "%");
        }
        if (StringUtils.isNotBlank(po)) {
            el.like("po_num", "%" + po + "%");
        }
        if (StringUtils.isNotBlank(starttime)) {
            el.ge("create_time", starttime);
        }
        if (StringUtils.isNotBlank(endtime)) {
            el.le("create_time", endtime);
        }
        return el.findCount();
    }

    public void save(OrderGroupDo doo) {
        Ebean.save(doo);
    }

    public void update(OrderGroupDo doo) {
        Ebean.update(doo);
    }

    public void updateAll(List<OrderGroupDo> list) {
        Ebean.updateAll(list);
    }

    public List<OrderGroupDo> getByCode(String code) {
        return Ebean.createQuery(OrderGroupDo.class).where().like("code", "%" + code + "%").eq("is_delete", false).orderBy().desc("create_time").setMaxRows(20).findList();
    }
}
