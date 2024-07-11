package com.hisedu.project.jiaofei.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 修改医生状态
     */
    @PostMapping("/updateStatus")
    public AjaxResult updateStatus(@Validated @RequestBody TabJiaofei tabJiaofei)
    {
        return toAjax(tabJiaofeiService.updateTabJiaofei(tabJiaofei));
    }
    
}
