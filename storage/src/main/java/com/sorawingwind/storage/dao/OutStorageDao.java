package com.sorawingwind.storage.dao;

import com.cotte.estate.bean.pojo.ao.storage.OutStorageAo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estatecommon.enums.OutType;
import io.ebean.Ebean;
import io.ebean.ExpressionList;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OutStorageDao {

    public List<SqlRow> getByPage(int pageIndex, int pageSize, String customerNameItem, String item, String poNum, String code, String starttime, String endtime) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" ot.id, ");
        sb.append(" ot.in_storage_id, ");
        sb.append(" ot.bunch_count, ");
        sb.append(" ot.out_count, ");
        sb.append(" ot.code, ");
        sb.append(" ot.out_type, ");
        sb.append(" ot.create_time, ");
        sb.append(" ot.modified_time, ");
        sb.append(" ot.is_delete, ");
        sb.append(" o.customer_name, ");
        sb.append(" o.po_num, ");
        sb.append(" o.item, ");
        sb.append(" o.part, ");
        sb.append(" i.color, ");
        sb.append(" o.count, ");
        sb.append(" o.part_sum_count, ");
        sb.append(" o.code as order_code, ");
        sb.append(" i.code as in_storage_code, ");
        sb.append(" i.name as name, ");
        sb.append(" i.image as image, ");
        sb.append(" ot.image as otimage, ");
        sb.append(" i.bake as bake, ");
        sb.append(" i.bunch_count as in_count ");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append(" where ot.is_delete = 0 ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sb.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and ot.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and ot.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        sb.append("order by ot.create_time desc");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("customer_name_item", customerNameItem).setParameter("starttime", starttime).setParameter("endtime", endtime);
        sq.setFirstRow((pageIndex - 1) * pageSize);
        sq.setMaxRows(pageSize);
        return sq.findList();
    }

    public Integer getCountByPage(int pageIndex, int pageSize, String customerNameItem, String item, String poNum, String code, String starttime, String endtime) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" count(*) as count ");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append("  where ot.is_delete = 0  ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sb.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and ot.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and ot.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        return Ebean.createSqlQuery(sb.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("starttime", starttime).setParameter("endtime", endtime).findOne().getInteger("count");
    }

    public void save(OutStorageDo doo) {
        Ebean.save(doo);
    }

    public void update(OutStorageDo doo) {
        Ebean.update(doo);
    }

    public void updataAll(List<OutStorageDo> list) {
        Ebean.updateAll(list);
    }

    public List<SqlRow> getByCode(String code, String orderId, String item) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" ot.id, ");
        sb.append(" ot.in_storage_id, ");
        sb.append(" ot.bunch_count, ");
        sb.append(" ot.out_count, ");
        sb.append(" ot.code, ");
        sb.append(" ot.out_type, ");
        sb.append(" ot.create_time, ");
        sb.append(" ot.modified_time, ");
        sb.append(" ot.is_delete, ");
        sb.append(" o.customer_name, ");
        sb.append(" o.po_num, ");
        sb.append(" o.item, ");
        sb.append(" o.part, ");
        sb.append(" i.color, ");
        sb.append(" o.count, ");
        sb.append(" o.code as order_code, ");
        sb.append(" i.code as in_storage_code, ");
        sb.append(" i.name as name, ");
        sb.append(" i.image as image, ");
        sb.append(" i.bake as bake, ");
        sb.append(" i.in_count as in_count ");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append("  where ot.is_delete = 0  ");
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(orderId)) {
            sb.append(" and o.id = '" + orderId + "' ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item = '" + item + "' ");
        }
        return Ebean.createSqlQuery(sb.toString()).findList();
    }

    public List<OutStorageDo> getByInStorageId(String inStorageId,String outCode,String outStartTime,String outEndTime) {
        ExpressionList el = Ebean.createQuery(OutStorageDo.class).where().eq("is_delete", 0).eq("in_storage_id", inStorageId);
        if (StringUtils.isNotBlank(outCode)) {
            el.like("code","%"+outCode+"%");
        }
        if (StringUtils.isNotBlank(outStartTime)) {
            el.ge("create_time",outStartTime);
        }
        if (StringUtils.isNotBlank(outEndTime)) {
            el.le("create_time",outEndTime);
        }
        return el.findList();
    }

    public List<OutStorageDo> getById(String outStorageId,String outCode,String outStartTime,String outEndTime) {
        ExpressionList el =  Ebean.createQuery(OutStorageDo.class).where().eq("is_delete", 0).eq("id", outStorageId);
        if (StringUtils.isNotBlank(outCode)) {
            el.like("code","%"+outCode+"%");
        }
        if (StringUtils.isNotBlank(outStartTime)) {
            el.ge("create_time",outStartTime);
        }
        if (StringUtils.isNotBlank(outEndTime)) {
            el.le("create_time",outEndTime);
        }
        return el.findList();
    }

    public List<OutStorageAo> getExcels(String customerNameItem, String item, String poNum, String code, String starttime, String endtime) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" ot.id, ");
        sb.append(" ot.in_storage_id, ");
        sb.append(" ot.bunch_count, ");
        sb.append(" ot.out_count, ");
        sb.append(" ot.code, ");
        sb.append(" ot.out_type, ");
        sb.append(" ot.create_time, ");
        sb.append(" ot.modified_time, ");
        sb.append(" ot.is_delete, ");
        sb.append(" i.order_id as order_id, ");
        sb.append(" o.customer_name, ");
        sb.append(" o.po_num, ");
        sb.append(" o.item, ");
        sb.append(" o.part, ");
        sb.append(" i.color, ");
        sb.append(" o.count, ");
        sb.append(" o.part_sum_count, ");
        sb.append(" o.code as order_code, ");
        sb.append(" i.code as in_storage_code, ");
        sb.append(" i.name as name, ");
        sb.append(" i.image as image, ");
        sb.append(" i.bake as bake, ");
        sb.append(" i.bunch_count as in_count ");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append(" where ot.is_delete = 0 ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sb.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and ot.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and ot.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        sb.append("order by ot.create_time desc");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("customer_name_item", customerNameItem).setParameter("starttime", starttime).setParameter("endtime", endtime);
        List<SqlRow> list = sq.findList();
        List<OutStorageAo> listaor = list.stream().map(itemInner -> {
            OutStorageAo aoInner = new OutStorageAo();
            aoInner.setId(itemInner.getString("id"));
            aoInner.setOrderId(itemInner.getString("order_id"));
            aoInner.setOrderPartSumCount(itemInner.getBigDecimal("part_sum_count") == null ? null : itemInner.getBigDecimal("part_sum_count").intValue());
            aoInner.setInStorageId(itemInner.getString("in_storage_id"));
            aoInner.setInStorageCode(itemInner.getString("in_storage_code"));
            aoInner.setCode(itemInner.getString("code"));
            aoInner.setOrderCode(itemInner.getString("order_code"));
            aoInner.setBunchCount(itemInner.getBigDecimal("bunch_count"));
            aoInner.setCreateTime(itemInner.getDate("create_time"));
            aoInner.setImage(itemInner.getString("image"));
            aoInner.setOutCount(itemInner.getString("out_count"));
            aoInner.setName(itemInner.getString("name"));
            aoInner.setPoNum(itemInner.getString("po_num"));
            aoInner.setItem(itemInner.getString("item"));
            aoInner.setPart(itemInner.getString("part"));
            aoInner.setCount(itemInner.getString("count"));
            aoInner.setIsDelete(0);
            aoInner.setCustomerName(itemInner.getString("customer_name"));
            aoInner.setColor(itemInner.getString("color"));
            aoInner.setBake(itemInner.getString("bake"));
            aoInner.setOutTypeId(itemInner.getString("out_type"));
            aoInner.setOutType(OutType.getNameByIndex(Integer.parseInt(itemInner.getString("out_type"))));
            aoInner.setInCount(itemInner.getString("in_count"));
            return aoInner;
        }).collect(Collectors.toList());
        return listaor;
    }

    @Deprecated
    public Integer getSumBunchCount(String orderId) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" sum(ot.bunch_count) as sum");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append(" where ot.is_delete = 0 and o.id = :orderId ");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("orderId", orderId);
        SqlRow result = sq.findOne();
        return result.getInteger("sum");

    }

    public Map<String,Integer> getAllSumBunchCount(String customerNameItem, String item, String poNum, String code, String starttime, String endtime) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" sum(ot.bunch_count) as sum ,");
        sb.append(" o.id as orderId");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append(" where ot.is_delete = 0 ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sb.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and ot.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and ot.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        sb.append(" group by o.id ");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("customer_name_item", customerNameItem).setParameter("starttime", starttime).setParameter("endtime", endtime);
        return sq.findList().stream().collect(Collectors.toMap(i ->i.getString("orderId"),i -> i.getInteger("sum")));

    }

    public List<OutStorageAo> getExcelsByIn(String inids, String code, String starttime, String endtime) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" ot.id, ");
        sb.append(" ot.in_storage_id, ");
        sb.append(" ot.bunch_count, ");
        sb.append(" ot.out_count, ");
        sb.append(" ot.code, ");
        sb.append(" ot.out_type, ");
        sb.append(" ot.create_time, ");
        sb.append(" ot.modified_time, ");
        sb.append(" ot.is_delete, ");
        sb.append(" i.order_id as order_id, ");
        sb.append(" o.customer_name, ");
        sb.append(" o.po_num, ");
        sb.append(" o.item, ");
        sb.append(" o.part, ");
        sb.append(" i.color, ");
        sb.append(" o.count, ");
        sb.append(" o.part_sum_count, ");
        sb.append(" o.code as order_code, ");
        sb.append(" i.code as in_storage_code, ");
        sb.append(" i.name as name, ");
        sb.append(" i.image as image, ");
        sb.append(" i.bake as bake, ");
        sb.append(" i.bunch_count as in_count ");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append(" where ot.is_delete = 0 ");
        if (StringUtils.isNotBlank(inids)) {
            sb.append(" and i.id in ("+inids+") ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and ot.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and ot.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        sb.append("order by ot.create_time desc");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("starttime", starttime).setParameter("endtime", endtime);
        List<SqlRow> list = sq.findList();
        List<OutStorageAo> listaor = list.stream().map(itemInner -> {
            OutStorageAo aoInner = new OutStorageAo();
            aoInner.setId(itemInner.getString("id"));
            aoInner.setOrderId(itemInner.getString("order_id"));
            aoInner.setOrderPartSumCount(itemInner.getBigDecimal("part_sum_count") == null ? null : itemInner.getBigDecimal("part_sum_count").intValue());
            aoInner.setInStorageId(itemInner.getString("in_storage_id"));
            aoInner.setInStorageCode(itemInner.getString("in_storage_code"));
            aoInner.setCode(itemInner.getString("code"));
            aoInner.setBunchCount(itemInner.getBigDecimal("bunch_count"));
            aoInner.setCreateTime(itemInner.getDate("create_time"));
            aoInner.setImage(itemInner.getString("image"));
            aoInner.setOutCount(itemInner.getString("out_count"));
            aoInner.setName(itemInner.getString("name"));
            aoInner.setPoNum(itemInner.getString("po_num"));
            aoInner.setItem(itemInner.getString("item"));
            aoInner.setPart(itemInner.getString("part"));
            aoInner.setCount(itemInner.getString("count"));
            aoInner.setIsDelete(0);
            aoInner.setCustomerName(itemInner.getString("customer_name"));
            aoInner.setColor(itemInner.getString("color"));
            aoInner.setBake(itemInner.getString("bake"));
            aoInner.setOutTypeId(itemInner.getString("out_type"));
            aoInner.setOutType(OutType.getNameByIndex(Integer.parseInt(itemInner.getString("out_type"))));
            aoInner.setInCount(itemInner.getString("in_count"));
            return aoInner;
        }).collect(Collectors.toList());
        return listaor;
    }

    public Map<String, Integer> getAllSumBunchCount(String inids, String code, String starttime, String endtime) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" sum(ot.bunch_count) as sum ,");
        sb.append(" o.id as orderId");
        sb.append(" from b_out_storage ot ");
        sb.append(" left join b_in_storage i on ot.in_storage_id = i.id");
        sb.append(" left join `b_order` o on o.id = i.order_id");
        sb.append(" where ot.is_delete = 0 ");
        if (StringUtils.isNotBlank(inids)) {
            sb.append(" and i.id in ("+inids+") ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and ot.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and ot.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and ot.code like '%" + code + "%' ");
        }
        sb.append(" group by o.id ");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("starttime", starttime).setParameter("endtime", endtime);
        return sq.findList().stream().collect(Collectors.toMap(i ->i.getString("orderId"),i -> i.getInteger("sum")));
    }
}
