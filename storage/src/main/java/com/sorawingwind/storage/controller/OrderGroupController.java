package com.sorawingwind.storage.controller;

import com.cotte.estate.bean.pojo.ao.storage.OrderAo;
import com.cotte.estate.bean.pojo.ao.storage.OrderGroupAo;
import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderGroupDo;
import com.cotte.estatecommon.PageRS;
import com.cotte.estatecommon.RS;
import com.cotte.estatecommon.utils.CodeGenerUtil;
import com.cotte.estatecommon.utils.ListUtil;
import com.cotte.estatecommon.utils.UUIDUtil;
import com.sorawingwind.storage.dao.OrderGroupDao;
import io.ebean.Ebean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderGroup")
public class OrderGroupController {

    @Autowired
    private OrderGroupDao dao;
    @Autowired
    private DictController dictController;

    @GetMapping
    @PreAuthorize("hasAuthority('I-9')")
    public RS getByPage(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) String customerNameItem, @RequestParam(required = false) String code, @RequestParam(required = false) String po, @RequestParam(required = false) String starttime, @RequestParam(required = false) String endtime, @RequestParam(required = false) String color) {
        List<OrderGroupDo> list = this.dao.getByPage(pageIndex, pageSize, customerNameItem, code, po, starttime, endtime, color);
        int totalRowCount = this.dao.getCountByPage(customerNameItem, code, po, starttime, endtime, color);
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");

        // 组内订单统计
        List<String> groupIds = list.stream().map(OrderGroupDo::getId).collect(Collectors.toList());
        List<OrderDo> listOrder = new ArrayList<>();
        if (!groupIds.isEmpty()) {
            listOrder = Ebean.createQuery(OrderDo.class).where().in("order_group_id", groupIds).eq("is_delete", 0).findList();
        }

        List<OrderGroupAo> listao = new ArrayList<>();
        for (OrderGroupDo doo : list) {
            OrderGroupAo ao = new OrderGroupAo();
            BeanUtils.copyProperties(doo, ao);
            List<OrderDo> groupOrders = listOrder.stream().filter(o -> doo.getId().equals(o.getOrderGroupId())).collect(Collectors.toList());
            // 组内订单数
            ao.setOrderCount(groupOrders.size());
            // 组内订单组件总数合计
            ao.setPartSumCount(groupOrders.stream().map(OrderDo::getPartSumCount).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add));
            if (StringUtils.isNotBlank(doo.getCustomerName())) {
                ao.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(doo.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(doo.getCustomerName()));
            }
            ao.setCustomerNameId(doo.getCustomerName());
            listao.add(ao);
        }
        return RS.ok(new PageRS<>(pageSize, pageIndex, totalRowCount, totalRowCount / pageSize, listao));
    }

    /**
     * @description: 打印时根据选中的数据重新查询
     * @author: sorawingwind
     */
    @PostMapping("/ids")
    @PreAuthorize("hasAuthority('I-9')")
    public RS getByIds(@RequestBody List<String> ids) {
        List<OrderGroupDo> list = Ebean.createQuery(OrderGroupDo.class).where().idIn(ids).eq("is_delete", 0).findList();
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");

        // 组内订单统计
        List<String> groupIds = list.stream().map(OrderGroupDo::getId).collect(Collectors.toList());
        List<OrderDo> listOrder = new ArrayList<>();
        if (!groupIds.isEmpty()) {
            listOrder = Ebean.createQuery(OrderDo.class).where().in("order_group_id", groupIds).eq("is_delete", 0).findList();
        }

        List<OrderGroupAo> listao = new ArrayList<>();
        for (OrderGroupDo doo : list) {
            OrderGroupAo ao = new OrderGroupAo();
            BeanUtils.copyProperties(doo, ao);
            List<OrderDo> groupOrders = listOrder.stream().filter(o -> doo.getId().equals(o.getOrderGroupId())).collect(Collectors.toList());
            // 组内订单数
            ao.setOrderCount(groupOrders.size());
            // 组内订单组件总数合计
            ao.setPartSumCount(groupOrders.stream().map(OrderDo::getPartSumCount).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add));
            if (StringUtils.isNotBlank(doo.getCustomerName())) {
                ao.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(doo.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(doo.getCustomerName()));
            }
            ao.setCustomerNameId(doo.getCustomerName());
            listao.add(ao);
        }
        return RS.ok(listao);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('I-9')")
    public RS save(@RequestBody OrderGroupAo orderGroupAo) {
        OrderGroupDo doo = new OrderGroupDo();
        BeanUtils.copyProperties(orderGroupAo, doo);
        // 新增表单只传customerName（存的是字典id），customerNameId为空时不能覆盖
        doo.setCustomerName(StringUtils.isNotBlank(orderGroupAo.getCustomerNameId()) ? orderGroupAo.getCustomerNameId() : orderGroupAo.getCustomerName());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        int count = Ebean.createQuery(OrderGroupDo.class).where().ge("create_time", start).le("create_time", end).findCount();
        doo.setCode(CodeGenerUtil.getCode("OG", count));
        doo.setId(UUIDUtil.simpleUUid());
        doo.setCreateTime(new Date());
        doo.setIsDelete(0);
        // 总价 = 单价 × 数量
        if (doo.getPrice() != null && doo.getCount() != null) {
            doo.setSum(doo.getPrice().multiply(doo.getCount()));
        }

        // 同步创建的组内订单（行内ITEM号为空的忽略）
        List<OrderAo> orders = orderGroupAo.getOrders() == null ? new ArrayList<>() : orderGroupAo.getOrders().stream()
                .filter(item -> item != null && StringUtils.isNotBlank(item.getItem()))
                .collect(Collectors.toList());
        if (!orders.isEmpty() && doo.getCount() == null) {
            // 未手填组数量时，取组内订单数量之和
            doo.setCount(orders.stream().map(OrderAo::getCount).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add));
        }
        List<OrderDo> orderDos = new ArrayList<>();
        if (!orders.isEmpty()) {
            int orderCount = Ebean.createQuery(OrderDo.class).where().ge("create_time", start).le("create_time", end).findCount();
            int i = 0;
            for (OrderAo orderAo : orders) {
                OrderDo orderDoo = new OrderDo();
                BeanUtils.copyProperties(orderAo, orderDoo);
                orderDoo.setOrderGroupId(doo.getId());
                orderDoo.setCustomerName(doo.getCustomerName());
                // 行内未填PO号/图片时继承订单组的
                if (StringUtils.isBlank(orderDoo.getPoNum())) {
                    orderDoo.setPoNum(doo.getPoNum());
                }
                if (StringUtils.isBlank(orderDoo.getImage())) {
                    orderDoo.setImage(doo.getImage());
                }
                orderDoo.setCode(CodeGenerUtil.getCode("OR", orderCount + i));
                orderDoo.setId(UUIDUtil.simpleUUid());
                orderDoo.setCreateTime(new Date());
                orderDoo.setIsDelete(0);
                orderDos.add(orderDoo);
                i++;
            }
        }

        // 同一事务内创建订单组与组内订单，任一失败整体回滚
        Ebean.beginTransaction();
        try {
            this.dao.save(doo);
            for (OrderDo orderDoo : orderDos) {
                Ebean.save(orderDoo);
            }
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
        return RS.ok();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('I-9')")
    public RS update(@RequestBody OrderGroupAo orderGroupAo) {
        OrderGroupDo doo = new OrderGroupDo();
        BeanUtils.copyProperties(orderGroupAo, doo);
        doo.setCustomerName(orderGroupAo.getCustomerNameId());
        doo.setModifiedTime(new Date());
        doo.setIsDelete(0);
        // 总价 = 单价 × 数量
        if (doo.getPrice() != null && doo.getCount() != null) {
            doo.setSum(doo.getPrice().multiply(doo.getCount()));
        }
        this.dao.update(doo);
        return RS.ok();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('I-9')")
    public RS delete(@RequestBody List<String> ids) {
        for (String id : ids) {
            int orderCount = Ebean.createQuery(OrderDo.class).where().eq("order_group_id", id).eq("is_delete", 0).findCount();
            if (orderCount > 0) {
                OrderGroupDo doo = this.dao.getById(id);
                return RS.warn("订单组[" + (doo == null ? id : doo.getCode()) + "]下存在" + orderCount + "个订单，请先删除或移出组内订单。");
            }
        }
        List<OrderGroupDo> list = Ebean.createQuery(OrderGroupDo.class).where().idIn(ids).findList();
        for (OrderGroupDo doo : list) {
            doo.setIsDelete(1);
        }
        this.dao.updateAll(list);
        return RS.ok();
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('I-9')")
    public RS getOrdersByGroupId(@RequestParam String groupId) {
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<OrderAo> listao = Ebean.createQuery(OrderDo.class).where().eq("order_group_id", groupId).eq("is_delete", 0).orderBy().desc("create_time").findList().stream().map(doo -> {
            OrderAo ao = new OrderAo();
            BeanUtils.copyProperties(doo, ao);
            if (StringUtils.isNotBlank(doo.getCustomerName())) {
                ao.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(doo.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(doo.getCustomerName()));
            }
            return ao;
        }).collect(Collectors.toList());
        return RS.ok(listao);
    }

    @GetMapping("/code")
    @PreAuthorize("hasAuthority('I-9') or hasAuthority('I-3')") // 订单表单的所属订单组选择器也使用此接口
    public RS getByCode(@RequestParam(required = false) String code) {
        List<Map<String, String>> list = this.dao.getByCode(code).stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("label", item.getCode());
            map.put("value", item.getId());
            // 供订单表单选中订单组后直接带入
            map.put("customerName", item.getCustomerName());
            map.put("poNum", item.getPoNum());
            map.put("image", item.getImage());
            return map;
        }).collect(Collectors.toList());
        return RS.ok(list);
    }
}
