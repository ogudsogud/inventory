package com.msg.data.model;

/**
 * Created by yoga.wiguna on 26/09/2018.
 */
public class TrxPartsReorderModel {
    private int id_trx_parts_stock_in_reorder;
    private  int id_mtr_sub_parts;
    private  int id_unit_institution;
    private  String id_parts_number;
    private  String sub_parts_name;
    private  String specification;
    private  String brand_name;
    private  String institution_name;
    private  String unit_ins_name;
    private  String bad_parts;
    private  String description;
    private  int quantity_unit;
    private  String returned_by;
    private  String returned_on;
    private  String accepted_by;
    private  String accepted_on;
    private  int status;


    public TrxPartsReorderModel(int id_trx_parts_stock_in_reorder, int id_mtr_sub_parts, int id_unit_institution, String id_parts_number, String sub_parts_name, String specification, String brand_name, String institution_name, String unit_ins_name, String bad_parts, String description, int quantity_unit, String returned_by, String returned_on, String accepted_by, String accepted_on, int status) {
        this.id_trx_parts_stock_in_reorder = id_trx_parts_stock_in_reorder;
        this.id_mtr_sub_parts = id_mtr_sub_parts;
        this.id_unit_institution = id_unit_institution;
        this.id_parts_number = id_parts_number;
        this.sub_parts_name = sub_parts_name;
        this.specification = specification;
        this.brand_name = brand_name;
        this.institution_name = institution_name;
        this.unit_ins_name = unit_ins_name;
        this.bad_parts = bad_parts;
        this.description = description;
        this.quantity_unit = quantity_unit;
        this.returned_by = returned_by;
        this.returned_on = returned_on;
        this.accepted_by = accepted_by;
        this.accepted_on = accepted_on;
        this.status = status;
    }

    public TrxPartsReorderModel() {

    }


    public int getId_trx_parts_stock_in_reorder() {
        return id_trx_parts_stock_in_reorder;
    }

    public void setId_trx_parts_stock_in_reorder(int id_trx_parts_stock_in_reorder) {
        this.id_trx_parts_stock_in_reorder = id_trx_parts_stock_in_reorder;
    }

    public int getId_mtr_sub_parts() {
        return id_mtr_sub_parts;
    }

    public void setId_mtr_sub_parts(int id_mtr_sub_parts) {
        this.id_mtr_sub_parts = id_mtr_sub_parts;
    }

    public int getId_unit_institution() {
        return id_unit_institution;
    }

    public void setId_unit_institution(int id_unit_institution) {
        this.id_unit_institution = id_unit_institution;
    }

    public String getId_parts_number() {
        return id_parts_number;
    }

    public void setId_parts_number(String id_parts_number) {
        this.id_parts_number = id_parts_number;
    }

    public String getSub_parts_name() {
        return sub_parts_name;
    }

    public void setSub_parts_name(String sub_parts_name) {
        this.sub_parts_name = sub_parts_name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getUnit_ins_name() {
        return unit_ins_name;
    }

    public void setUnit_ins_name(String unit_ins_name) {
        this.unit_ins_name = unit_ins_name;
    }

    public String getBad_parts() {
        return bad_parts;
    }

    public void setBad_parts(String bad_parts) {
        this.bad_parts = bad_parts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(int quantity_unit) {
        this.quantity_unit = quantity_unit;
    }

    public String getReturned_by() {
        return returned_by;
    }

    public void setReturned_by(String returned_by) {
        this.returned_by = returned_by;
    }

    public String getReturned_on() {
        return returned_on;
    }

    public void setReturned_on(String returned_on) {
        this.returned_on = returned_on;
    }

    public String getAccepted_by() {
        return accepted_by;
    }

    public void setAccepted_by(String accepted_by) {
        this.accepted_by = accepted_by;
    }

    public String getAccepted_on() {
        return accepted_on;
    }

    public void setAccepted_on(String accepted_on) {
        this.accepted_on = accepted_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
