package com.msg.data.service;

import com.msg.data.model.StockPartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface StockPartsService {

    List<StockPartsModel> getDataStockParts();

    boolean insertStockPartsNew(StockPartsModel stockPartsModel);

    boolean isStockPartsExist(String part_number);

    StockPartsModel getByStockPartNumb(String part_number);

    StockPartsModel getByStockPartName(String part_name);
}
