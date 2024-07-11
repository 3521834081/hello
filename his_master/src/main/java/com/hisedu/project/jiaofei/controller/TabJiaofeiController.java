package com.hisedu.project.jiaofei.controller;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.hisedu.framework.web.controller.BaseController;
import com.hisedu.framework.web.domain.AjaxResult;
import com.hisedu.framework.web.page.TableDataInfo;
import com.hisedu.project.doctor.domain.TabDoctor;
import com.hisedu.project.jianchaxiang.domain.TabJianchaxiang;
import com.hisedu.project.jianchaxiang.service.ITabJianchaxiangService;
import com.hisedu.project.jiaofei.domain.TabJiaofei;
import com.hisedu.project.jiaofei.service.ITabJiaofeiService;
import com.hisedu.project.keshi.domain.TabKeshi;

@RestController
@RequestMapping("/jiaofei/jiaofei")
public class TabJiaofeiController extends BaseController{

	@Autowired
	private ITabJiaofeiService tabJiaofeiService;

	@Autowired
	private ITabJianchaxiangService tabJianchaxiangService;

    @GetMapping("/list")
    public TableDataInfo list(TabJiaofei tabJiaofei)
    {
        startPage();
        List<TabJiaofei> list = tabJiaofeiService.selectTabJiaofeiList(tabJiaofei);

        return getDataTable(list);
    }


    /**
     * 新增交费
     */
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TabJiaofei tabJiaofei)
    {
    	Long[] jcxmIds = tabJiaofei.getJcxmIds();
    	String jcxmids = "";
    	String jcxmname = "";
    	int num = 0;
    	double price = 0.0;
    	if(jcxmIds.length>0) {
    		for(int i=0;i<jcxmIds.length;i++) {
    			TabJianchaxiang tabJianchaxiang = tabJianchaxiangService.selectTabJianchaxiangById(jcxmIds[i]);
    			jcxmids = jcxmids+jcxmIds[i]+"，";
    			jcxmname = jcxmname+tabJianchaxiang.getJcname()+"，";
    			num = num+1;
    			price = price+tabJianchaxiang.getPrice();
    		}
    	}
    	tabJiaofei.setJcxmids(jcxmids.substring(0, jcxmids.length()-1));
    	tabJiaofei.setJcxmname(jcxmname.substring(0, jcxmname.length()-1));
    	tabJiaofei.setJcxmnum(num);
    	tabJiaofei.setPrice(price);
    	tabJiaofei.setAddtime(new Date());
    	tabJiaofei.setStatus("1");
        return toAjax(tabJiaofeiService.insertTabJiaofei(tabJiaofei));
    }



    /**
     * 删除交费
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        return toAjax(tabJiaofeiService.deleteTabJiaofeiById(ids));
    }


    /**
     *
     */
    @PutMapping()
    public AjaxResult updateStatus(@Validated @RequestBody TabJiaofei tabJiaofei)
    {
        return toAjax(tabJiaofeiService.updateTabJiaofei(tabJiaofei));
    }

    @GetMapping("/{id}")
    public AjaxResult getJiaofei(@PathVariable("id")Long id) {
        List<TabJiaofei> tabJiaofeis = tabJiaofeiService.selectTabJiaofeiList(new TabJiaofei());
        List<TabJiaofei> collect = tabJiaofeis.stream().filter(tabJiaofei -> {
            return tabJiaofei.getId().equals(id);
        }).collect(Collectors.toList());
        if (collect.isEmpty()){
            return AjaxResult.success();
        }
        return AjaxResult.success(collect.get(0));
    }
}
