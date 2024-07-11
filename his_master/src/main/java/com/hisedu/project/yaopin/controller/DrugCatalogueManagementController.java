package com.hisedu.project.yaopin.controller;

import com.hisedu.common.enums.EnumCode;
import com.hisedu.common.utils.ResultUtil;
import com.hisedu.project.yaopin.domain.Drugs;
import com.hisedu.project.yaopin.service.DrugCatalogueManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/outpatientPharmacyWorkstation/drugCatalogueManagement")
public class DrugCatalogueManagementController {
    @Autowired
    private DrugCatalogueManagementService service;

    @RequestMapping("/selectAll")
    public ResultUtil selectAll(Drugs u) {
        System.out.println(u);
        List<Drugs> list = service.selectAll(u);
        if (list != null) {
            System.out.println("执行了查询语句");
            return new ResultUtil(EnumCode.OK.getValue(), "查询成功", service.selectAll(u));
        }
        return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "查询失败");
    }

    @RequestMapping("/add")
    public ResultUtil add(Drugs u) {
        System.out.println(u);
        u.setCreationDate(new Date());
        u.setLastUpdateDate(new Date());
        int res = service.add(u);
        if (res == 1) {
            System.out.println("执行了增加语句");
            return new ResultUtil(EnumCode.OK.getValue(), "添加药品信息成功");
        }
        return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "添加药品信息失败");
    }

    @RequestMapping("/update")
    public ResultUtil update(@RequestParam Integer id, @RequestParam String drugsCode, @RequestParam String drugsName, @RequestParam String drugsFormat, @RequestParam String drugsUnit, @RequestParam String manufacturer, @RequestParam Integer drugsDosageID, @RequestParam Integer drugsTypeID, @RequestParam BigDecimal drugsPrice, @RequestParam String mnemonicCode, @RequestParam String lastUpdateDate) {
        System.out.println("---u=" + id + "555555555" + drugsDosageID);
        int res = service.update(id, drugsCode, drugsName, drugsFormat, drugsUnit, manufacturer, drugsDosageID, drugsTypeID, drugsPrice, mnemonicCode, lastUpdateDate);
        if (res == 1) {
            System.out.println("执行了修改语句");
            return new ResultUtil(EnumCode.OK.getValue(), "更新药品信息成功");
        }
        return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "更新药品信息失败");
    }

    @RequestMapping("/delete")
    public ResultUtil delete(@RequestParam String id) {
        System.out.println("come in ''删除语句");
        int res = service.delete(id);
        System.out.println("-------------" + id);
        if (res == 1) {
            System.out.println("执行了删除语句");
            return new ResultUtil(EnumCode.OK.getValue(), "药品信息删除成功");
        }
        return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "药品信息删除失败");
    }


}
