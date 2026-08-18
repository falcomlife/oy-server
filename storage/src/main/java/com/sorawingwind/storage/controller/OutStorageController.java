package com.sorawingwind.storage.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.cotte.estate.bean.pojo.ao.storage.OrderExcelAo;
import com.cotte.estate.bean.pojo.ao.storage.OutStorageAo;
import com.cotte.estate.bean.pojo.ao.storage.OutStorageExcelAo;
import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import com.cotte.estate.bean.pojo.doo.storage.InStorageDo;
import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estate.bean.pojo.eto.OrderEto;
import com.cotte.estate.bean.pojo.eto.OutStorageEto;
import com.cotte.estatecommon.PageRS;
import com.cotte.estatecommon.RS;
import com.cotte.estatecommon.utils.CodeGenerUtil;
import com.cotte.estatecommon.utils.ListUtil;
import com.cotte.estatecommon.utils.UUIDUtil;
import com.cotte.estatecommon.enums.OutType;
import com.sorawingwind.storage.dao.InStorageDao;
import com.sorawingwind.storage.dao.OrderDao;
import com.sorawingwind.storage.dao.OutStorageDao;
import io.ebean.Ebean;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/outStorage")
public class OutStorageController {

    @Autowired
    private OutStorageDao dao;
    @Autowired
    private InStorageDao inStorageDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DictController dictController;
    @Value("${project.file.path}")
    private String path;

