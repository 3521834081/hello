package com.hisedu.project.register.service;

import java.util.List;

import com.hisedu.project.register.domain.TabRegister;

public interface ITabRegisterService {

	/**
	 * 查询全部挂号信息
	 * @param tabRegister
	 * @return
	 */
	public List<TabRegister> selectTabRegisterList(TabRegister tabRegister);
	
	
	/**
	 * 挂号
	 */
	public int insertTabRegister(TabRegister tabRegister);
	
	
	/**
	 * 查询挂号信息
	 * @param id
	 * @return
	 */
	public TabRegister selectTabRegisterById(Long id);
	
	
	/**
	 * 修改挂号
	 */
	public int updateRegister(TabRegister tabRegister);
	
	
	/**
	 * 删除挂号
	 */
	public int deletTabRegisterById(Long id);
	
}
