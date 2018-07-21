package com.msg.data.service;

import com.msg.data.model.TrxPartInModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public interface TrxPartInService {

    List<TrxPartInModel> getPartsStockIn();

    boolean insertPartsStock(TrxPartInModel trxPartInModel);

    boolean isPartsInExist(String ticket_no);

    TrxPartInModel getTicketNo(String ticket_no);

    TrxPartInModel getByPartNumb(String id_part_number);
}
