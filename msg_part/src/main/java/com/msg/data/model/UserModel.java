package com.msg.data.model;

/**
 * Created by yoga.wiguna on 16/07/2018.
 */
public class UserModel {

    private int id_mtr_user;
    private String nik;
    private String name;
    private String position;
    private String email;
    private String passwd;
    private String role_access;
    private int id_role;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public UserModel(int id_mtr_user, String nik, String name, String position,
                     String email, String passwd, int id_role,
                     String created_by, String created_on,
                     String updated_by, String updated_on, int status) {
        this.id_mtr_user = id_mtr_user;
        this.nik = nik;
        this.name = name;
        this.position = position;
        this.email = email;
        this.passwd = passwd;
        this.role_access = role_access;
        this.id_role = id_role;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public UserModel() {

    }

    public int getId_mtr_user() {
        return id_mtr_user;
    }

    public void setId_mtr_user(int id_mtr_user) {
        this.id_mtr_user = id_mtr_user;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole_access() {
        return role_access;
    }

    public void setRole_access(String role_access) {
        this.role_access = role_access;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
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
