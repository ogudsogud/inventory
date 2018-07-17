package com.msg.data.model;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */
public class PartOutModel {

    private String ticket_no;
    private int id_unit_parts;
    private int id_unit_institution;
    private String id_part_number;
    private String part_name;
    private String institution_name;
    private String ins_unit_name;
    private String unit_parts_name;
    private String description;
    private int quantity_unit;
    private String requested_by;
    private String requested_on;
    private String approved_by;
    private String approved_on;
    private int status;


    public PartOutModel(String ticket_no, int id_unit_parts, int id_unit_institution, String id_part_number,
                        String part_name, String institution_name, String ins_unit_name, String unit_parts_name,
                        String description, int quantity_unit, String requested_by, String requested_on,
                        String approved_by, String approved_on, int status) {
        this.ticket_no = ticket_no;
        this.id_unit_parts = id_unit_parts;
        this.id_unit_institution = id_unit_institution;
        this.id_part_number = id_part_number;
        this.part_name = part_name;
        this.institution_name = institution_name;
        this.ins_unit_name = ins_unit_name;
        this.unit_parts_name = unit_parts_name;
        this.description = description;
        this.quantity_unit = quantity_unit;
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

    public int getId_unit_parts() {
        return id_unit_parts;
    }

    public void setId_unit_parts(int id_unit_parts) {
        this.id_unit_parts = id_unit_parts;
    }

    public int getId_unit_institution() {
        return id_unit_institution;
    }

    public void setId_unit_institution(int id_unit_institution) {
        this.id_unit_institution = id_unit_institution;
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

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getIns_unit_name() {
        return ins_unit_name;
    }

    public void setIns_unit_name(String ins_unit_name) {
        this.ins_unit_name = ins_unit_name;
    }

    public String getUnit_parts_name() {
        return unit_parts_name;
    }

    public void setUnit_parts_name(String unit_parts_name) {
        this.unit_parts_name = unit_parts_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(int quantity_unit) {
        this.quantity_unit = quantity_unit;
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
