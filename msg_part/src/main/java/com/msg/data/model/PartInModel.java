package com.msg.data.model;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public class PartInModel {

    private String po_number;
    private String part_name;
    private String part_number;
    private String brand_name;
    private String description;
    private int quantity;
    private String returned_by;
    private String returned_on;
    private String approved_by;
    private String approved_on;

    public PartInModel(String po_number, String part_name, String part_number, String brand_name, String description, int quantity, String returned_by, String returned_on, String approved_by, String approved_on) {
        this.po_number = po_number;
        this.part_name = part_name;
        this.part_number = part_number;
        this.brand_name = brand_name;
        this.description = description;
        this.quantity = quantity;
        this.returned_by = returned_by;
        this.returned_on = returned_on;
        this.approved_by = approved_by;
        this.approved_on = approved_on;
    }

    public PartInModel() {

    }

    public String getPo_number() {
        return po_number;
    }

    public void setPo_number(String po_number) {
        this.po_number = po_number;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
