package com.sorawingwind.storage.controller;

import cn.hutool.core.lang.Dict;
import com.cotte.estate.bean.pojo.ao.storage.DictAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QDictAo;
import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estatecommon.RS;
import com.cotte.estatecommon.utils.ListUtil;
import com.cotte.estatecommon.utils.UUIDUtil;
import com.sorawingwind.storage.dao.DictDao;
import io.ebean.Ebean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictDao dao;

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('I-2')")
    public RS getDictByType(@RequestParam String type) {
        return this.dao.getDictByType(type);

    }

    @PostMapping("/item")
    @PreAuthorize("hasAuthority('I-2')")
    public RS save(@RequestBody DictAo ao) {
        ao.setId(UUIDUtil.simpleUUid());
        ao.setItem(UUIDUtil.simpleUUid());
        DictDo doo = new DictDo();
        BeanUtils.copyProperties(ao, doo);
        this.dao.save(doo);
        return RS.ok();
    }

    public List<DictDo> getDictDoByType(@RequestParam String type) {
        return this.dao.getDictDoByType(type);
    }

    public DictDo getById(String id) {
        if (StringUtils.isBlank(id)) {
            return new DictDo();
        }
        DictDo doo = this.dao.getById(id);
        if (doo == null) {
            return new DictDo();
        } else {
            return doo;
        }
    }

    @DeleteMapping("/item")
    @PreAuthorize("hasAuthority('I-2')")
    public RS delete(@RequestParam String id, @RequestParam String type) {
        // 检查字典值是否正在被使用
        if (StringUtils.isBlank(id) || StringUtils.isBlank(type)) {
            return RS.warn("参数不能为空");
        }

        // 只对客户、镀金颜色、烤厅三个类型进行删除前校验
        if ("customer".equals(type) || "color".equals(type) || "ct".equals(type)) {
            int usageCount = this.dao.checkDictUsage(id, type);
            if (usageCount > 0) {
                String typeName;
                String usageInfo;
                switch (type) {
                    case "customer":
                        typeName = "客户";
                        usageInfo = "订单或订单组";
                        break;
                    case "color":
                        typeName = "镀金颜色";
                        usageInfo = "订单或入库单";
                        break;
                    case "ct":
                        typeName = "烤厅";
                        usageInfo = "订单或入库单";
                        break;
                    default:
                        typeName = "该字典";
                        usageInfo = "业务数据";
                }
                return RS.warn(typeName + "已被 " + usageCount + " 条" + usageInfo + "使用，无法删除");
            }
        }

        // 执行删除
        this.dao.delete(id);
        return RS.ok();
    }

    @PutMapping("/item")
    @PreAuthorize("hasAuthority('I-2')")
    public RS update(@RequestBody DictAo ao) {
        if (StringUtils.isBlank(ao.getId()) || StringUtils.isBlank(ao.getItemName())) {
            return RS.warn("参数不能为空");
        }
        DictDo doo = this.dao.getById(ao.getId());
        if (doo == null) {
            return RS.warn("字典项不存在");
        }
        doo.setItemName(ao.getItemName());
        this.dao.update(doo);
        return RS.ok();
    }

}
