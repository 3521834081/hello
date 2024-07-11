package com.hisedu.project.yaopin.service.impl;


import com.hisedu.project.yaopin.domain.Drugs;
import com.hisedu.project.yaopin.mapper.DrugCatalogueManagementMapper;
import com.hisedu.project.yaopin.service.DrugCatalogueManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: ZJH
 * @Date: 2021/12/19/15:12
 * @Description:
 */
@Service
@Transactional
public class DrugCatalogueManagementServiceImpl implements DrugCatalogueManagementService {
    @Autowired
    private DrugCatalogueManagementMapper dao;

    @Override
    public List<Drugs> selectAll(Drugs u) {
        return dao.selectAll(u);
    }

    @Override
    public Drugs selectById(Drugs u) {
        return null;
    }

    @Override
    public int add(Drugs u) {
        return dao.add(u);
    }


    @Override
    public int update(Integer ID, String DrugsCode, String DrugsName, String DrugsFormat, String DrugsUnit, String Manufacturer, Integer DrugsDosageID, Integer DrugsTypeID, BigDecimal DrugsPrice, String MnemonicCode, String LastUpdateDate) {
        return dao.update(ID, DrugsCode, DrugsName, DrugsFormat, DrugsUnit, Manufacturer, DrugsDosageID, DrugsTypeID, DrugsPrice, MnemonicCode, LastUpdateDate);
    }

    @Override
    public int delete(String id) {
        System.out.println(id);
        return dao.delete(id);
    }
}
