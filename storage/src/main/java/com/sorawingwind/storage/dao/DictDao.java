package com.sorawingwind.storage.dao;


import com.cotte.estate.bean.pojo.ao.storage.DictAo;
import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import com.cotte.estatecommon.RS;
import com.cotte.estatecommon.utils.ListUtil;
import io.ebean.Ebean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class DictDao {

    public RS getDictByType(String type) {
        List<DictDo> dictdo = Ebean.createQuery(DictDo.class).where().eq("type", type).findList();
        return RS.ok(new ListUtil<DictDo, DictAo>().copyList(dictdo, DictAo.class));
    }

    public List<DictDo> getDictDoByType(String type) {
        return Ebean.createQuery(DictDo.class).where().eq("type", type).findList();
    }

    public void save(DictDo doo) {
        Ebean.save(doo);
    }

    public DictDo getById(String id) {
        return Ebean.createQuery(DictDo.class).where().idEq(id).findOne();
    }

    public void delete(String id) {
        Ebean.delete(DictDo.class, id);
    }

    public void update(DictDo doo) {
        Ebean.update(doo);
    }

    /**
     * 检查字典值是否被业务数据使用
     * @param dictId 字典项ID
     * @param type 字典类型 customer/color/ct
     * @return 使用该字典值的数据数量
     */
    public int checkDictUsage(String dictId, String type) {
        int totalCount = 0;

        switch (type) {
            case "customer":
                // 检查订单表
                String orderSql = "SELECT COUNT(*) as count FROM b_order WHERE customer_name = :dictId AND is_delete = 0";
                totalCount += Ebean.createSqlQuery(orderSql)
                        .setParameter("dictId", dictId)
                        .findOne()
                        .getInteger("count");

                // 检查订单组表
                String orderGroupSql = "SELECT COUNT(*) as count FROM b_order_group WHERE customer_name = :dictId AND is_delete = 0";
                totalCount += Ebean.createSqlQuery(orderGroupSql)
                        .setParameter("dictId", dictId)
                        .findOne()
                        .getInteger("count");
                break;

            case "color":
                // 检查订单表
                String orderColorSql = "SELECT COUNT(*) as count FROM b_order WHERE color = :dictId AND is_delete = 0";
                totalCount += Ebean.createSqlQuery(orderColorSql)
                        .setParameter("dictId", dictId)
                        .findOne()
                        .getInteger("count");

                // 检查入库表
                String inStorageColorSql = "SELECT COUNT(*) as count FROM b_in_storage WHERE color = :dictId AND is_delete = 0";
                totalCount += Ebean.createSqlQuery(inStorageColorSql)
                        .setParameter("dictId", dictId)
                        .findOne()
                        .getInteger("count");
                break;

            case "ct":
                // 检查订单表
                String orderCtSql = "SELECT COUNT(*) as count FROM b_order WHERE bake = :dictId AND is_delete = 0";
                totalCount += Ebean.createSqlQuery(orderCtSql)
                        .setParameter("dictId", dictId)
                        .findOne()
                        .getInteger("count");

                // 检查入库表
                String inStorageCtSql = "SELECT COUNT(*) as count FROM b_in_storage WHERE bake = :dictId AND is_delete = 0";
                totalCount += Ebean.createSqlQuery(inStorageCtSql)
                        .setParameter("dictId", dictId)
                        .findOne()
                        .getInteger("count");
                break;

            default:
                return 0;
        }

        return totalCount;
    }
}
