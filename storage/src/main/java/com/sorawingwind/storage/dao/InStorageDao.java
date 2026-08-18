package com.sorawingwind.storage.dao;

import com.cotte.estate.bean.pojo.bo.storage.InStorageBo;
import com.cotte.estate.bean.pojo.doo.storage.InStorageDo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estate.bean.pojo.eto.InStorageEto;
import io.ebean.Ebean;
import io.ebean.ExpressionList;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InStorageDao {
    public List<SqlRow> getByPage(int pageIndex, int pageSize, String customerNameItem, String item, String poNum, String incomingTypeItem, String code, String starttime, String endtime, String remainMin, String remainMax, String stayDaysMin, String stayDaysMax) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append("i.id,");
        sb.append("i.order_id,");
        sb.append("i.code,");
        sb.append("i.image,");
        sb.append("i.name,");
        sb.append("i.color,");
        sb.append("i.color as order_color,");
        sb.append("i.bunch_count,");
        sb.append("i.bake,");
        sb.append("i.in_count,");
        sb.append("i.unit,");
        sb.append("i.incoming_type,");
        sb.append("i.incoming_reason,");
        sb.append("i.bad_reason,");
        sb.append("i.create_time,");
        sb.append("i.modified_time,");
        sb.append("i.is_delete,");
        sb.append("o.customer_name,");
        sb.append("o.po_num,");
        sb.append("o.item,");
        sb.append("o.part,");
        sb.append("o.count,");
        sb.append("o.part_sum_count,");
        sb.append("o.code as order_code,");
        sb.append("ot.code as out_storage_code,");
        sb.append("(i.bunch_count - ifnull((select sum(ot2.bunch_count) from b_out_storage ot2 where ot2.in_storage_id = i.id and ot2.is_delete = 0), 0)) as remain_count,");
        sb.append("datediff(now(), i.create_time) as stay_days");
        sb.append(" from b_in_storage i left join b_order o on o.id = i.order_id left join b_out_storage ot on ot.id = i.out_storage_id where i.is_delete = 0 ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sb.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(incomingTypeItem)) {
            sb.append(" and i.incoming_type = :incomingTypeItem ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and i.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and i.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and i.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(remainMin)) {
            sb.append(" and (i.bunch_count - ifnull((select sum(ot2.bunch_count) from b_out_storage ot2 where ot2.in_storage_id = i.id and ot2.is_delete = 0), 0)) >= :remainMin ");
        }
        if (StringUtils.isNotBlank(remainMax)) {
            sb.append(" and (i.bunch_count - ifnull((select sum(ot2.bunch_count) from b_out_storage ot2 where ot2.in_storage_id = i.id and ot2.is_delete = 0), 0)) <= :remainMax ");
        }
        if (StringUtils.isNotBlank(stayDaysMin)) {
            sb.append(" and datediff(now(), i.create_time) >= :stayDaysMin ");
        }
        if (StringUtils.isNotBlank(stayDaysMax)) {
            sb.append(" and datediff(now(), i.create_time) <= :stayDaysMax ");
        }
        sb.append("order by i.create_time desc");
        SqlQuery sq = Ebean.createSqlQuery(sb.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("starttime", starttime).setParameter("endtime", endtime).setParameter("incomingTypeItem", incomingTypeItem).setParameter("remainMin", remainMin).setParameter("remainMax", remainMax).setParameter("stayDaysMin", stayDaysMin).setParameter("stayDaysMax", stayDaysMax);
        sq.setFirstRow((pageIndex - 1) * pageSize);
        sq.setMaxRows(pageSize);
        List<SqlRow> list = sq.findList();
        return list;
    }

    public int getCountByPage(int pageIndex, int pageSize, String customerNameItem, String item, String poNum, String incomingTypeItem, String code, String starttime, String endtime, String remainMin, String remainMax, String stayDaysMin, String stayDaysMax) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append(" count(*) as count");
        sb.append(" from b_in_storage i left join b_order o on o.id = i.order_id left join b_out_storage ot on ot.id = i.out_storage_id where i.is_delete = 0 ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sb.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sb.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sb.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(incomingTypeItem)) {
            sb.append(" and i.incoming_type = :incomingTypeItem ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sb.append(" and i.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sb.append(" and i.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sb.append(" and i.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(remainMin)) {
            sb.append(" and (i.bunch_count - ifnull((select sum(ot2.bunch_count) from b_out_storage ot2 where ot2.in_storage_id = i.id and ot2.is_delete = 0), 0)) >= :remainMin ");
        }
        if (StringUtils.isNotBlank(remainMax)) {
            sb.append(" and (i.bunch_count - ifnull((select sum(ot2.bunch_count) from b_out_storage ot2 where ot2.in_storage_id = i.id and ot2.is_delete = 0), 0)) <= :remainMax ");
        }
        if (StringUtils.isNotBlank(stayDaysMin)) {
            sb.append(" and datediff(now(), i.create_time) >= :stayDaysMin ");
        }
        if (StringUtils.isNotBlank(stayDaysMax)) {
            sb.append(" and datediff(now(), i.create_time) <= :stayDaysMax ");
        }
        int totleRowCount = 0;
        SqlRow sqlRow = Ebean.createSqlQuery(sb.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("starttime", starttime).setParameter("endtime", endtime).setParameter("incomingTypeItem", incomingTypeItem).setParameter("remainMin", remainMin).setParameter("remainMax", remainMax).setParameter("stayDaysMin", stayDaysMin).setParameter("stayDaysMax", stayDaysMax).findOne();
        if (sqlRow != null && !sqlRow.isEmpty()) {
            totleRowCount = sqlRow.getInteger("count");
        }
        return totleRowCount;
    }

    public List<SqlRow> getByIdstr(String idsStr) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select ");
        sb.append("i.id,");
        sb.append("i.order_id,");
        sb.append("i.code,");
        sb.append("i.image,");
        sb.append("i.name,");
        sb.append("i.color,");
        sb.append("i.color as order_color,");
        sb.append("i.bunch_count,");
        sb.append("i.bake,");
        sb.append("i.in_count,");
        sb.append("i.unit,");
        sb.append("i.incoming_type,");
        sb.append("i.incoming_reason,");
        sb.append("i.bad_reason,");
        sb.append("i.create_time,");
        sb.append("i.modified_time,");
        sb.append("i.is_delete,");
        sb.append("o.customer_name,");
        sb.append("o.po_num,");
        sb.append("o.item,");
        sb.append("o.part,");
        sb.append("o.count,");
        sb.append("o.code as order_code,");
        sb.append("ot.code as out_storage_code");
        sb.append(" from b_in_storage i left join b_order o on o.id = i.order_id left join b_out_storage ot on ot.id = i.out_storage_id where i.is_delete = 0 and i.id in (" + idsStr + ")");
        sb.append("order by i.create_time desc");
        return Ebean.createSqlQuery(sb.toString()).findList();
    }

    public int getCodeCount(Date start, Date end) {
        return Ebean.createQuery(InStorageDo.class).where().ge("create_time", start).le("create_time", end).findCount();
    }

    public void save(InStorageDo doo) {
        Ebean.save(doo);
    }

    public void update(InStorageDo doo) {
        Ebean.update(doo);
    }

    public List<InStorageDo> getByIds(List<String> ids) {
        return Ebean.createQuery(InStorageDo.class).where().idIn(ids).findList();
    }

    public void updateAll(List<InStorageDo> list) {
        Ebean.updateAll(list);
    }

    public int getMouthStatistics(Date start, Date end) {
        return Ebean.createQuery(InStorageDo.class).where().ge("create_time", start).lt("create_time", end).findCount();
    }

    public List<InStorageDo> getMouthStatisticsReratio(Date start, Date end) {
        return Ebean.createQuery(InStorageDo.class).where().ge("create_time", start).lt("create_time", end).findList();
    }

    public List<InStorageDo> getByCode(String code) {
        return Ebean.createQuery(InStorageDo.class).where().like("code", "%" + code + "%").eq("is_delete", false).findList();
    }

    public InStorageDo getById(String id) {
        return Ebean.createQuery(InStorageDo.class).where().idEq(id).findOne();
    }

    public List<InStorageDo> getByOrderId(String orderId,String inCode,String outCode,String inStarttime,String inEndtime,String outStarttime,String outEndtime) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select DISTINCT");
        sql.append(" i.id as id, ");
        sql.append(" o.item as item, ");
        sql.append(" i.image as image, ");
        sql.append(" i.bunch_count as bunchCount, ");
        sql.append(" i.incoming_type as incomingType, ");
        sql.append(" i.bad_reason as badReason, ");
        sql.append(" i.incoming_reason as incomingReason, ");
        sql.append(" i.code as code, ");
        sql.append(" i.create_time as createTime, ");
        sql.append(" o.part as part, ");
        sql.append(" i.color as orderColor, ");
        sql.append(" o.customer_name as customerName, ");
        sql.append(" o.po_num as poNum, ");
        sql.append(" i.bake as bake, ");
        sql.append(" o.count as count, ");
        sql.append(" i.in_count as inCount, ");
        sql.append(" i.unit as unit, ");
        sql.append(" i.create_time as createTime ");
        sql.append(" from ");
        sql.append(" b_in_storage i ");
        sql.append(" left join b_order o ");
        sql.append(" on o.id = i.order_id ");
        sql.append(" left join b_out_storage ot ");
        sql.append(" on i.id = ot.in_storage_id ");
        sql.append(" where i.is_delete = false ");
        if (StringUtils.isNotBlank(orderId)) {
            sql.append(" and o.id = :orderId ");
        }
        if (StringUtils.isNotBlank(inStarttime)) {
            sql.append(" and i.create_time >= :inStarttime ");
        }
        if (StringUtils.isNotBlank(inEndtime)) {
            sql.append(" and i.create_time <= :inEndtime ");
        }
        if (StringUtils.isNotBlank(inCode)) {
            sql.append(" and i.code like '%" + inCode + "%' ");
        }
        if (StringUtils.isNotBlank(outStarttime)) {
            sql.append(" and ot.create_time >= :outStarttime ");
        }
        if (StringUtils.isNotBlank(outEndtime)) {
            sql.append(" and ot.create_time <= :outEndtime ");
        }
        if (StringUtils.isNotBlank(outCode)) {
            sql.append(" and ot.code like '%" + outCode + "%' ");
        }
        sql.append(" order by i.create_time desc ");
        List<SqlRow> rows = Ebean.createSqlQuery(sql.toString()).setParameter("orderId", orderId).setParameter("inStarttime", inStarttime).setParameter("inEndtime", inEndtime).setParameter("outStarttime", outStarttime).setParameter("outEndtime", outEndtime).findList();
        return rows.stream().map(itemInner -> {
            InStorageDo eto = new InStorageDo();
            eto.setId(itemInner.getString("id"));
            eto.setImage(itemInner.getString("image"));
            eto.setCode(itemInner.getString("code"));
            eto.setInCount(itemInner.getString("inCount"));
            eto.setUnit(itemInner.getString("unit"));
            eto.setIncomingType(itemInner.getString("incomingType"));
            eto.setColor(itemInner.getString("orderColor"));
            eto.setBake(itemInner.getString("bake"));
            eto.setBunchCount(itemInner.getBigDecimal("bunchCount"));
            eto.setBadReason(itemInner.getString("badReason"));
            eto.setIncomingReason(itemInner.getString("incomingReason"));
            eto.setCreateTime(itemInner.getDate("createTime"));
            return eto;
        }).collect(Collectors.toList());
    }

    public List<InStorageDo> getByOutStorageId(String outStorageId) {
        return Ebean.createQuery(InStorageDo.class).where().eq("is_delete", 0).eq("out_storage_id", outStorageId).findList();
    }

    public List<InStorageEto> getExcels(String customerNameItem, String item, String poNum, String incomingType, String code, String starttime, String endtime) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select ");
        sql.append(" o.item as item, ");
        sql.append(" i.bunch_count as bunchCount, ");
        sql.append(" i.incoming_type as incomingType, ");
        sql.append(" i.bad_reason as badReason, ");
        sql.append(" i.code as code, ");
        sql.append(" i.create_time as createTime, ");
        sql.append(" o.part as part, ");
        sql.append(" i.color as orderColor, ");
        sql.append(" o.customer_name as customerName, ");
        sql.append(" o.po_num as poNum, ");
        sql.append(" i.bake as bake, ");
        sql.append(" o.count as count, ");
        sql.append(" o.part_sum_count as part_sum_count, ");
        sql.append(" i.in_count as inCount, ");
        sql.append(" i.unit as unit ");
        sql.append(" from ");
        sql.append(" b_in_storage i ");
        sql.append(" left join b_order o ");
        sql.append(" on o.id = i.order_id ");
        sql.append(" where i.is_delete = false ");
        if (StringUtils.isNotBlank(customerNameItem)) {
            sql.append(" and o.customer_name = :customerNameItem ");
        }
        if (StringUtils.isNotBlank(item)) {
            sql.append(" and o.item like :item ");
        }
        if (StringUtils.isNotBlank(poNum)) {
            sql.append(" and o.po_num like :poNum ");
        }
        if (StringUtils.isNotBlank(incomingType)) {
            sql.append(" and i.incoming_type = :incomingType ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sql.append(" and i.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sql.append(" and i.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sql.append(" and i.code like '%" + code + "%' ");
        }
        sql.append("order by i.create_time desc");
        List<SqlRow> rows = Ebean.createSqlQuery(sql.toString()).setParameter("customerNameItem", customerNameItem).setParameter("item", "%"+item+"%").setParameter("poNum", "%"+poNum+"%").setParameter("incomingType", incomingType).setParameter("code", code).setParameter("starttime", starttime).setParameter("endtime", endtime).findList();
        return rows.stream().map(itemInner -> {
            InStorageEto eto = new InStorageEto();
            eto.setCustomerName(itemInner.getString("customerName"));
            eto.setCode(itemInner.getString("code"));
            eto.setPart(itemInner.getString("part"));
            eto.setItem(itemInner.getString("item"));
            eto.setPoNum(itemInner.getString("poNum"));
            eto.setOrderColor(itemInner.getString("orderColor"));
            eto.setBake(itemInner.getString("bake"));
            eto.setCount(itemInner.getBigDecimal("count"));
            eto.setOrderPartSumCount(itemInner.getBigDecimal("part_sum_count") == null ? null : itemInner.getBigDecimal("part_sum_count").intValue());
            eto.setInCount(itemInner.getString("inCount"));
            eto.setUnit(itemInner.getString("unit"));
            eto.setIncomingType(itemInner.getString("incomingType"));
            eto.setBunchCount(itemInner.getBigDecimal("bunchCount"));
            eto.setBadReason(itemInner.getString("badReason"));
            eto.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itemInner.getDate("createTime")));
            return eto;
        }).collect(Collectors.toList());
    }

    public List<InStorageEto> getExcelsByOrder(String orderIds, String code, String starttime, String endtime,String outcode,String outstarttime,String outendtime) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select ");
        sql.append(" o.item as item, ");
        sql.append(" i.bunch_count as bunchCount, ");
        sql.append(" i.incoming_type as incomingType, ");
        sql.append(" i.bad_reason as badReason, ");
        sql.append(" i.code as code, ");
        sql.append(" i.create_time as createTime, ");
        sql.append(" o.part as part, ");
        sql.append(" i.color as orderColor, ");
        sql.append(" o.customer_name as customerName, ");
        sql.append(" o.po_num as poNum, ");
        sql.append(" i.bake as bake, ");
        sql.append(" o.count as count, ");
        sql.append(" o.part_sum_count as part_sum_count, ");
        sql.append(" i.in_count as inCount, ");
        sql.append(" i.unit as unit ");
        sql.append(" from ");
        sql.append(" b_in_storage i ");
        sql.append(" left join b_order o ");
        sql.append(" on o.id = i.order_id ");
        sql.append(" left join b_out_storage ot ");
        sql.append(" on i.id = ot.in_storage_id ");
        sql.append(" where i.is_delete = false ");
        if (StringUtils.isNotBlank(orderIds)) {
            sql.append(" and o.id in ("+orderIds+") ");
        }
        if (StringUtils.isNotBlank(starttime)) {
            sql.append(" and i.create_time >= :starttime ");
        }
        if (StringUtils.isNotBlank(endtime)) {
            sql.append(" and i.create_time <= :endtime ");
        }
        if (StringUtils.isNotBlank(code)) {
            sql.append(" and i.code like '%" + code + "%' ");
        }
        if (StringUtils.isNotBlank(outstarttime)) {
            sql.append(" and ot.create_time >= :outstarttime ");
        }
        if (StringUtils.isNotBlank(outendtime)) {
            sql.append(" and ot.create_time <= :outendtime ");
        }
        if (StringUtils.isNotBlank(outcode)) {
            sql.append(" and ot.code like '%" + outcode + "%' ");
        }
        sql.append("order by i.create_time desc");
        List<SqlRow> rows = Ebean.createSqlQuery(sql.toString()).setParameter("code", code).setParameter("starttime", starttime).setParameter("endtime", endtime).setParameter("outcode", outcode).setParameter("outstarttime", outstarttime).setParameter("outendtime", outendtime).findList();
        return rows.stream().map(itemInner -> {
            InStorageEto eto = new InStorageEto();
            eto.setCustomerName(itemInner.getString("customerName"));
            eto.setCode(itemInner.getString("code"));
            eto.setPart(itemInner.getString("part"));
            eto.setItem(itemInner.getString("item"));
            eto.setPoNum(itemInner.getString("poNum"));
            eto.setOrderColor(itemInner.getString("orderColor"));
            eto.setBake(itemInner.getString("bake"));
            eto.setCount(itemInner.getBigDecimal("count"));
            eto.setOrderPartSumCount(itemInner.getBigDecimal("part_sum_count") == null ? null : itemInner.getBigDecimal("part_sum_count").intValue());
            eto.setInCount(itemInner.getString("inCount"));
            eto.setUnit(itemInner.getString("unit"));
            eto.setIncomingType(itemInner.getString("incomingType"));
            eto.setBunchCount(itemInner.getBigDecimal("bunchCount"));
            eto.setBadReason(itemInner.getString("badReason"));
            eto.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itemInner.getDate("createTime")));
            return eto;
        }).collect(Collectors.toList());
    }
}
