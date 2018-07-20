package com.msg.data.service;

import com.msg.data.model.UnitPartsModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 13/07/2018.
 */
public interface UnitPartsService {

    boolean insertUnitParts(UnitPartsModel partsModel);

    void updateUnitPart(UnitPartsModel unitPartsModel);

    List<UnitPartsModel> getDataUnit();

    UnitPartsModel getByIdUnitPart(String id_unit_parts);

    UnitPartsModel getByBadPart(String bad_parts);

    UnitPartsModel getCreatedOn(String created_by);

    void deleteByIdUnit(String id_unit_parts);
}
