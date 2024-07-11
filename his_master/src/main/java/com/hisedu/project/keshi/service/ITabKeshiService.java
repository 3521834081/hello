package com.hisedu.project.keshi.service;

import java.util.List;

import com.hisedu.project.keshi.domain.TabKeshi;

/**
 * 科室管理
 * @author Mr.J
 *
 */
public interface ITabKeshiService {
	
	
	/**
	 * 科室科室查询
	 */
	
	public TabKeshi selectTabKeshiById(Long id);
	

	/**
	 * 科室列表查询
	 */
	
	public List<TabKeshi> selectTabKeshiList(TabKeshi tabKeshi);
	

	/**
	 * 新增科室
	 * @param tabKeshi
	 * @return 0/1
	 */
	public int insertTabKeshi(TabKeshi tabKeshi);
	
	
	/**
	 * 修改科室
	 * @param tabKeshi
	 * @return 0/1
	 */
	public int updateTabKeshi(TabKeshi tabKeshi);
	
	
	
	/**
	 * 删除科室
	 * @param id
	 * @return 0/1
	 */
	public int deleteTabKeshiById(Long id);
	
	
}
