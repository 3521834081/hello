package com.hisedu.project.jianchaxiang.controller;

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
import com.hisedu.project.jianchaxiang.domain.TabJianchaxiang;
import com.hisedu.project.jianchaxiang.service.ITabJianchaxiangService;
import com.hisedu.project.keshi.domain.TabKeshi;

/**
 * 检查项目控制层
 * @author Mr.J
 *
 */
@RestController
@RequestMapping("/jianchaxiang/jianchaxiang")
public class TabJianchaxiangController extends BaseController{

	@Autowired
	private ITabJianchaxiangService tabJianchaxiangService;
	

	/**
     * 获取科室信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return AjaxResult.success(tabJianchaxiangService.selectTabJianchaxiangById(id));
    }
    
    
    @GetMapping("/list")
    public TableDataInfo list(TabJianchaxiang tabJianchaxiang)
    {
        startPage();
        List<TabJianchaxiang> list = tabJianchaxiangService.selectTabJianchaxiang(tabJianchaxiang);
        
        return getDataTable(list);
    }
	
	
    /**
     * 新增检查项目
     */
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TabJianchaxiang tabJianchaxiang)
    {
    	tabJianchaxiang.setStatus("1");
        return toAjax(tabJianchaxiangService.insertTabJianchaxiang(tabJianchaxiang));
    }
	
    
    /**
     * 修改检查项目
     */
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody TabJianchaxiang tabJianchaxiang)
    {
        return toAjax(tabJianchaxiangService.updateTabJianchaxiang(tabJianchaxiang));
    }
    
    
    /**
     * 删除检查项
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        return toAjax(tabJianchaxiangService.deleteTabJianchaxiangById(ids));
    }
    
    
    
    /**
     * 修改检查项目状态
     */
    @PostMapping("/updateStatus")
    public AjaxResult updateStatus(@RequestBody TabJianchaxiang tabJianchaxiang)
    {
        return toAjax(tabJianchaxiangService.updateTabJianchaxiang(tabJianchaxiang));
    }
    
    
    @GetMapping("/getJcxmList")
    public AjaxResult getJcxmList()
    {
    	TabJianchaxiang tabJianchaxiang = new TabJianchaxiang();
    	tabJianchaxiang.setStatus("1");
    	List<TabJianchaxiang> list = tabJianchaxiangService.selectTabJianchaxiang(tabJianchaxiang);
        return AjaxResult.success(list);
    }

}
