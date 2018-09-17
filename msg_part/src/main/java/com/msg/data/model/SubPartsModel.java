package com.msg.data.model;

/**
 * Created by Ogudsogud on 9/17/2018.
 */
public class SubPartsModel {

    private int id_mtr_sub_parts;
    private String id_parts_number;
    private int id_unit_parts;
    private int id_brand;
    private String unit_parts_name;
    private String sub_parts_name;
    private String brand_name;
    private String specification;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;


    public SubPartsModel(int id_mtr_sub_parts, String id_parts_number, int id_unit_parts, int id_brand, String unit_parts_name, String sub_parts_name, String brand_name, String specification, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_mtr_sub_parts = id_mtr_sub_parts;
        this.id_parts_number = id_parts_number;
        this.id_unit_parts = id_unit_parts;
        this.id_brand = id_brand;
        this.unit_parts_name = unit_parts_name;
        this.sub_parts_name = sub_parts_name;
        this.brand_name = brand_name;
        this.specification = specification;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public SubPartsModel() {
    }


    public int getId_mtr_sub_parts() {
        return id_mtr_sub_parts;
    }

    public void setId_mtr_sub_parts(int id_mtr_sub_parts) {
        this.id_mtr_sub_parts = id_mtr_sub_parts;
    }

    public String getId_parts_number() {
        return id_parts_number;
    }

    public void setId_parts_number(String id_parts_number) {
        this.id_parts_number = id_parts_number;
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


    public String getSub_parts_name() {
        return sub_parts_name;
    }

    public void setSub_parts_name(String sub_parts_name) {
        this.sub_parts_name = sub_parts_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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
