package com.msg.data.service;

import com.msg.data.model.PartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface PartsService {

    List<PartsModel> getDataParts();

    boolean insertPartsNew(PartsModel partsModel);

//    boolean isPartsExist(String id_part_number);

    //get by parameter
    PartsModel getParam(String parts_name, String specification);

    PartsModel getByIdPartNumb(String id_part_number);


    PartsModel getByPartsName(String parts_name);

    PartsModel getBySpek(String specification);

    void updatePart(PartsModel partsModel);

    void deletePartNumber(String id_parts_number);
}
