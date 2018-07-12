package com.msg.data.service;

import com.msg.data.model.PartOutModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public interface PartOutService {


    List<PartOutModel> getPartsStockOut();

    boolean insertPartsOut(PartOutModel partOutModel);

    boolean isPartsOutExist(String ticket_no);

    PartOutModel getByPoNumb(String ticket_no);

    PartOutModel getByPartNumb(String part_number);
}
