package com.msg.data.model;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */
public class PrivilageModel {
    private int id_privilage;
    private int id_mtr_user;
    private int id_role;
    private String nik;
    private String passwd;
    private String role_access;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public PrivilageModel(int id_privilage, int id_mtr_user, int id_role, String nik, String passwd, String role_access, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_privilage = id_privilage;
        this.id_mtr_user = id_mtr_user;
        this.id_role = id_role;
        this.nik = nik;
        this.passwd = passwd;
        this.role_access = role_access;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public PrivilageModel() {

    }


    public int getId_privilage() {
        return id_privilage;
    }

    public void setId_privilage(int id_privilage) {
        this.id_privilage = id_privilage;
    }

    public int getId_mtr_user() {
        return id_mtr_user;
    }

    public void setId_mtr_user(int id_mtr_user) {
        this.id_mtr_user = id_mtr_user;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setName(String passwd) {
        this.passwd = passwd;
    }

    public String getRole_access() {
        return role_access;
    }

    public void setRole_access(String role_access) {
        this.role_access = role_access;
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
