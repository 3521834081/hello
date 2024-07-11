package com.hisedu.project.jianchaxiang.mapper;

import java.util.List;

import com.hisedu.project.jianchaxiang.domain.TabJianchaxiang;

public interface TabJianchaxiangMapper {
	
	
	/**
	 * 检查项目查询信息
	 */
	public TabJianchaxiang selectTabJianchaxiangById(Long id);
	
	/**
	 * 检查项目查询列表
	 */
	public List<TabJianchaxiang> selectTabJianchaxiang(TabJianchaxiang tabJianchaxiang);
	
	
	/**
	 * 新增检查项目
	 */
	public int insertTabJianchaxiang(TabJianchaxiang tabJianchaxiang);
	
	
	/**
	 * 修改检查项目
	 */
	public int updateTabJianchaxiang(TabJianchaxiang tabJianchaxiang);
	
	
	/**
	 * 删除检查项目
	 */
	public int deleteTabJianchaxiangById(Long id);
	
}
