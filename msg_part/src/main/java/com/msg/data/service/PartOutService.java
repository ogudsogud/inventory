package com.msg.data.service;

import com.msg.data.model.PartOutModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public interface PartOutService {


    //untuk menampilkan data parts stock-out
    List<PartOutModel> getPartsStockOut();

    //untuk insert parts stock-out
    boolean insertPartsOut(PartOutModel partOutModel);

    //jika insert parts-out sudah ada
    boolean isPartsOutExist(String po_number);

    //untuk mencari data parts berdasarkan parameter
    PartOutModel getByPoNumb(String po_number);

    PartOutModel getByPartNumb(String part_number);
}