    @GetMapping
    @PreAuthorize("hasAuthority('I-4')")
    public RS getByPage(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) String customerNameItem, @RequestParam(required = false) String item, @RequestParam(required = false) String poNum, @RequestParam(required = false) String code, @RequestParam(required = false) String starttime, @RequestParam(required = false) String endtime) {
        List<SqlRow> list = this.dao.getByPage(pageIndex, pageSize, customerNameItem, item, poNum, code, starttime, endtime);
        Integer totleRowCount = this.dao.getCountByPage(pageIndex, pageSize, customerNameItem, item, poNum, code, starttime, endtime);

        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> ctDicts = this.dictController.getDictDoByType("ct");

        List<OutStorageAo> listaor = list.stream().map(itemInner -> {
            OutStorageAo aoInner = new OutStorageAo();
            aoInner.setId(itemInner.getString("id"));
            aoInner.setInStorageId(itemInner.getString("in_storage_id"));
            aoInner.setInStorageCode(itemInner.getString("in_storage_code"));
            aoInner.setCode(itemInner.getString("code"));
            aoInner.setBunchCount(itemInner.getBigDecimal("bunch_count"));
            aoInner.setCreateTime(itemInner.getDate("create_time"));
            aoInner.setImage(itemInner.getString("image"));
            aoInner.setOtimage(itemInner.getString("otimage"));
            aoInner.setOutCount(itemInner.getString("out_count"));
            aoInner.setName(itemInner.getString("name"));
            aoInner.setPoNum(itemInner.getString("po_num"));
            aoInner.setItem(itemInner.getString("item"));
            aoInner.setPart(itemInner.getString("part"));
            aoInner.setCount(itemInner.getString("count"));
            aoInner.setPartSumCount(itemInner.getBigDecimal("part_sum_count"));
            aoInner.setIsDelete(0);
            aoInner.setCustomerName(customerDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("customer_name"))).findFirst().get().getItemName());
            aoInner.setCustomerNameId(itemInner.getString("customer_name"));
            aoInner.setColor(colorDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("color"))).map(DictDo::getItemName).findFirst().orElse(""));
            aoInner.setColorId(itemInner.getString("color"));
            aoInner.setBake(ctDicts.stream().filter(dict -> dict.getId().equals(itemInner.getString("bake"))).map(DictDo::getItemName).findFirst().orElse(""));
            aoInner.setBakeId(itemInner.getString("bake"));
            aoInner.setOutTypeId(itemInner.getString("out_type"));
            aoInner.setOutType(OutType.getNameByIndex(Integer.parseInt(itemInner.getString("out_type"))));
            aoInner.setInCount(itemInner.getString("in_count"));
            return aoInner;
        }).collect(Collectors.toList());
        return RS.ok(new PageRS<>(pageSize, pageIndex, totleRowCount, totleRowCount / pageSize, listaor));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('I-4')")
    public RS save(@RequestBody OutStorageAo outStorageAo) {
        OutStorageDo doo = new OutStorageDo();
        BeanUtils.copyProperties(outStorageAo, doo);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date end = calendar.getTime();
        int count = Ebean.createQuery(OutStorageDo.class).where().ge("create_time", start).le("create_time", end).findCount();
        doo.setImage(outStorageAo.getOtimage());
        doo.setCode(CodeGenerUtil.getCode("O", count));
        doo.setId(UUIDUtil.simpleUUid());
        doo.setCreateTime(new Date());
        doo.setIsDelete(0);
        this.dao.save(doo);
        return RS.ok();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('I-4')")
    public RS update(@RequestBody OutStorageAo outStorageAo) {
        OutStorageDo doo = new OutStorageDo();
        BeanUtils.copyProperties(outStorageAo, doo);
        doo.setImage(outStorageAo.getOtimage());
        doo.setModifiedTime(new Date());
        this.dao.update(doo);
        return RS.ok();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('I-4')")
    public RS delete(@RequestBody List<String> ids) {
        List<OutStorageDo> list = Ebean.createQuery(OutStorageDo.class).where().idIn(ids).findList();
        for (OutStorageDo doo : list) {
            doo.setIsDelete(1);
        }
        this.dao.updataAll(list);
        return RS.ok();
    }

    @PostMapping("/image")
    public RS upload(MultipartFile file) throws IOException {
        String originFilename = file.getOriginalFilename();
        String suffixName = originFilename.substring(originFilename.lastIndexOf('.'));
        String filename = UUIDUtil.simpleUUid() + suffixName;
        File dest = new File(this.path, filename).getAbsoluteFile();
        File parent = dest.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw new IOException("创建上传目录失败: " + parent);
        }
        file.transferTo(dest);
        return RS.ok(filename);
    }

    @GetMapping("/code")
    @PreAuthorize("hasAuthority('I-4')")
    public RS getByCode(@RequestParam(required = false) String code, @RequestParam(required = false) String orderId, @RequestParam(required = false) String item) {
        List<Map<String, String>> listaor = this.dao.getByCode(code, orderId, item).stream().map(iitem -> {
            Map<String, String> map = new HashMap<>();
            map.put("label", iitem.getString("code"));
            map.put("value", iitem.getString("id"));
            return map;
        }).collect(Collectors.toList());
        return RS.ok(listaor);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('I-4') or hasAuthority('I-9')") // 订单组页面下钻出库单也使用此接口
    public RS getListByInStorage(@RequestParam String inStorageId, @RequestParam(required = false) String outCode, @RequestParam(required = false) String outStarttime, @RequestParam(required = false) String outEndtime) {
        return RS.ok(this.dao.getByInStorageId(inStorageId, outCode, outStarttime, outEndtime).stream().map(item -> {
            OutStorageAo aoInner = new OutStorageAo();
            InStorageDo inStorageDo = this.inStorageDao.getById(inStorageId);
            OrderDo orderDo = this.orderDao.getById(inStorageDo.getOrderId());
            BeanUtils.copyProperties(item, aoInner);
            aoInner.setOutType(OutType.getNameByIndex(Integer.parseInt(item.getOutType())));
            aoInner.setCustomerName(this.dictController.getById(orderDo.getCustomerName()).getItemName());
            aoInner.setImage(orderDo.getImage());
            aoInner.setOtimage(item.getImage());
            aoInner.setItem(orderDo.getItem());
            aoInner.setPoNum(orderDo.getPoNum());
            aoInner.setPart(orderDo.getPart());
            aoInner.setColor(StringUtils.isNotBlank(inStorageDo.getColor()) ? this.dictController.getById(inStorageDo.getColor()).getItemName() : "");
            aoInner.setBake(StringUtils.isNotBlank(inStorageDo.getBake()) ? this.dictController.getById(inStorageDo.getBake()).getItemName() : "");
            aoInner.setCount(orderDo.getCount() + "");
            aoInner.setInCount(inStorageDo.getInCount());
            return aoInner;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/one")
    @PreAuthorize("hasAuthority('I-4') or hasAuthority('I-9')") // 订单组页面下钻出库单也使用此接口
    public RS getOneByInStorage(@RequestParam String outStorageId, @RequestParam(required = false) String outCode, @RequestParam(required = false) String outStarttime, @RequestParam(required = false) String outEndtime) {
        return RS.ok(this.dao.getById(outStorageId, outCode, outStarttime, outEndtime).stream().map(item -> {
            OutStorageAo aoInner = new OutStorageAo();
            InStorageDo inStorageDo = this.inStorageDao.getById(item.getInStorageId());
            OrderDo orderDo = this.orderDao.getById(inStorageDo.getOrderId());
            BeanUtils.copyProperties(item, aoInner);
            aoInner.setOutType(OutType.getNameByIndex(Integer.parseInt(item.getOutType())));
            aoInner.setCustomerName(this.dictController.getById(orderDo.getCustomerName()).getItemName());
            aoInner.setImage(orderDo.getImage());
            aoInner.setOtimage(item.getImage());
            aoInner.setItem(orderDo.getItem());
            aoInner.setPoNum(orderDo.getPoNum());
            aoInner.setPart(orderDo.getPart());
            aoInner.setColor(StringUtils.isNotBlank(inStorageDo.getColor()) ? this.dictController.getById(inStorageDo.getColor()).getItemName() : "");
            aoInner.setBake(StringUtils.isNotBlank(inStorageDo.getBake()) ? this.dictController.getById(inStorageDo.getBake()).getItemName() : "");
            aoInner.setCount(orderDo.getCount() + "");
            aoInner.setInCount(inStorageDo.getInCount());
            return aoInner;
        }).collect(Collectors.toList()));
    }

    @PostMapping("/excel")
    @PreAuthorize("hasAuthority('I-4')")
    public void download(HttpServletResponse response, @RequestBody OutStorageExcelAo outStorageExcelAo) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("出库明细", "UTF-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx;" + "filename*=utf-8''" + fileName + ".xlsx");
        OutputStream outputStream = response.getOutputStream();
        //FileOutputStream outputStream = new FileOutputStream("/home/sorawingwind/桌面/xx.xlsx");
        List<OutStorageEto> listeto = this.getAndBuildEtos(outStorageExcelAo.getCustomerNameItem(), outStorageExcelAo.getItem(), outStorageExcelAo.getPoNum(), outStorageExcelAo.getCode(), outStorageExcelAo.getStarttime(), outStorageExcelAo.getEndtime());
        // 获取模板路径
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/excel/outStorage.xlsx");
        // 创建输出的excel对象
        final ExcelWriter write = EasyExcel.write(outputStream).withTemplate(resourceAsStream).build();
        // 创建第一个sheel页
        final WriteSheet sheet1 = EasyExcel.writerSheet(0, "出库明细").build();
        write.fill(listeto, sheet1);
        // 关闭流
        write.finish();
    }

    public List<OutStorageEto> getAndBuildEtos(String customerNameItem,String item,String poNum,String code,String starttime,String endtime){
        //获取数据
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> bakeDicts = this.dictController.getDictDoByType("ct");
        Map<String,Integer> sumMap = this.dao.getAllSumBunchCount(customerNameItem,item,poNum,code,starttime,endtime);
        List<OutStorageAo> listdo = this.dao.getExcels(customerNameItem,item,poNum,code,starttime,endtime).stream().map(iitem -> {
            iitem.setCustomerName(customerDicts.stream().filter(c -> c.getId().equals(iitem.getCustomerName())).findFirst().get().getItemName());
            iitem.setColor(colorDicts.stream().filter(c -> c.getId().equals(iitem.getColor())).map(DictDo::getItemName).findFirst().orElse(""));
            iitem.setBake(bakeDicts.stream().filter(c -> c.getId().equals(iitem.getBake())).map(DictDo::getItemName).findFirst().orElse(""));
            iitem.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(iitem.getCreateTime()));
            if (iitem.getOrderPartSumCount() != null) {
                int outSumBunchCount = sumMap.get(iitem.getOrderId());
                iitem.setLeftPartSumCount(iitem.getOrderPartSumCount() - outSumBunchCount);
            }
            return iitem;
        }).collect(Collectors.toList());
        return new ListUtil<OutStorageAo, OutStorageEto>().copyList(listdo, OutStorageEto.class);

    }

    public List<OutStorageEto> getAndBuildEtosByIn(String inids,String code,String starttime,String endtime){
        List<DictDo> customerDicts = this.dictController.getDictDoByType("customer");
        List<DictDo> colorDicts = this.dictController.getDictDoByType("color");
        List<DictDo> bakeDicts = this.dictController.getDictDoByType("ct");
        Map<String,Integer> sumMap = this.dao.getAllSumBunchCount(inids,code,starttime,endtime);

        //获取数据
        List<OutStorageAo> listdo = this.dao.getExcelsByIn(inids,code,starttime,endtime).stream().map(iitem -> {
            iitem.setCustomerName(customerDicts.stream().filter(c -> c.getId().equals(iitem.getCustomerName())).findFirst().get().getItemName());
            iitem.setColor(colorDicts.stream().filter(c -> c.getId().equals(iitem.getColor())).map(DictDo::getItemName).findFirst().orElse(""));
            iitem.setBake(bakeDicts.stream().filter(c -> c.getId().equals(iitem.getBake())).map(DictDo::getItemName).findFirst().orElse(""));
            iitem.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(iitem.getCreateTime()));
            if (iitem.getOrderPartSumCount() != null) {
                int outSumBunchCount = sumMap.get(iitem.getOrderId());
                iitem.setLeftPartSumCount(iitem.getOrderPartSumCount() - outSumBunchCount);
            }
            return iitem;
        }).collect(Collectors.toList());
        return new ListUtil<OutStorageAo, OutStorageEto>().copyList(listdo, OutStorageEto.class);

    }
}
