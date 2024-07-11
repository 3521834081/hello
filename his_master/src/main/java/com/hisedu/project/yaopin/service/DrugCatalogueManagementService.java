package com.hisedu.project.yaopin.service;


import com.hisedu.project.yaopin.domain.Drugs;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: ZJH
 * @Date: 2021/12/19/15:12
 * @Description:
 */
public interface DrugCatalogueManagementService {
    public List<Drugs> selectAll(Drugs u);

    public Drugs selectById(Drugs u);

    public int add(Drugs u);

    public int update(Integer ID, String DrugsCode, String DrugsName, String DrugsFormat, String DrugsUnit, String Manufacturer, Integer DrugsDosageID, Integer DrugsTypeID, BigDecimal DrugsPrice, String MnemonicCode, String LastUpdateDate);

    public int delete(String id);
}
