package com.msg.data.model;

import java.util.Date;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public class PartsModel {

    private int id_part;
    private String part_name;
    private String part_number;
    private String brand_name;
    private int quantity;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public PartsModel(int id_part, String part_name, String part_number, String brand_name, int quantity, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_part = id_part;
        this.part_name = part_name;
        this.part_number = part_number;
        this.brand_name = brand_name;
        this.quantity = quantity;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public PartsModel() {

    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getPart_number() {
        return part_number;
    }

    public void setPart_number(String part_number) {
        this.part_number = part_number;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
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
