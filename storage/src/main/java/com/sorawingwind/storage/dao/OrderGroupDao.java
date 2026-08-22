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

    public List<OrderGroupDo> getByPage(int pageIndex, int pageSize, String customerNameItem, String code, String po, String starttime, String endtime, String color) {
        ExpressionList<OrderGroupDo> el = this.buildQuery(customerNameItem, code, po, starttime, endtime, color);
        return el.orderBy().desc("create_time").setFirstRow((pageIndex - 1) * pageSize).setMaxRows(pageSize).findList();
    }

    public int getCountByPage(String customerNameItem, String code, String po, String starttime, String endtime, String color) {
        ExpressionList<OrderGroupDo> el = this.buildQuery(customerNameItem, code, po, starttime, endtime, color);
        return el.findCount();
    }

    private ExpressionList<OrderGroupDo> buildQuery(String customerNameItem, String code, String po, String starttime, String endtime, String color) {
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
        if (StringUtils.isNotBlank(color)) {
            // 按组内订单明细或其入库单的镀金颜色筛选订单
            el.raw("exists (select 1 from b_order o where o.order_group_id = t0.id and o.is_delete = 0 and o.color = ?) " +
                    "or exists (select 1 from b_in_storage i inner join b_order o2 on i.order_id = o2.id where o2.order_group_id = t0.id and i.is_delete = 0 and i.color = ?)", color, color);
        }
        return el;
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
