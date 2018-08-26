package com.msg.data.service;

import com.msg.data.model.TrxPartInModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public interface TrxPartInService {


    List<TrxPartInModel> getPartsIn();

    boolean insertPartsStock(TrxPartInModel trxPartInModel);

    boolean isPartsInExist(String id_trx_parts_stock_in);

    void updateTrxPart(TrxPartInModel trxPartInModel);

    void deleteId(String trx_parts_stock_in);
}
