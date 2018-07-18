package com.msg.data.model;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public class StockPartsModel {
    private String id_unit_parts;
    private String id_brand;
    private String unit_parts_name;
    private String id_part_number;
    private String part_name;
    private String brand_name;
    private String spesification;
    private String bad_part;
    private int quantity_unit;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private String status;


    public StockPartsModel(String id_unit_parts, String id_brand, String unit_parts_name, String id_part_number, String part_name, String brand_name, String spesification, String bad_part, int quantity_unit, String created_by, String created_on, String updated_by, String updated_on, String status) {
        this.id_unit_parts = id_unit_parts;
        this.id_brand = id_brand;
        this.unit_parts_name = unit_parts_name;
        this.id_part_number = id_part_number;
        this.part_name = part_name;
        this.brand_name = brand_name;
        this.spesification = spesification;
        this.bad_part = bad_part;
        this.quantity_unit = quantity_unit;
        this.updated_by = created_by;
        this.created_on = created_on;
        updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public StockPartsModel() {
    }


    public String getId_unit_parts() {
        return id_unit_parts;
    }

    public void setId_unit_parts(String id_unit_parts) {
        this.id_unit_parts = id_unit_parts;
    }

    public String getId_brand() {
        return id_brand;
    }

    public void setId_brand(String id_brand) {
        this.id_brand = id_brand;
    }

    public String getUnit_parts_name() {
        return unit_parts_name;
    }

    public void setUnit_parts_name(String unit_parts_name) {
        this.unit_parts_name = unit_parts_name;
    }

    public String getId_part_number() {
        return id_part_number;
    }

    public void setId_part_number(String id_part_number) {
        this.id_part_number = id_part_number;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSpesification() {
        return spesification;
    }

    public void setSpesification(String spesification) {
        this.spesification = spesification;
    }

    public String getBad_part() {
        return bad_part;
    }

    public void setBad_part(String bad_part) {
        this.bad_part = bad_part;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
