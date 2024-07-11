package com.hisedu.project.keshi.controller;

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

import com.hisedu.framework.aspectj.lang.annotation.Log;
import com.hisedu.framework.aspectj.lang.enums.BusinessType;
import com.hisedu.framework.web.controller.BaseController;
import com.hisedu.framework.web.domain.AjaxResult;
import com.hisedu.framework.web.page.TableDataInfo;
import com.hisedu.project.keshi.domain.TabKeshi;
import com.hisedu.project.keshi.service.ITabKeshiService;
import com.hisedu.project.system.domain.SysNotice;

@RestController
@RequestMapping("/keshi/keshi")
public class TabKeshiController extends BaseController{

	@Autowired
	private ITabKeshiService tabKeshiService;
	
	
	/**
     * 获取科室信息
     */
    @PreAuthorize("@ss.hasPermi('keshi:keshi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return AjaxResult.success(tabKeshiService.selectTabKeshiById(id));
    }
	
	
	@PreAuthorize("@ss.hasPermi('keshi:keshi:list')")
    @GetMapping("/list")
    public TableDataInfo list(TabKeshi tabKeshi)
    {
        startPage();
        List<TabKeshi> list = tabKeshiService.selectTabKeshiList(tabKeshi);
        
        return getDataTable(list);
    }
	
	
	/**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('keshi:keshi:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TabKeshi tabKeshi)
    {
    	tabKeshi.setStatus("1");
        return toAjax(tabKeshiService.insertTabKeshi(tabKeshi));
    }
    
    
    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('keshi:keshi:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody TabKeshi tabKeshi)
    {
        return toAjax(tabKeshiService.updateTabKeshi(tabKeshi));
    }
    
    
    
    /**
     * 修改科室状态
     */
    @PreAuthorize("@ss.hasPermi('keshi:keshi:edit')")
    @PostMapping("/updateStatus")
    public AjaxResult updateStatus(@RequestBody TabKeshi tabKeshi)
    {
        return toAjax(tabKeshiService.updateTabKeshi(tabKeshi));
    }
    
    
    
    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('keshi:keshi:remove')")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        return toAjax(tabKeshiService.deleteTabKeshiById(ids));
    }
    
    
    /**
     * 获取所有可用科室列表
     */
    @PreAuthorize("@ss.hasPermi('keshi:keshi:query')")
    @GetMapping("/getKeshiList")
    public AjaxResult getKeshiList()
    {
    	TabKeshi tabKeshi = new TabKeshi();
    	tabKeshi.setStatus("1");
    	List<TabKeshi> list = tabKeshiService.selectTabKeshiList(tabKeshi);
        return AjaxResult.success(list);
    }
	
	
}
