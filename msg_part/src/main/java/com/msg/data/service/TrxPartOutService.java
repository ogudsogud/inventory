package com.msg.data.service;

import com.msg.data.model.TrxPartOutModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public interface TrxPartOutService {


    List<TrxPartOutModel> getPartsStockOut();

    boolean insertPartsOut(TrxPartOutModel trxPartOutModel);

    boolean isPartsOutExist(String po_number);

    TrxPartOutModel getByPoNumb(String ticket_no);

    void deleteByTicket(String ticket_no);
}
