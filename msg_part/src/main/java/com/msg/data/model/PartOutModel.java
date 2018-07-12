package com.msg.data.model;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public class PartOutModel {

    private String ticket_no;
    private String part_name;
    private String part_number;
    private String tujuan;
    private String description;
    private int quantity;
    private String requested_by;
    private String requested_on;
    private String approved_by;
    private String approved_on;
    private int status;

    public PartOutModel(String ticket_no, String part_name, String part_number, String tujuan, String description, int quantity, String requested_by, String requested_on, String approved_by, String approved_on, int status) {
        this.ticket_no = ticket_no;
        this.part_name = part_name;
        this.part_number = part_number;
        this.tujuan = tujuan;
        this.description = description;
        this.quantity = quantity;
        this.requested_by = requested_by;
        this.requested_on = requested_on;
        this.approved_by = approved_by;
        this.approved_on = approved_on;
        this.status = status;
    }

    public PartOutModel() {

    }

    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
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

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
