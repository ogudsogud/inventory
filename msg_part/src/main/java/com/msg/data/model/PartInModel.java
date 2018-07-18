package com.msg.data.model;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public class PartInModel {

    private String ticket_no;
    private String id_unit_parts;
    private String id_unit_institution;
    private String id_part_number;
    private String part_name;
    private String institution_name;
    private String ins_unit_name;
    private String unit_parts_name;
    private String description;
    private int quantity_unit;
    private String bad_part;
    private String returned_by;
    private String returned_on;
    private String approved_by;
    private String approved_on;
    private int status;


    public PartInModel(String ticket_no, String id_unit_parts, String id_unit_institution, String id_part_number, String part_name, String institution_name, String ins_unit_name, String unit_parts_name, String description, int quantity_unit, String bad_part, String returned_by, String returned_on, String approved_by, String approved_on, int status) {
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
        this.bad_part = bad_part;
        this.returned_by = returned_by;
        this.returned_on = returned_on;
        this.approved_by = approved_by;
        this.approved_on = approved_on;
        this.status = status;
    }

    public PartInModel() {

    }


    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }

    public String getId_unit_parts() {
        return id_unit_parts;
    }

    public void setId_unit_parts(String id_unit_parts) {
        this.id_unit_parts = id_unit_parts;
    }

    public String getId_unit_institution() {
        return id_unit_institution;
    }

    public void setId_unit_institution(String id_unit_institution) {
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

    public String getBad_part() {
        return bad_part;
    }

    public void setBad_part(String bad_part) {
        this.bad_part = bad_part;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
