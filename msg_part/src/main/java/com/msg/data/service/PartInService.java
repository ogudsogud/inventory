package com.msg.data.service;

import com.msg.data.model.PartInModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public interface PartInService {

    List<PartInModel> getPartsStockIn();

    boolean insertPartsStock(PartInModel partInModel);

    boolean isPartsExist(String part_number);
}
