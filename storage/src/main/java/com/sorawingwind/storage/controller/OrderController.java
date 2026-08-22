package com.sorawingwind.storage.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.cotte.estate.bean.pojo.ao.storage.OrderAo;
import com.cotte.estate.bean.pojo.ao.storage.OrderExcelAo;
import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import com.cotte.estate.bean.pojo.doo.storage.InStorageDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderGroupDo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estate.bean.pojo.eto.InStorageEto;
import com.cotte.estate.bean.pojo.eto.MouthStatisticsCustomerEto;
import com.cotte.estate.bean.pojo.eto.OrderEto;
import com.cotte.estate.bean.pojo.eto.OutStorageEto;
import com.cotte.estatecommon.PageRS;
import com.cotte.estatecommon.RS;
import com.cotte.estatecommon.enums.InUnit;
import com.cotte.estatecommon.utils.CodeGenerUtil;
import com.cotte.estatecommon.utils.ListUtil;
import com.cotte.estatecommon.utils.UUIDUtil;
import com.cotte.estatecommon.enums.OutType;
import com.sorawingwind.storage.dao.OrderDao;
import io.ebean.Ebean;
import io.ebean.SqlRow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDao dao;
    @Autowired
    private DictController dictController;
    @Autowired
    private InStorageController inStorageController;
    @Autowired
    private OutStorageController outStorageController;

    @GetMapping
    @PreAuthorize("hasAuthority('I-3')")
    public RS getByPage(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) String customerNameItem, @RequestParam(required = false) String code, @RequestParam(required = false) String inCode, @RequestParam(required = false) String outCode, @RequestParam(required = false) String incomingType, @RequestParam(required = false) String po, @RequestParam(required = false) String item, @RequestParam(required = false) String starttime, @RequestParam(required = false) String endtime, @RequestParam(required = false) String inStarttime, @RequestParam(required = false) String inEndtime, @RequestParam(required = false) String outStarttime, @RequestParam(required = false) String outEndtime, @RequestParam(required = false) String deliveryStarttime, @RequestParam(required = false) String deliveryEndtime, @RequestParam(required = false) String bound) {
        List<OrderDo> list = this.dao.getByPage(pageIndex, pageSize, customerNameItem, code, inCode, outCode, incomingType, po, item, starttime, endtime, inStarttime, inEndtime, outStarttime, outEndtime, deliveryStarttime, deliveryEndtime, bound);
        int totleRowCount = this.dao.getCountByPage(pageIndex, pageSize, customerNameItem, code, inCode, outCode, incomingType, po, item, starttime, endtime, inStarttime, inEndtime, outStarttime, outEndtime, deliveryStarttime, deliveryEndtime, bound);

        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        // 所属订单组编号
        List<String> groupIds = list.stream().map(OrderDo::getOrderGroupId).filter(StringUtils::isNotBlank).distinct().collect(Collectors.toList());
        Map<String, String> groupCodeMap = new HashMap<>();
        if (!groupIds.isEmpty()) {
            groupCodeMap = Ebean.createQuery(OrderGroupDo.class).where().idIn(groupIds).findList().stream().collect(Collectors.toMap(OrderGroupDo::getId, OrderGroupDo::getCode));
        }

        List<OrderAo> listao = new ListUtil<OrderDo, OrderAo>().copyList(list, OrderAo.class);
        List<String> orderIds = listao.stream().map(OrderAo::getId).collect(Collectors.toList());
        List<InStorageDo> listIn = new ArrayList<>();
        List<OutStorageDo> listOut = new ArrayList<>();
        if (!orderIds.isEmpty()) {
            listIn = Ebean.createQuery(InStorageDo.class).where().in("order_id", orderIds).eq("is_delete", 0).findList();
            List<String> inStorageIds = listIn.stream().map(InStorageDo::getId).collect(Collectors.toList());
            if (!listIn.isEmpty()) {
                listOut = Ebean.createQuery(OutStorageDo.class).where().in("in_storage_id", inStorageIds).eq("is_delete", 0).findList();
            }
        }
        List<OrderAo> listaor = new ArrayList<>();
        for (OrderAo oitem : listao) {
            OrderAo aoInner = new OrderAo();
            BeanUtils.copyProperties(oitem, aoInner);
            List<String> inids = listIn.stream().filter(iin -> oitem.getId().equals(iin.getOrderId())).map(InStorageDo::getId).collect(Collectors.toList());
            // 出库良品组件数
            int outStorageSumGood = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.GOOD.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
            // 出库打底组件数
            //int outStorageSumPriming = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.PRIMING.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
            //aoInner.setOutStroagePrimingSumCount(outStorageSumPriming);
            // 入库不良品组件数
            //int incomingPoor = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.POOR.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
            //int incomingPoor = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "30bc0ec552cb4a59a23c680362219ecf".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 已出库良品组件总数 = 出库良品组件数 - 入库不良品组件数
            //outStorageSumGood = outStorageSumGood - incomingPoor;
            if (aoInner.getPartSumCount() != null) {
                // 已出库良品组件总数 > 订单组件总数,已出库良品组件总数显示红色
                aoInner.setOutStorageBigger(aoInner.getPartSumCount().compareTo(new BigDecimal(outStorageSumGood)) == -1);
                // 打底比率 = 出库类型为打底的出库组件数/订单组件总数
                //aoInner.setOutStroagePrimingSumCountRatio((new BigDecimal(outStorageSumPriming).divide(aoInner.getPartSumCount(),2,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)));
            }

            // 入库新件，只统计单位是个的数量
            int inStorageNew = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "4".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 入库返镀件，只统计单位是个的数量
            int inStorageReplat = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "5".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 已入库组件总数 = 入库新件 + 入库返镀件
            int inStorageSumCountCal = inStorageNew + inStorageReplat;
            if (aoInner.getPartSumCount() != null) {
                // 已入库组件总数 > 订单组件总数，已入库组件总数显示红色
                aoInner.setIncomingBigger(aoInner.getPartSumCount().compareTo(new BigDecimal(inStorageSumCountCal)) == -1);
            }

            // 入库返镀件组件数量，只统计单位是个的数量
            int replat = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "5".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 入库来料异常组件数
            int incomingErr = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.INSTORAGEERR.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
            if (oitem.getPartSumCount() != null && oitem.getPartSumCount().compareTo(new BigDecimal(0)) != 0) {
                // 返镀比率 = 入库返镀件组件数/订单组件总数×100%，蓝色显示
                BigDecimal replatratio = new BigDecimal(replat).divide(oitem.getPartSumCount(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                // 来料异常比率 = 入库来料异常组件数/订单组件总数×100%，蓝色显示
                BigDecimal incomingErrratio = new BigDecimal(incomingErr).divide(oitem.getPartSumCount(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                aoInner.setReplatRatio(replatratio);
                aoInner.setIncomingRatio(incomingErrratio);
            }


            aoInner.setReplatCount(replat);
            aoInner.setIncomingCount(incomingErr);
            aoInner.setOutStroageGoodsSumCount(outStorageSumGood);
            BigDecimal partSumCountSubOutStroageGoodsSumCount = BigDecimal.ZERO;
            if (aoInner.getPartSumCount() != null) {
                partSumCountSubOutStroageGoodsSumCount = (aoInner.getPartSumCount().subtract(new BigDecimal(outStorageSumGood)));
                if (partSumCountSubOutStroageGoodsSumCount.compareTo(BigDecimal.ZERO) <= 0) {
                    aoInner.setPartSumCountSubOutStroageGoodsSumCount(0);
                    aoInner.setOverPartSumCount(partSumCountSubOutStroageGoodsSumCount.abs().intValue());
                } else {
                    aoInner.setPartSumCountSubOutStroageGoodsSumCount(partSumCountSubOutStroageGoodsSumCount.intValue());
                    aoInner.setOverPartSumCount(0);
                }
            }
            aoInner.setPartSumCountCal(inStorageSumCountCal);
            if (StringUtils.isNotBlank(oitem.getCustomerName())) {
                aoInner.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(oitem.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(oitem.getCustomerName()));
            }
            aoInner.setCustomerNameId(oitem.getCustomerName());
            aoInner.setOrderGroupCode(groupCodeMap.get(oitem.getOrderGroupId()));
            listaor.add(aoInner);
        }
        return RS.ok(new PageRS<>(pageSize, pageIndex, totleRowCount, totleRowCount / pageSize, listaor));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('I-3')")
    public RS save(@RequestBody OrderAo orderAo) {
        OrderDo doo = new OrderDo();
        BeanUtils.copyProperties(orderAo, doo);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        int count = Ebean.createQuery(OrderDo.class).where().ge("create_time", start).le("create_time", end).findCount();
        doo.setCode(CodeGenerUtil.getCode("OR", count));
        doo.setId(UUIDUtil.simpleUUid());
        doo.setCreateTime(new Date());
        doo.setIsDelete(0);
        this.dao.save(doo);
        return RS.ok();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('I-3')")
    public RS update(@RequestBody OrderAo orderAo) {
        OrderDo doo = new OrderDo();
        BeanUtils.copyProperties(orderAo, doo);
        doo.setCustomerName(orderAo.getCustomerNameId());
        doo.setModifiedTime(new Date());
        doo.setIsDelete(0);
        this.dao.update(doo);
        return RS.ok();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('I-3')")
    public RS delete(@RequestBody List<String> ids) {
        List<OrderDo> list = Ebean.createQuery(OrderDo.class).where().idIn(ids).findList();
        for (OrderDo doo : list) {
            doo.setIsDelete(1);
        }
        this.dao.updateAll(list);
        return RS.ok();
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasAuthority('I-3')")
    public RS getMouthStatistics(@RequestParam(required = false) String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        return RS.ok(this.dao.getCountBetweenTimes(start, end));
//        }
    }

    @GetMapping("/statistics/color")
    @PreAuthorize("hasAuthority('I-3')")
    public RS getMouthStatisticsColor(@RequestParam(required = false) String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        String startStr = sdf.format(start);
        String endStr = sdf.format(end);
        List<SqlRow> list = this.dao.getCountBetweenTimesWithColor(startStr, endStr);
        if (!list.isEmpty()) {
            Double maxsum = list.stream().mapToDouble(sqlrow -> sqlrow.getDouble("count")).sum();
            return RS.ok(list.stream().map(item -> {
                String colorid = item.getString("color");
                String count = item.getString("count");
                BigDecimal ratio = BigDecimal.ZERO;
                if (maxsum != 0.0) {
                    ratio = item.getBigDecimal("count").divide(new BigDecimal(maxsum), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                }
                String color = dictController.getById(colorid).getItemName();
                Map<String, String> map = new HashMap<>();
                map.put("color", color);
                map.put("count", count);
                map.put("ratio", ratio.toString());
                return map;
            }).collect(Collectors.toList()));
        } else {
            return RS.warn("未查询到订单数据。");
        }
    }

    @GetMapping("/statistics/customer")
    @PreAuthorize("hasAuthority('I-3')")
    public RS getMouthStatisticsCustomer(@RequestParam(required = false) String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        String startStr = sdf.format(start);
        String endStr = sdf.format(end);
        List<SqlRow> list = this.dao.getCountBetweenTimesWithCustomer(startStr, endStr);
        if (!list.isEmpty()) {
            List<String> customerNames = list.stream().map(item -> dictController.getById(item.getString("customer_name")).getItemName()).collect(Collectors.toList());
            List<BigDecimal> counts = list.stream().map(item -> item.getBigDecimal("count")).collect(Collectors.toList());
            Map<String, List> map = new HashMap<>();
            map.put("name", customerNames);
            map.put("count", counts);
            return RS.ok(map);
        } else {
            return RS.warn("未查询到订单数据。");
        }
    }

    @GetMapping("/statistics/customer/excel")
    @PreAuthorize("hasAuthority('I-3')")
    public void getMouthStatisticsCustomerExcel(HttpServletResponse response, @RequestParam(required = false) String time) throws ParseException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        String startStr = sdf.format(start);
        String endStr = sdf.format(end);
        List<SqlRow> list = this.dao.getCountBetweenTimesWithCustomer(startStr, endStr);
        if (!list.isEmpty()) {
            List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
            List<MouthStatisticsCustomerEto> listeto = list.stream().map(item -> {
                MouthStatisticsCustomerEto mouthStatisticsCustomerEto = new MouthStatisticsCustomerEto();
                mouthStatisticsCustomerEto.setName(customerDicts.stream().filter(dict -> dict.getId().equals(item.getString("customer_name"))).findFirst().map(DictDo::getItemName).orElse(item.getString("customer_name")));
                mouthStatisticsCustomerEto.setCount(item.getBigDecimal("count"));
                return mouthStatisticsCustomerEto;
            }).collect(Collectors.toList());
            OutputStream outputStream = response.getOutputStream();
            // 获取模板路径
            InputStream resourceAsStream = this.getClass().getResourceAsStream("/excel/mouthStatisticsCustomer.xlsx");
            // 创建输出的excel对象
            final ExcelWriter write = EasyExcel.write(outputStream).withTemplate(resourceAsStream).build();
            // 创建第一个sheel页
            final WriteSheet sheet1 = EasyExcel.writerSheet(0, "月客户组件数明细").build();
            write.fill(listeto, sheet1);
            // 关闭流
            write.finish();
        }
    }

    @GetMapping("/code")
    @PreAuthorize("hasAuthority('I-3')")
    public RS getByCode(@RequestParam(required = false) String code) {
        List<Map<String, String>> list = this.dao.getByCode(code).stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("label", item.getCode());
            map.put("value", item.getId());
            return map;
        }).collect(Collectors.toList());
        return RS.ok(list);
    }

    // 按PO号检索订单明细，供入库单绑定使用
    @GetMapping("/byPoNum")
    @PreAuthorize("hasAuthority('I-1') or hasAuthority('I-3')")
    public RS getByPoNum(@RequestParam String poNum) {
        List<Map<String, String>> list = this.dao.getByPoNum(poNum).stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("code", item.getCode());
            map.put("poNum", item.getPoNum());
            map.put("item", item.getItem());
            map.put("part", item.getPart());
            map.put("count", item.getCount() == null ? "" : item.getCount().toString());
            return map;
        }).collect(Collectors.toList());
        return RS.ok(list);
    }

    // 批量绑定/解绑订单组
    @PutMapping("/batchBind")
    @PreAuthorize("hasAuthority('I-3')")
    public RS batchBind(@RequestBody Map<String, Object> params) {
        List<String> orderIds = (List<String>) params.get("orderIds");
        String orderGroupId = (String) params.get("orderGroupId");
        if (orderIds == null || orderIds.isEmpty()) {
            return RS.warn("请先勾选要绑定的订单明细。");
        }
        if (StringUtils.isNotBlank(orderGroupId)) {
            OrderGroupDo group = Ebean.createQuery(OrderGroupDo.class).where().idEq(orderGroupId).findOne();
            if (group == null) {
                return RS.warn("所选订单不存在。");
            }
        }
        this.dao.batchBindOrderGroup(orderIds, orderGroupId);
        return RS.ok();
    }

    @GetMapping("/id")
    @PreAuthorize("hasAuthority('I-3')")
    public RS getById(@RequestParam(required = true) String id) {
        OrderAo ao = new OrderAo();
        OrderDo doo = this.dao.getById(id);
        BeanUtils.copyProperties(doo, ao);
        return RS.ok(ao);
    }

    @PostMapping("/excel")
    @PreAuthorize("hasAuthority('I-3')")
    public void download(HttpServletResponse response, @RequestBody OrderExcelAo orderAo) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("订单明细", "UTF-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx;" + "filename*=utf-8''" + fileName + ".xlsx");
        OutputStream outputStream = response.getOutputStream();
        //FileOutputStream outputStream = new FileOutputStream("/home/sorawingwind/桌面/xx.xlsx");
        List<OrderDo> listdoOri = this.dao.getExcels(orderAo.getCustomerNameItem(), orderAo.getCode(), orderAo.getInCode(), orderAo.getOutCode(), orderAo.getIncomingType(), orderAo.getPo(), orderAo.getItem(), orderAo.getStarttime(), orderAo.getEndtime(), orderAo.getInStarttime(), orderAo.getInEndtime(), orderAo.getOutStarttime(), orderAo.getOutEndtime(), orderAo.getDeliveryStarttime(), orderAo.getDeliveryEndtime());
        List<String> orderIds = listdoOri.stream().map(OrderDo::getId).collect(Collectors.toList());
        List<InStorageDo> listIn;
        List<OutStorageDo> listOut;
        List<String> inStorageIds = new ArrayList<>();
        if (!orderIds.isEmpty()) {
            listIn = this.dao.getInStorageByOrderIds(orderIds, null, null, null);
            inStorageIds = listIn.stream().map(InStorageDo::getId).collect(Collectors.toList());
            if (!listIn.isEmpty()) {
                listOut = this.dao.getOutStorageByInStorageIds(inStorageIds, null, null, null);
            } else {
                listOut = new ArrayList<>();
            }
        } else {
            listOut = new ArrayList<>();
            listIn = new ArrayList<>();
        }
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        //获取数据
        List<OrderAo> listdo = listdoOri.stream().map(iitem -> {
            OrderAo ao = new OrderAo();
            BeanUtils.copyProperties(iitem, ao);

            ao.setCustomerName(customerDicts.stream().filter(c -> c.getId().equals(iitem.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(iitem.getCustomerName()));

            List<String> inids = listIn.stream().filter(iin -> iitem.getId().equals(iin.getOrderId())).map(InStorageDo::getId).collect(Collectors.toList());
            // 入库新件，只统计单位是个的数量
            int inStorageNew = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "4".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 入库返镀件，只统计单位是个的数量
            int inStorageReplat = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "5".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 已入库组件总数 = 入库新件 + 入库返镀件
            int inStorageSumCountCal = inStorageNew + inStorageReplat;
            // 出库良品组件数
            int outStorageSumGood = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.GOOD.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
            // 出库打底组件数
//            int outStorageSumPriming = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.PRIMING.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
//            ao.setOutStroagePrimingSumCount(outStorageSumPriming);
//            if (ao.getPartSumCount() != null) {
//                // 打底比率 = 出库类型为打底的出库组件数/订单组件总数
//                ao.setOutStroagePrimingSumCountRatio((new BigDecimal(outStorageSumPriming).divide(ao.getPartSumCount(),2,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)));
//            }
            // 入库返镀件组件数量，只统计单位是个的数量
            int replat = listIn.stream().filter(iin -> inids.contains(iin.getId())).filter(iin -> "5".equals(iin.getIncomingType())).filter(iin -> (InUnit.ONE.getIndex() + "").equals(iin.getUnit())).mapToInt(iin -> iin.getBunchCount().intValue()).sum();
            // 入库来料异常组件数
            int incomingErr = listOut.stream().filter(oin -> inids.contains(oin.getInStorageId())).filter(oin -> (OutType.INSTORAGEERR.getIndex() + "").equals(oin.getOutType())).mapToInt(oin -> oin.getBunchCount().intValue()).sum();
            if (iitem.getPartSumCount() != null && iitem.getPartSumCount().compareTo(new BigDecimal(0)) != 0) {
                // 返镀比率 = 入库返镀件组件数/订单组件总数×100%，蓝色显示
                BigDecimal replatratio = new BigDecimal(replat).divide(iitem.getPartSumCount(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                // 来料异常比率 = 入库来料异常组件数/订单组件总数×100%，蓝色显示
                BigDecimal incomingErrratio = new BigDecimal(incomingErr).divide(iitem.getPartSumCount(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                ao.setReplatRatio(replatratio);
                ao.setIncomingRatio(incomingErrratio);
            }

            ao.setReplatCount(replat);
            ao.setIncomingCount(incomingErr);
            ao.setPartSumCountCal(inStorageSumCountCal);
            ao.setOutStroageGoodsSumCount(outStorageSumGood);
            BigDecimal partSumCountSubOutStroageGoodsSumCount = BigDecimal.ZERO;
            if (ao.getPartSumCount() != null) {
                partSumCountSubOutStroageGoodsSumCount = (ao.getPartSumCount().subtract(new BigDecimal(outStorageSumGood)));
                if (partSumCountSubOutStroageGoodsSumCount.compareTo(BigDecimal.ZERO) <= 0) {
                    ao.setPartSumCountSubOutStroageGoodsSumCount(0);
                    ao.setOverPartSumCount(partSumCountSubOutStroageGoodsSumCount.abs().intValue());
                } else {
                    ao.setPartSumCountSubOutStroageGoodsSumCount(partSumCountSubOutStroageGoodsSumCount.intValue());
                    ao.setOverPartSumCount(0);
                }
            }
            return ao;
        }).collect(Collectors.toList());

        // 订单
        List<OrderEto> list = new ListUtil<OrderAo, OrderEto>().copyList(listdo, OrderEto.class);
        list.forEach(item -> {
            item.setTime((StringUtils.isBlank(orderAo.getStarttime()) ? "开始" : orderAo.getStarttime().split(" ")[0]) + " - " + (StringUtils.isBlank(orderAo.getEndtime()) ? "结束" : orderAo.getEndtime().split(" ")[0]));
            if (item.getDeliveryTime() != null) {
                item.setDelTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(item.getDeliveryTime()));
            }
        });
        // 获取模板路径
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/excel/order.xlsx");
        // 创建输出的excel对象
        final ExcelWriter write = EasyExcel.write(outputStream).withTemplate(resourceAsStream).build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        // 创建第一个sheel页
        final WriteSheet sheet1 = EasyExcel.writerSheet(0, "订单明细").head(OrderEto.class).build();
        write.fill(list, sheet1);
        // 入库
        String orderids2 = "";
        for (String id : orderIds) {
            orderids2 += "'" + id + "',";
        }
        if(StringUtils.isNotBlank(orderids2)){
            orderids2 = orderids2.substring(0, orderids2.length() - 1);
            List<InStorageEto> inlist = this.inStorageController.getAndBuildEtosByOrder(orderids2, orderAo.getInCode(), orderAo.getInStarttime(), orderAo.getInEndtime(), orderAo.getOutCode(), orderAo.getOutStarttime(), orderAo.getOutEndtime());
            final WriteSheet sheet2 = EasyExcel.writerSheet(1, "入库明晰").head(InStorageEto.class).build();
            write.fill(inlist, sheet2);
        }
        // 出库
        String inids2 = "";
        for (String id : inStorageIds) {
            inids2 += "'" + id + "',";
        }
        if(StringUtils.isNotBlank(inids2)){
            inids2 = inids2.substring(0, inids2.length() - 1);
            List<OutStorageEto> outlist = this.outStorageController.getAndBuildEtosByIn(inids2, orderAo.getOutCode(), orderAo.getOutStarttime(), orderAo.getOutEndtime());
            final WriteSheet sheet3 = EasyExcel.writerSheet(2, "出库明晰").head(OutStorageEto.class).build();
            write.fill(outlist, sheet3);
        }
        // 关闭流
        write.finish();
    }

    @GetMapping("/parts")
    @PreAuthorize("hasAuthority('I-3') or hasAuthority('I-9')") // 订单组新增表单的部件联想也使用此接口
    public RS loadParts() {
        List<String> parts = this.dao.loadParts();
        return RS.ok(parts.stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("value", item);
            return map;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/ponums")
    @PreAuthorize("hasAuthority('I-3')")
    public RS loadPonums() {
        List<String> parts = this.dao.loadPonums();
        return RS.ok(parts.stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("value", item);
            return map;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('I-3') or hasAuthority('I-9')") // 订单组新增表单的ITEM号联想也使用此接口
    public RS loadItems() {
        List<String> parts = this.dao.loadItems();
        return RS.ok(parts.stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("value", item);
            return map;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/item/parts")
    @PreAuthorize("hasAuthority('I-3') or hasAuthority('I-9')") // 订单组新增表单的部件联动也使用此接口
    public RS loadPonumItems(@RequestParam String item) {
        List<String> parts = this.dao.loadPonumItems(item);
        return RS.ok(parts.stream().map(it -> {
            Map<String, String> map = new HashMap<>();
            map.put("value", it);
            return map;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/colorPartcount")
    @PreAuthorize("hasAuthority('I-3') or hasAuthority('I-9')") // 订单组新增表单的每套组件数量回填也使用此接口
    public RS loadInfoByItemPart(@RequestParam String item, @RequestParam String part) {
        Map<String, String> info = this.dao.loadInfoByItemPart(item, part);
        if (info == null) {
            return RS.warn("没有相关订单信息");
        } else {
            return RS.ok(info);
        }
    }
}
