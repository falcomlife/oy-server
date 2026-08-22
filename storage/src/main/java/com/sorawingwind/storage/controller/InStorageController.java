package com.sorawingwind.storage.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.cotte.estate.bean.pojo.ao.storage.*;
import com.cotte.estate.bean.pojo.bo.storage.InStorageBo;
import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import com.cotte.estate.bean.pojo.doo.storage.InStorageDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estate.bean.pojo.eto.InStorageEto;
import com.cotte.estate.bean.pojo.eto.OrderEto;
import com.cotte.estatecommon.PageRS;
import com.cotte.estatecommon.RS;
import com.cotte.estatecommon.enums.InUnit;
import com.cotte.estatecommon.utils.CodeGenerUtil;
import com.cotte.estatecommon.utils.ListUtil;
import com.cotte.estatecommon.utils.UUIDUtil;
import com.sorawingwind.storage.dao.InStorageDao;
import com.sorawingwind.storage.dao.OrderDao;
import io.ebean.Ebean;
import io.ebean.ExpressionList;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.UnionType;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inStorage")
public class InStorageController {

    @Autowired
    private InStorageDao dao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DictController dictController;

    @GetMapping
    @PreAuthorize("hasAuthority('I-1')")
    public RS getByPage(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) String customerNameItem, @RequestParam(required = false) String item, @RequestParam(required = false) String poNum, @RequestParam(required = false) String incomingTypeItem, @RequestParam(required = false) String code, @RequestParam(required = false) String starttime, @RequestParam(required = false) String endtime, @RequestParam(required = false) String remainMin, @RequestParam(required = false) String remainMax, @RequestParam(required = false) String stayDaysMin, @RequestParam(required = false) String stayDaysMax) {
        List<SqlRow> list = this.dao.getByPage(pageIndex, pageSize, customerNameItem, item, poNum, incomingTypeItem, code, starttime, endtime, remainMin, remainMax, stayDaysMin, stayDaysMax);
        int totleRowCount = this.dao.getCountByPage(pageIndex, pageSize, customerNameItem, item, poNum, incomingTypeItem, code, starttime, endtime, remainMin, remainMax, stayDaysMin, stayDaysMax);
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> incomingtypeDicts = this.dictController.getDictDoByType("incomingtype");
        List<DictDo> ctDicts = this.dictController.getDictDoByType("ct");
        List<InStorageAo> listaor = list.stream().map(itemInner -> {
            InStorageAo aoInner = new InStorageAo();
            aoInner.setId(itemInner.getString("id"));
            aoInner.setOutStorageCode(itemInner.getString("out_storage_code"));
            aoInner.setCode(itemInner.getString("code"));
            aoInner.setBunchCount(itemInner.getBigDecimal("bunch_count"));
            aoInner.setRemainCount(itemInner.getBigDecimal("remain_count"));
            aoInner.setStayDays(itemInner.getInteger("stay_days"));
            aoInner.setCreateTime(itemInner.getDate("create_time"));
            aoInner.setImage(itemInner.getString("image"));
            aoInner.setInCount(itemInner.getString("in_count"));
            aoInner.setUnit(InUnit.getNameByIndex(Integer.parseInt(itemInner.getString("unit"))));
            aoInner.setUnitId(itemInner.getString("unit"));
            aoInner.setName(itemInner.getString("name"));
            aoInner.setPoNum(itemInner.getString("po_num"));
            aoInner.setItem(itemInner.getString("item"));
            aoInner.setPart(itemInner.getString("part"));
            aoInner.setCount(itemInner.getBigDecimal("count"));
            aoInner.setPartSumCount(itemInner.getBigDecimal("part_sum_count"));
            aoInner.setOrderId(itemInner.getString("order_id"));
            aoInner.setOrderCode(itemInner.getString("order_code"));
            aoInner.setIsDelete(0);
            aoInner.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("customer_name"))).findFirst().map(DictDo::getItemName).orElse(""));
            aoInner.setCustomerNameId(itemInner.getString("customer_name"));
