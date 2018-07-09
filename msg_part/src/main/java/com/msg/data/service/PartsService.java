package com.msg.data.service;

import com.msg.data.model.PartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface PartsService {

    List<PartsModel> getDataParts();

    boolean insertPartsNew(PartsModel partsModel);

    boolean isPartsExist(String part_number);

    PartsModel getByPartNumb(String part_number);

//    PartsModel getByPartName(String part_name);
//
//    PartsModel getByBrandName(String brand_name);
}
