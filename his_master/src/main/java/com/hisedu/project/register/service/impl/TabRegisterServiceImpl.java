package com.hisedu.project.register.service.impl;

import java.util.List;

import com.hisedu.project.doctor.domain.TabDoctor;
import com.hisedu.project.doctor.mapper.TabDoctorMapper;
import com.hisedu.project.keshi.domain.TabKeshi;
import com.hisedu.project.keshi.mapper.TabKeshiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisedu.project.register.domain.TabRegister;
import com.hisedu.project.register.mapper.TabRegisterMapper;
import com.hisedu.project.register.service.ITabRegisterService;

@Service
public class TabRegisterServiceImpl implements ITabRegisterService{

	@Autowired
	private TabRegisterMapper tabRegisterMapper;
	@Autowired
	private TabKeshiMapper tabKeshiMapper;
	@Autowired
	private TabDoctorMapper tabDoctorMapper;
	
	
	@Override
	public List<TabRegister> selectTabRegisterList(TabRegister tabRegister) {
		// TODO Auto-generated method stub
		return tabRegisterMapper.selectTabRegisterList(tabRegister);
	}


	@Override
	public int insertTabRegister(TabRegister tabRegister) {
		// TODO Auto-generated method stub
		Long deptmentId = tabRegister.getDeptmentId();
		Long employeeId = tabRegister.getEmployeeId();
		TabKeshi tabKeshi = tabKeshiMapper.selectTabKeshiById(deptmentId);
		TabDoctor tabDoctor = tabDoctorMapper.selectTabDoctorById(employeeId);
		tabRegister.setDeptmentName(tabKeshi.getKsname());
		tabRegister.setEmployeeName(tabDoctor.getName());
		return tabRegisterMapper.insertTabRegister(tabRegister);
	}


	@Override
	public TabRegister selectTabRegisterById(Long id) {
		// TODO Auto-generated method stub
		return tabRegisterMapper.selectTabRegisterById(id);
	}


	@Override
	public int updateRegister(TabRegister tabRegister) {
		// TODO Auto-generated method stub
		return tabRegisterMapper.updateRegister(tabRegister);
	}


	@Override
	public int deletTabRegisterById(Long id) {
		// TODO Auto-generated method stub
		return tabRegisterMapper.deletTabRegisterById(id);
	}

}
