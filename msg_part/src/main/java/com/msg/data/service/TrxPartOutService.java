package com.msg.data.service;

import com.msg.data.model.TrxPartOutModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public interface TrxPartOutService {


    List<TrxPartOutModel> getPartsStockOut();

    boolean insertPartsOut(TrxPartOutModel trxPartOutModel);

    void updateTrxPart(TrxPartOutModel trxPartInModel);

    boolean isPartsOutExist(String po_number);

    TrxPartOutModel getByTikno(String ticket_no);

    void deleteByTicket(String ticket_no);
}
