package com.msg.data.service;

import com.msg.data.model.StockPartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface StockPartsService {


    //untuk menampilkan data parts
    List<StockPartsModel> getDataParts();

    //untuk insert unit parts
    boolean insertUnitPartsNew(StockPartsModel stockPartsModel);

    //jika insert parts baru sudah ada
    boolean isPartsExist(String part_number);

    //untuk mencari data parts berdasarkan parameter
    StockPartsModel getByUnitPartNumb(String part_number);

    StockPartsModel getByUnitPartName(String part_name);
}
