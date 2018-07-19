package com.msg.data.service;

import com.msg.data.model.StockPartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface StockPartsService {

    List<StockPartsModel> getDataStockParts();

    boolean insertStockPartsNew(StockPartsModel stockPartsModel);

    boolean isStockPartsExist(String id_part_number);

    StockPartsModel getPartNumb(String id_part_number);

    StockPartsModel getByStockPartName(String part_name);
}
