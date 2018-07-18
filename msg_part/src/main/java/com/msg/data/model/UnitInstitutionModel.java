package com.msg.data.model;

/**
 * Created by yoga.wiguna on 16/07/2018.
 */
public class UnitInstitutionModel {

    private int id_unit_institution;
    private String id_institution;
    private String ins_unit_name;
    private String institution_name;
    private String address;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;


    public UnitInstitutionModel(int id_unit_institution, String id_institution, String ins_unit_name, String institution_name, String address, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_unit_institution = id_unit_institution;
        this.id_institution = id_institution;
        this.ins_unit_name = ins_unit_name;
        this.institution_name = institution_name;
        this.address = address;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }


    public int getId_unit_institution() {
        return id_unit_institution;
    }

    public void setId_unit_institution(int id_unit_institution) {
        this.id_unit_institution = id_unit_institution;
    }

    public String getId_institution() {
        return id_institution;
    }

    public void setId_institution(String id_institution) {
        this.id_institution = id_institution;
    }

    public String getIns_unit_name() {
        return ins_unit_name;
    }

    public void setIns_unit_name(String ins_unit_name) {
        this.ins_unit_name = ins_unit_name;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
