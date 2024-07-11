package com.hisedu.project.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisedu.project.doctor.domain.TabDoctor;
import com.hisedu.project.doctor.mapper.TabDoctorMapper;
import com.hisedu.project.doctor.service.ITabDoctorService;

@Service
public class TabDoctorServiceImpl implements ITabDoctorService{

	@Autowired
	private TabDoctorMapper tabDoctorMapper;
	
	@Override
	public List<TabDoctor> selectTabDoctorList(TabDoctor tabDoctor) {
		// TODO Auto-generated method stub
		return tabDoctorMapper.selectTabDoctorList(tabDoctor);
	}

	@Override
	public int insertTabDoctor(TabDoctor tabDoctor) {
		// TODO Auto-generated method stub
		return tabDoctorMapper.insertTabDoctor(tabDoctor);
	}

	@Override
	public TabDoctor selectTabDoctorById(Long id) {
		// TODO Auto-generated method stub
		return tabDoctorMapper.selectTabDoctorById(id);
	}

	@Override
	public int updateTabDoctor(TabDoctor tabDoctor) {
		// TODO Auto-generated method stub
		return tabDoctorMapper.updateTabDoctor(tabDoctor);
	}

	@Override
	public int deleteTabDoctorById(Long id) {
		// TODO Auto-generated method stub
		return tabDoctorMapper.deleteTabDoctorById(id);
	}

	
	
	
}
