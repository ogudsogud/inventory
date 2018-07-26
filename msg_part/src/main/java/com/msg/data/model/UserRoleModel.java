package com.msg.data.model;

/**
 * Created by yoga.wiguna on 16/07/2018.
 */
public class UserRoleModel {

    private int id_role;
    private String role_access;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public UserRoleModel(int id_role, String role_access,
                          String created_by, String created_on,
                          String updated_by, String updated_on, int status) {
        this.id_role = id_role;
        this.role_access = role_access;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public UserRoleModel() {

    }


    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
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
