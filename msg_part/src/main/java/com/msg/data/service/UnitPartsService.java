package com.msg.data.service;

import com.msg.data.model.UnitPartsModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public interface UnitPartsService {


    //untuk menampilkan data parts
    List<UnitPartsModel> getDataParts();

    //untuk insert unit parts
    boolean insertUnitPartsNew(UnitPartsModel unitPartsModel);

    //jika insert parts baru sudah ada
    boolean isPartsExist(String part_number);

    //untuk mencari data parts berdasarkan parameter
    UnitPartsModel getByUnitPartNumb(String part_number);

    UnitPartsModel getByUnitPartName(String part_name);
}
