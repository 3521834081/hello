package com.hisedu.project.register.controller;

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
import com.hisedu.project.keshi.domain.TabKeshi;
import com.hisedu.project.register.domain.TabRegister;
import com.hisedu.project.register.service.ITabRegisterService;

@RestController
@RequestMapping("/register/register")
public class TabRegisterController extends BaseController{

	@Autowired
	private ITabRegisterService tabRegisterService;
	
	
	/**
     * 获取挂号信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return AjaxResult.success(tabRegisterService.selectTabRegisterById(id));
    }
	
	
    @GetMapping("/list")
    public TableDataInfo list(TabRegister tabRegister)
    {
        startPage();
        List<TabRegister> list = tabRegisterService.selectTabRegisterList(tabRegister);
        
        return getDataTable(list);
    }
    
    
    
    /**
     * 新增挂号
     */
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TabRegister tabRegister)
    {
    	
    	tabRegister.setVisitState("1");
        return toAjax(tabRegisterService.insertTabRegister(tabRegister));
    }
  
    
    /**
     * 修改挂号
     */
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody TabRegister tabRegister)
    {
    
        return toAjax(tabRegisterService.updateRegister(tabRegister));
    }
    
    /**
     * 删除挂号
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        return toAjax(tabRegisterService.deletTabRegisterById(ids));
    }
    
    
    /**
     * 退号
     */
    @PostMapping("/updateStatus")
    public AjaxResult updateStatus(@RequestBody TabRegister tabRegister)
    {
        return toAjax(tabRegisterService.updateRegister(tabRegister));
    }
	
}
