package com.msg.data.model;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
public class StockPartsModel {
    private int id_stock_parts;
    private String id_unit_parts;
    private String part_number;
    private String unit_parts_name;
    private String part_name;
    private String bad_part;
    private String spesification;
    private int quantity;
    private int status;


    public StockPartsModel(int id_stock_parts, String id_unit_parts,
                           String part_number, String unit_parts_name,
                           String part_name, String bad_part, String spesification, int quantity,
                           int status) {
        this.id_stock_parts = id_stock_parts;
        this.id_unit_parts = id_unit_parts;
        this.part_number = part_number;
        this.unit_parts_name = unit_parts_name;
        this.part_name = part_name;
        this.bad_part = bad_part;
        this.spesification = spesification;
        this.quantity = quantity;
        this.status = status;
    }

    public StockPartsModel() {
    }

    public int getId_stock_parts() {
        return id_stock_parts;
    }

    public void setId_stock_parts(int id_stock_parts) {
        this.id_stock_parts = id_stock_parts;
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

    public String getUnit_parts_name() {
        return unit_parts_name;
    }

    public void setUnit_parts_name(String unit_parts_name) {
        this.unit_parts_name = unit_parts_name;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getBad_part() {
        return bad_part;
    }

    public void setBad_part(String bad_part) {
        this.bad_part = bad_part;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
