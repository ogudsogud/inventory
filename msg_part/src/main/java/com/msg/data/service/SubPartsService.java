package com.msg.data.service;

import com.msg.data.model.SubPartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 9/17/2018.
 */
public interface SubPartsService {

    List<SubPartsModel> getDataParts();

    boolean insertPartsNew(SubPartsModel subPartsModel);

    void updatePart(SubPartsModel subPartsModel);

    void deletePartNumber(String id_parts_number);
}
