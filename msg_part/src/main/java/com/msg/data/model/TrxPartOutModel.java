package com.msg.data.model;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public class TrxPartOutModel {

    private int id_trx_parts_stock_out;
    private int id_stock_unit_parts;
    private String ticket_no;
    private int id_mtr_sub_parts;
    private int id_institution;
    private int id_unit_institution;
    private int id_unit_parts;
    private int id_brand;
    private String unit_parts_name;
    private String id_parts_number;
    private String sub_parts_name;
    private String brand_name;
    private String institution_name;
    private String ins_unit_name;
    private String description;
    private int quantity_unit;
    private String requested_by;
    private String requested_on;
    private String approved_by;
    private String approved_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public TrxPartOutModel(int id_trx_parts_stock_out, int id_stock_unit_parts, String ticket_no,
                           int id_mtr_sub_parts, int id_institution, int id_unit_institution, int id_unit_parts, int id_brand,
                           String unit_parts_name, String id_parts_number, String sub_parts_name,
                           String brand_name, String institution_name, String ins_unit_name,
                           String description, int quantity_unit, String requested_by,
                           String requested_on, String approved_by, String approved_on,
                           String updated_by, String updated_on, int status) {
        this.id_trx_parts_stock_out = id_trx_parts_stock_out;
        this.id_stock_unit_parts = id_stock_unit_parts;
        this.ticket_no = ticket_no;
        this.id_mtr_sub_parts = id_mtr_sub_parts;
        this.id_institution = id_institution;
        this.id_unit_institution = id_unit_institution;
        this.id_unit_parts = id_unit_parts;
        this.id_brand = id_brand;
        this.unit_parts_name = unit_parts_name;
        this.id_parts_number = id_parts_number;
        this.sub_parts_name = sub_parts_name;
        this.brand_name = brand_name;
        this.institution_name = institution_name;
        this.ins_unit_name = ins_unit_name;
        this.description = description;
        this.quantity_unit = quantity_unit;
        this.requested_by = requested_by;
        this.requested_on = requested_on;
        this.approved_by = approved_by;
        this.approved_on = approved_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public TrxPartOutModel() {

    }


    public int getId_trx_parts_stock_out() {
        return id_trx_parts_stock_out;
    }

    public void setId_trx_parts_stock_out(int id_trx_parts_stock_out) {
        this.id_trx_parts_stock_out = id_trx_parts_stock_out;
    }

    public int getId_stock_unit_parts() {
        return id_stock_unit_parts;
    }

    public void setId_stock_unit_parts(int id_stock_unit_parts) {
        this.id_stock_unit_parts = id_stock_unit_parts;
    }

    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }


    public int getId_mtr_sub_parts() {
        return id_mtr_sub_parts;
    }

    public void setId_mtr_sub_parts(int id_mtr_sub_parts) {
        this.id_mtr_sub_parts = id_mtr_sub_parts;
    }

    public int getId_institution() {
        return id_institution;
    }

    public void setId_institution(int id_institution) {
        this.id_institution = id_institution;
    }

    public int getId_unit_institution() {
        return id_unit_institution;
    }

    public void setId_unit_institution(int id_unit_institution) {
        this.id_unit_institution = id_unit_institution;
    }

    public int getId_unit_parts() {
        return id_unit_parts;
    }

    public void setId_unit_parts(int id_unit_parts) {
        this.id_unit_parts = id_unit_parts;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getUnit_parts_name() {
        return unit_parts_name;
    }

    public void setUnit_parts_name(String unit_parts_name) {
        this.unit_parts_name = unit_parts_name;
    }

    public String getId_parts_number() {
        return id_parts_number;
    }

    public void setId_parts_number(String id_parts_number) {
        this.id_parts_number = id_parts_number;
    }


    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }


    public String getSub_parts_name() {
        return sub_parts_name;
    }

    public void setSub_parts_name(String sub_parts_name) {
        this.sub_parts_name = sub_parts_name;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getIns_unit_name() {
        return ins_unit_name;
    }

    public void setIns_unit_name(String ins_unit_name) {
        this.ins_unit_name = ins_unit_name;
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

    public String getRequested_by() {
        return requested_by;
    }

    public void setRequested_by(String requested_by) {
        this.requested_by = requested_by;
    }

    public String getRequested_on() {
        return requested_on;
    }

    public void setRequested_on(String requested_on) {
        this.requested_on = requested_on;
    }

    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    public String getApproved_on() {
        return approved_on;
    }

    public void setApproved_on(String approved_on) {
        this.approved_on = approved_on;
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
