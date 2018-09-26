package com.msg.data.service;

import com.msg.data.model.TrxPartsReorderModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 26/09/2018.
 */
public interface TrxPartsReorderService {
    List<TrxPartsReorderModel> getPartsReorder();

    boolean insertReorder(TrxPartsReorderModel trxPartsReorderModel);

    void updateTrxParteorder(TrxPartsReorderModel trxPartsReorderModel);
}
