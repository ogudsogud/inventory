package com.msg.data.model;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public class UnitPartsModel {

    private String id_unit_parts;
    private String part_number;
    private String unit_name;
    private String part_name;
    private String spesification;
    private int quantity;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public UnitPartsModel(String id_unit_parts,
                          String part_number,
                          String unit_name,
                          String part_name,
                          String spesification,
                          int quantity,
                          String created_by,
                          String created_on,
                          String updated_by,
                          String updated_on,
                          int status) {
        this.id_unit_parts = id_unit_parts;
        this.part_number = part_number;
        this.unit_name = unit_name;
        this.part_name = part_name;
        this.spesification = spesification;
        this.quantity = quantity;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public UnitPartsModel() {
    }


    public String getId_unit_parts() {
        return id_unit_parts;
    }

    public void setId_unit_parts(String id_unit_parts) {
        this.id_unit_parts = id_unit_parts;
    }

    public String getPart_number() {
        return part_number;
    }

    public void setPart_number(String part_number) {
        this.part_number = part_number;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getSpesification() {
        return spesification;
    }

    public void setSpesification(String spesification) {
        this.spesification = spesification;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
