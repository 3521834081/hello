package com.hisedu.project.yaopin.mapper;


import com.hisedu.project.yaopin.domain.Drugs;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;


/**
 * @Author: ZJH
 * @Date: 2021/12/19/15:18
 * @Description:
 */
@Mapper
public interface DrugCatalogueManagementMapper {
    public List<Drugs> selectAll(Drugs u);

    public int add(Drugs u);

    public int update(Integer ID, String DrugsCode, String DrugsName, String DrugsFormat, String DrugsUnit, String Manufacturer, Integer DrugsDosageID, Integer DrugsTypeID, BigDecimal DrugsPrice, String MnemonicCode, String LastUpdateDate);

    public int delete(String id);

    //public Drugs selectById(Drugs u);
}
