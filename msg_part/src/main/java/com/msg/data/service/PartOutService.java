package com.msg.data.service;

import com.msg.data.model.PartOutModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public interface PartOutService {


    List<PartOutModel> getPartsStockOut();

    boolean insertPartsOut(PartOutModel partOutModel);

    boolean isPartsOutExist(String po_number);

    PartOutModel getByPoNumb(String po_number);

    PartOutModel getByPartNumb(String part_number);
}
