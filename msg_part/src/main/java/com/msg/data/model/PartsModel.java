package com.msg.data.model;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public class PartsModel {
    private int id_mtr_parts;
    private String id_parts_number;
    private String unit_parts_name;
    private String parts_name;
    private String brand_name;
    private String specification;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;


    public PartsModel(int id_mtr_parts,  String id_parts_number, String unit_parts_name, String parts_name, String brand_name, String specification, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_mtr_parts = id_mtr_parts;
        this.id_parts_number = id_parts_number;
        this.unit_parts_name = unit_parts_name;
        this.parts_name = parts_name;
        this.brand_name = brand_name;
        this.specification = specification;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public PartsModel() {
    }


    public int getId_mtr_parts() {
        return id_mtr_parts;
    }

    public void setId_mtr_parts(int id_mtr_parts) {
        this.id_mtr_parts = id_mtr_parts;
    }

    public String getId_parts_number() {
        return id_parts_number;
    }

    public void setId_parts_number(String id_parts_number) {
        this.id_parts_number = id_parts_number;
    }

    public String getUnit_parts_name() {
        return unit_parts_name;
    }

    public void setUnit_parts_name(String unit_parts_name) {
        this.unit_parts_name = unit_parts_name;
    }

    public String getParts_name() {
        return parts_name;
    }

    public void setParts_name(String parts_name) {
        this.parts_name = parts_name;
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
