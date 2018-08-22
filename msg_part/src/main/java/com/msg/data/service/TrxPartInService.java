package com.msg.data.service;

import com.msg.data.model.TrxPartInModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public interface TrxPartInService {


    List<TrxPartInModel> getPartsStockIn();

    boolean insertPartsStock(TrxPartInModel trxPartInModel);

    boolean isPartsInExist(String id_parts_number);

    TrxPartInModel getPartsNumber(String id_parts_number);

    void updateTrxPart(TrxPartInModel trxPartInModel);

    void deletePartNumber(String id_part_number);
}
