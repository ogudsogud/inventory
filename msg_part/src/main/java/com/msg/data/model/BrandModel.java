package com.msg.data.model;

/**
 * Created by yoga.wiguna on 16/07/2018.
 */
public class BrandModel {

    private int id_brand;
    private String brand_name;
    private String base_country;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public BrandModel(int id_brand, String brand_name, String base_country,
                      String created_by, String created_on,
                      String updated_by, String updated_on, int status) {
        this.id_brand = id_brand;
        this.brand_name = brand_name;
        this.base_country = base_country;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBase_country() {
        return base_country;
    }

    public void setBase_country(String base_country) {
        this.base_country = base_country;
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
