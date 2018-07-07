package com.msg.data.service;

import com.msg.data.model.PartsModel;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface PartsService {

    boolean insertParts(PartsModel partsModel);

    boolean isPartsExist(String part_number);
}
