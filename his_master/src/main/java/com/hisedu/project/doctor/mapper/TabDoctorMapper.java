package com.hisedu.project.doctor.mapper;

import java.util.List;

import com.hisedu.project.doctor.domain.TabDoctor;

/**
 * 医生管理mapper
 * @author Mr.J
 *
 */
public interface TabDoctorMapper {
	
	
	/**
	 * 查询医生信息
	 */
	public TabDoctor selectTabDoctorById(Long id); 
	

	/**
	 * 查询医生列表
	 */
	public List<TabDoctor> selectTabDoctorList(TabDoctor tabDoctor); 
	
	
	/**
	 * 新增医生
	 */
	
	public int insertTabDoctor(TabDoctor tabDoctor);
	
	
	/**
	 * 修改医生
	 */
	
	public int updateTabDoctor(TabDoctor tabDoctor);
	
	
	/**
	 * 删除医生
	 */

	public int deleteTabDoctorById(Long id);
	
}
