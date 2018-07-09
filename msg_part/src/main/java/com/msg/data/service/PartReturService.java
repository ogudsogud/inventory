package com.msg.data.service;

import com.msg.data.model.PartReturModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public interface PartReturService {

    List<PartReturModel> getPartsStockIn();

    boolean insertPartsStock(PartReturModel returModel);

    boolean isPartsExist(String part_number);
}
