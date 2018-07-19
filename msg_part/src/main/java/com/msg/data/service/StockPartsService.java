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

    StockPartsModel getByIdUnit(String id_unit_parts);

    StockPartsModel getByIdBrand(String id_brand);

    StockPartsModel getByIdPartNumb(String id_part_number);

    void updatePart(StockPartsModel stockPartsModel);
}