//            if (StringUtils.isNotBlank(itemInner.getString("color"))) {
//                aoInner.setColor(colorDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("color"))).findFirst().get().getItemName());
//            }
            aoInner.setColorId(itemInner.getString("color"));
            aoInner.setOrderColor(colorDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("order_color"))).map(DictDo::getItemName).findFirst().orElse(""));
            aoInner.setOrderColorId(itemInner.getString("order_color"));
            aoInner.setIncomingType(incomingtypeDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("incoming_type"))).findFirst().map(DictDo::getItemName).orElse(""));
            aoInner.setIncomingTypeId(itemInner.getString("incoming_type"));
            aoInner.setIncomingReason(itemInner.getString("incoming_reason"));
            aoInner.setBadReason(itemInner.getString("bad_reason"));
            aoInner.setBake(ctDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("bake"))).map(DictDo::getItemName).findFirst().orElse(""));
            aoInner.setBakeId(itemInner.getString("bake"));
            return aoInner;
        }).collect(Collectors.toList());
        return RS.ok(new PageRS<>(pageSize, pageIndex, totleRowCount, totleRowCount / pageSize, listaor));
    }

    /**
     * @description: 打印时根据选中的数据重新查询
     * @author: sorawingwind
     * @date: 2023/5/4
     */
    @PostMapping("/ids")
    @PreAuthorize("hasAuthority('I-1')")
    public RS getByIds(@RequestBody List<String> ids) {

        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> incomingtypeDicts = this.dictController.getDictDoByType("incomingtype");
        List<DictDo> ctDicts = this.dictController.getDictDoByType("ct");

        StringBuffer idssb = new StringBuffer();
        for (String id : ids) {
            idssb.append("\"" + id + "\",");
        }
        String idsStr = idssb.toString().substring(0, idssb.toString().length() - 1);
        List<SqlRow> sqlRows = this.dao.getByIdstr(idsStr);
        List<InStorageAo> listaor = sqlRows.stream().map(item -> {
            InStorageAo aoInner = new InStorageAo();
            aoInner.setId(item.getString("id"));
            aoInner.setOutStorageCode(item.getString("out_storage_code"));
            aoInner.setCode(item.getString("code"));
            aoInner.setBunchCount(item.getBigDecimal("bunch_count"));
            aoInner.setCreateTime(item.getDate("create_time"));
            aoInner.setImage(item.getString("image"));
            aoInner.setInCount(item.getString("in_count"));
            aoInner.setUnit(item.getString("unit"));
            aoInner.setName(item.getString("name"));
            aoInner.setPoNum(item.getString("po_num"));
            aoInner.setItem(item.getString("item"));
            aoInner.setPart(item.getString("part"));
            aoInner.setCount(item.getBigDecimal("count"));
            aoInner.setOrderId(item.getString("order_id"));
            aoInner.setOrderCode(item.getString("order_code"));
            aoInner.setIsDelete(0);
            aoInner.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(item.getString("customer_name"))).findFirst().map(DictDo::getItemName).orElse(""));
            aoInner.setCustomerNameId(item.getString("customer_name"));
//            aoInner.setColor(colorDicts.stream().filter(dict -> dict.getId().equals(item.getString("color"))).findFirst().get().getItemName());
//            aoInner.setColorId(item.getString("color"));
            aoInner.setOrderColor(colorDicts.stream().filter(dict -> dict.getId().equals(item.getString("order_color"))).findFirst().map(DictDo::getItemName).orElse(""));
            aoInner.setOrderColorId(item.getString("order_color"));
            aoInner.setIncomingType(incomingtypeDicts.stream().filter(dict -> dict.getId().equals(item.getString("incoming_type"))).findFirst().map(DictDo::getItemName).orElse(""));
            aoInner.setIncomingTypeId(item.getString("incoming_type"));
            aoInner.setIncomingReason(item.getString("incoming_reason"));
            aoInner.setBadReason(item.getString("bad_reason"));
            aoInner.setBake(ctDicts.stream().filter(dict -> dict.getId().equals(item.getString("bake"))).findFirst().map(DictDo::getItemName).orElse(""));
            aoInner.setBakeId(item.getString("bake"));
            return aoInner;
        }).collect(Collectors.toList());
        return RS.ok(listaor);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('I-1')")
    public RS save(@RequestBody InStorageAo inStorageAo) {
        InStorageDo doo = new InStorageDo();
        BeanUtils.copyProperties(inStorageAo, doo);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        int count = this.dao.getCodeCount(start, end);
        doo.setCode(CodeGenerUtil.getCode("I", count));
        doo.setId(UUIDUtil.simpleUUid());
        doo.setCreateTime(new Date());
        doo.setIsDelete(0);
        doo.setBake(inStorageAo.getBake());
        this.dao.save(doo);
        return RS.ok();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('I-1')")
    public RS update(@RequestBody InStorageAo inStorageAo) {
        InStorageDo doo = new InStorageDo();
        BeanUtils.copyProperties(inStorageAo, doo);
        doo.setColor(inStorageAo.getColorId());
        doo.setBake(inStorageAo.getBakeId());
        doo.setIncomingType(inStorageAo.getIncomingTypeId());
        doo.setUnit(inStorageAo.getUnitId());
        doo.setModifiedTime(new Date());
        this.dao.update(doo);
        return RS.ok();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('I-1')")
    public RS delete(@RequestBody List<String> ids) {
        List<InStorageDo> list = this.dao.getByIds(ids);
        for (InStorageDo doo : list) {
            doo.setIsDelete(1);
        }
        this.dao.updateAll(list);
        return RS.ok();
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasAuthority('I-1')")
    public RS getMouthStatistics(@RequestParam(required = false) String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        return RS.ok(this.dao.getMouthStatistics(start, end));
    }

    @GetMapping("/statistics/reratio")
    @PreAuthorize("hasAuthority('I-1')")
    public RS getMouthStatisticsReratio(@RequestParam(required = false) String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        List<InStorageDo> recountList = this.dao.getMouthStatisticsReratio(start, end);
        BigDecimal sumcount = new BigDecimal(0);
        BigDecimal recount = new BigDecimal(0);
        for (InStorageDo doo : recountList) {
            if ("5".equals(doo.getIncomingType())) {
                if (doo.getBunchCount() != null) {
                    recount = recount.add(doo.getBunchCount());
                }
            }
            if (doo.getBunchCount() != null) {
                sumcount = sumcount.add(doo.getBunchCount());
            }
        }
        BigDecimal ratio = new BigDecimal(0);
        if (sumcount.compareTo(BigDecimal.ZERO) != 0) {
            ratio = (recount.divide(sumcount, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).setScale(2);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("recount", recount);
        map.put("ratio", ratio);
        return RS.ok(map);
    }

    @GetMapping("/code")
    @PreAuthorize("hasAuthority('I-1')")
    public RS getByCode(@RequestParam(required = false) String code) {
        List<Map<String, String>> list = this.dao.getByCode(code).stream().map(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("label", item.getCode());
            map.put("value", item.getId());
            return map;
        }).collect(Collectors.toList());
        return RS.ok(list);
    }

    @GetMapping("/id")
    @PreAuthorize("hasAuthority('I-1')")
    public RS getById(@RequestParam(required = true) String id) {
        InStorageAo iao = new InStorageAo();
        InStorageDo idoo = this.dao.getById(id);
        BeanUtils.copyProperties(idoo, iao);
        OrderDo doo = this.orderDao.getById(idoo.getOrderId());
        if (StringUtils.isNotBlank(doo.getCustomerName())) {
            iao.setCustomerName(dictController.getById(doo.getCustomerName()).getItemName());
        }
//        if (StringUtils.isNotBlank(doo.getColor())) {
//            iao.setColor(dictController.getById(doo.getColor()).getItemName());
//        }
        // 镀金颜色、烤厅从入库单自身获取
        if (StringUtils.isNotBlank(idoo.getColor())) {
            iao.setColor(dictController.getById(idoo.getColor()).getItemName());
            iao.setColorId(idoo.getColor());
        }
        if (StringUtils.isNotBlank(idoo.getBake())) {
            iao.setBake(dictController.getById(idoo.getBake()).getItemName());
            iao.setBakeId(idoo.getBake());
        }
        iao.setCustomerNameId(doo.getCustomerName());
        iao.setPoNum(doo.getPoNum());
        iao.setItem(doo.getItem());
        iao.setPart(doo.getPart());
        iao.setCount(doo.getCount());
        iao.setPartSumCount(doo.getPartSumCount());
        return RS.ok(iao);
    }

    @GetMapping("/order")
    @PreAuthorize("hasAuthority('I-1') or hasAuthority('I-9')") // 订单组页面展开订单下钻入库单也使用此接口
    public RS getByOrderId(@RequestParam String orderId,@RequestParam(required = false) String inCode,@RequestParam(required = false) String outCode,@RequestParam(required = false) String inStarttime, @RequestParam(required = false) String inEndtime,@RequestParam(required = false) String outStarttime, @RequestParam(required = false) String outEndtime) {
        return RS.ok(this.dao.getByOrderId(orderId,inCode,outCode,inStarttime,inEndtime,outStarttime,outEndtime).stream().map(item -> {
            OrderDo order = this.orderDao.getById(orderId);
            InStorageAo aoInner = new InStorageAo();
            BeanUtils.copyProperties(item, aoInner);
//            aoInner.setColor(dictController.getById(item.getColor()).getItemName());
//            aoInner.setColorId(item.getColor());
            aoInner.setIncomingType(dictController.getById(item.getIncomingType()).getItemName());
            aoInner.setIncomingTypeId(item.getIncomingType());
            aoInner.setBadReason(item.getBadReason());
            aoInner.setIncomingReason(item.getIncomingReason());
            aoInner.setCustomerName(dictController.getById(order.getCustomerName()).getItemName());
            aoInner.setCount(order.getCount());
            aoInner.setPoNum(order.getPoNum());
            aoInner.setUnit(InUnit.getNameByIndex(Integer.parseInt(item.getUnit())));
            aoInner.setItem(order.getItem());
            aoInner.setPart(order.getPart());
            aoInner.setOrderColor(StringUtils.isNotBlank(item.getColor()) ? dictController.getById(item.getColor()).getItemName() : "");
            aoInner.setBake(StringUtils.isNotBlank(item.getBake()) ? dictController.getById(item.getBake()).getItemName() : "");
            List<OutStorageAo> list = new ArrayList<>();
            if (StringUtils.isNotBlank(item.getOutStorageId())) {
                OutStorageAo ao = new OutStorageAo();
                OutStorageDo doo = Ebean.createQuery(OutStorageDo.class).where().eq("id", item.getOutStorageId()).findOne();
                BeanUtils.copyProperties(doo, ao);
                list.add(ao);
                aoInner.setExpandType("outStorageByInStorage");
            } else {
                List<OutStorageDo> listInner = Ebean.createQuery(OutStorageDo.class).where().eq("in_storage_id", item.getId()).findList();
                list.addAll(new ListUtil<OutStorageDo, OutStorageAo>().copyList(listInner, OutStorageAo.class));
                aoInner.setExpandType("");
                aoInner.setExpandType("outStoragesByInStorage");
            }
            aoInner.setOutStorageList(list);
            return aoInner;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/outStorage")
    @PreAuthorize("hasAuthority('I-1')")
    public RS getByOutStorageId(@RequestParam String outStorageId) {
        return RS.ok(this.dao.getByOutStorageId(outStorageId).stream().map(item -> {
            InStorageAo aoInner = new InStorageAo();
            BeanUtils.copyProperties(item, aoInner);
//            aoInner.setColor(dictController.getById(item.getColor()).getItemName());
//            aoInner.setColorId(item.getColor());
            aoInner.setIncomingType(dictController.getById(item.getIncomingType()).getItemName());
            aoInner.setIncomingTypeId(item.getIncomingType());
            aoInner.setIncomingReason(item.getIncomingReason());
            return aoInner;
        }).collect(Collectors.toList()));
    }

    @PostMapping("/excel")
    @PreAuthorize("hasAuthority('I-1')")
    public void download(HttpServletResponse response, @RequestBody InStorageExcelAo inStorageExcelAo) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("入库明细", "UTF-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx;" + "filename*=utf-8''" + fileName + ".xlsx");
        OutputStream outputStream = response.getOutputStream();
        List<InStorageEto> listeto = this.getAndBuildEtos(inStorageExcelAo.getCustomerNameItem(), inStorageExcelAo.getItem(), inStorageExcelAo.getPoNum(), inStorageExcelAo.getIncomingType(), inStorageExcelAo.getCode(), inStorageExcelAo.getStarttime(), inStorageExcelAo.getEndtime());
        // 获取模板路径
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/excel/inStorage.xlsx");
        // 创建输出的excel对象
        final ExcelWriter write = EasyExcel.write(outputStream).withTemplate(resourceAsStream).build();
        // 创建第一个sheel页
        final WriteSheet sheet1 = EasyExcel.writerSheet(0, "入库明细").build();
        write.fill(listeto, sheet1);
        // 关闭流
        write.finish();
    }

    public List<InStorageEto> getAndBuildEtos(String customerNameItem,String item,String poNum,String incomingType,String code,String starttime,String endtime){
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> bakeDicts = this.dictController.getDictDoByType("ct");
        List<DictDo> incomingtypeDicts = this.dictController.getDictDoByType("incomingtype");
        //获取数据
        List<InStorageEto> listeto = this.dao.getExcels(customerNameItem,item,poNum,incomingType,code,starttime,endtime);
        listeto.stream().forEach(it ->
                {
                    it.setCustomerName(customerDicts.stream().filter(c -> c.getId().equals(it.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(""));
                    it.setOrderColor(colorDicts.stream().filter(c -> c.getId().equals(it.getOrderColor())).map(DictDo::getItemName).findFirst().orElse(""));
                    it.setBake(bakeDicts.stream().filter(c -> c.getId().equals(it.getBake())).map(DictDo::getItemName).findFirst().orElse(""));
                    it.setIncomingType(incomingtypeDicts.stream().filter(c -> c.getId().equals(it.getIncomingType())).findFirst().map(DictDo::getItemName).orElse(""));
                }
        );
        return listeto;
    }
    public List<InStorageEto> getAndBuildEtosByOrder(String orderIds,String code,String starttime,String endtime,String outcode,String outstarttime,String outendtime){
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> bakeDicts = this.dictController.getDictDoByType("ct");
        List<DictDo> incomingtypeDicts = this.dictController.getDictDoByType("incomingtype");
        //获取数据
        List<InStorageEto> listeto = this.dao.getExcelsByOrder(orderIds,code,starttime,endtime,outcode,outstarttime,outendtime);
        listeto.stream().forEach(it ->
                {
                    it.setCustomerName(customerDicts.stream().filter(c -> c.getId().equals(it.getCustomerName())).findFirst().map(DictDo::getItemName).orElse(""));
                    it.setOrderColor(colorDicts.stream().filter(c -> c.getId().equals(it.getOrderColor())).map(DictDo::getItemName).findFirst().orElse(""));
                    it.setBake(bakeDicts.stream().filter(c -> c.getId().equals(it.getBake())).map(DictDo::getItemName).findFirst().orElse(""));
                    it.setIncomingType(incomingtypeDicts.stream().filter(c -> c.getId().equals(it.getIncomingType())).findFirst().map(DictDo::getItemName).orElse(""));
                }
        );
        return listeto;
    }

}
