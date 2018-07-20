package com.msg.data.model;

/**
 * Created by yoga.wiguna on 13/07/2018.
 */
public class UnitPartsModel {

    private int id_unit_parts;
    private String unit_parts_name;
    private String bad_parts;
    private int quantity_unit;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public UnitPartsModel(int id_unit_parts, String unit_parts_name, String bad_parts,
                          int quantity_unit, String created_by, String created_on,
                          String updated_by, String updated_on, int status) {
        this.id_unit_parts = id_unit_parts;
        this.unit_parts_name = unit_parts_name;
        this.bad_parts = bad_parts;
        this.quantity_unit = quantity_unit;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public UnitPartsModel() {

    }

    public int getId_unit_parts() {
        return id_unit_parts;
    }

    public void setId_unit_parts(int id_unit_parts) {
        this.id_unit_parts = id_unit_parts;
    }

    public String getUnit_parts_name() {
        return unit_parts_name;
    }

    public void setUnit_parts_name(String unit_parts_name) {
        this.unit_parts_name = unit_parts_name;
    }

    public String getBad_parts() {
        return bad_parts;
    }

    public void setBad_parts(String bad_parts) {
        this.bad_parts = bad_parts;
    }

    public int getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(int quantity_unit) {
        this.quantity_unit = quantity_unit;
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
