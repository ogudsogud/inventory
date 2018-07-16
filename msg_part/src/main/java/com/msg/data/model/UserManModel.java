package com.msg.data.model;

/**
 * Created by yoga.wiguna on 16/07/2018.
 */
public class UserManModel {

    private int id_privilage;
    private String id_user_group;
    private String id_user;
    private String access;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;

    public UserManModel(int id_privilage, String id_user_group,
                        String id_user, String access,
                        String created_by, String created_on,
                        String updated_by, String updated_on, int status) {
        this.id_privilage = id_privilage;
        this.id_user_group = id_user_group;
        this.id_user = id_user;
        this.access = access;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public int getId_privilage() {
        return id_privilage;
    }

    public void setId_privilage(int id_privilage) {
        this.id_privilage = id_privilage;
    }

    public String getId_user_group() {
        return id_user_group;
    }

    public void setId_user_group(String id_user_group) {
        this.id_user_group = id_user_group;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
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
