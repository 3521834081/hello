package com.hisedu.project.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hisedu.framework.web.controller.BaseController;
import com.hisedu.framework.web.domain.AjaxResult;
import com.hisedu.framework.web.page.TableDataInfo;
import com.hisedu.project.doctor.domain.TabDoctor;
import com.hisedu.project.doctor.service.ITabDoctorService;
import com.hisedu.project.keshi.domain.TabKeshi;
import com.hisedu.project.keshi.service.ITabKeshiService;

@RestController
@RequestMapping("/doctor/doctor")
public class TabDoctorController extends BaseController{

	@Autowired
	private ITabDoctorService doctorService;
	
	@Autowired
	private ITabKeshiService keshiService;
	
	
	/**
     * 获取医生信息
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return AjaxResult.success(doctorService.selectTabDoctorById(id));
    }
	
	
	@PreAuthorize("@ss.hasPermi('doctor:doctor:list')")
    @GetMapping("/list")
    public TableDataInfo list(TabDoctor tabDoctor)
    {
        startPage();
        List<TabDoctor> list = doctorService.selectTabDoctorList(tabDoctor);
        
        return getDataTable(list);
    }
	
	
	/**
     * 新增医生
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TabDoctor tabDoctor)
    {
    	Long ksid = tabDoctor.getKsid();
    	TabKeshi tabKeshi = keshiService.selectTabKeshiById(ksid);
    	if(tabKeshi!=null) {
    		tabDoctor.setKsname(tabKeshi.getKsname());
    	}
    	tabDoctor.setStatus("1");
        return toAjax(doctorService.insertTabDoctor(tabDoctor));
    }
    
    
    /**
     * 修改医生
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody TabDoctor tabDoctor)
    {
    	Long ksid = tabDoctor.getKsid();
    	TabKeshi tabKeshi = keshiService.selectTabKeshiById(ksid);
    	if(tabKeshi!=null) {
    		tabDoctor.setKsname(tabKeshi.getKsname());
    	}
        return toAjax(doctorService.updateTabDoctor(tabDoctor));
    }
    
    /*
    @GetMapping("/getDoctorList/{id}")
    public AjaxResult getDoctorList(@PathVariable("id") Long id)
    {
    	TabDoctor tabDoctor = new TabDoctor();
    	tabDoctor.setKsid(id);
    	tabDoctor.setStatus("1");
    	List<TabDoctor> list = doctorService.selectTabDoctorList(tabDoctor);
        return AjaxResult.success(list);
    }
    /*
    
    /**
     * 修改医生状态
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:edit')")
    @PostMapping("/updateStatus")
    public AjaxResult updateStatus(@Validated @RequestBody TabDoctor tabDoctor)
    {
        return toAjax(doctorService.updateTabDoctor(tabDoctor));
    }
    
    
    /**
     * 删除医生
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:remove')")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        return toAjax(doctorService.deleteTabDoctorById(ids));
    }
    
    
    
    @GetMapping("/getDoctorList/{id}")
    public AjaxResult getDoctorList(@PathVariable("id") Long id)
    {
           TabDoctor tabDoctor = new TabDoctor();
           tabDoctor.setKsid(id);
           tabDoctor.setStatus("1");
           return AjaxResult.success(doctorService.selectTabDoctorList(tabDoctor));
    }
    
    
    
}
