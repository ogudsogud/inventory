package com.msg.data.service;

import com.msg.data.model.PartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface PartsService {

    List<PartsModel> getDataParts();

    boolean insertPartsNew(PartsModel partsModel);

    boolean isPartsExist(String id_part_number);

    PartsModel getByUnitName(String unit_parts_name);

    PartsModel getByIdPartNumb(String id_part_number);

    PartsModel getByIdPart(String id_mtr_parts);

    void updatePart(PartsModel partsModel);

    void deleteById(String id_mtr_parts);
}
