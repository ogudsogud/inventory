package com.msg.data.service;

import com.msg.data.model.PartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface PartsService {


    List<PartsModel> getDataParts();

    boolean insertPartsNew(PartsModel partsModel);

    void updatePart(PartsModel partsModel);

    void deletePartNumber(String id_parts_number);
}
