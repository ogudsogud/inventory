package com.msg.data.model;

/**
 * Created by yoga.wiguna on 16/07/2018.
 */
public class UnitInstitutionModel {

    private int id_unit_institution;
    private String id_institution;
    private String unit_name;
    private String address;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public UnitInstitutionModel(int id_unit_institution, String id_institution, String unit_name,
                                String address, String created_by, String created_on,
                                String updated_by, String updated_on, int status) {
        this.id_unit_institution = id_unit_institution;
        this.id_institution = id_institution;
        this.unit_name = unit_name;
        this.address = address;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }
}
