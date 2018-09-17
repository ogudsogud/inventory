package com.msg.data.model;

/**
 * Created by yoga.wiguna on 24/07/2018.
 */
public class LogUserLoginModel {

    private int id_login;
    private String id_privilage;
    private String nik;
    private String name;
    private String login_at;
    private String logout_at;
    private int status;

    public LogUserLoginModel(int id_login, String id_privilage, String nik, String name, String login_at, String logout_at, int status) {
        this.id_login = id_login;
        this.id_privilage = id_privilage;
        this.nik = nik;
        this.name = name;
        this.login_at = login_at;
        this.logout_at = logout_at;
        this.status = status;
    }

    public LogUserLoginModel() {

    }


    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getId_privilage() {
        return id_privilage;
    }

    public void setId_privilage(String id_privilage) {
        this.id_privilage = id_privilage;
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

    public String getLogin_at() {
        return login_at;
    }

    public void setLogin_at(String login_at) {
        this.login_at = login_at;
    }

    public String getLogout_at() {
        return logout_at;
    }

    public void setLogout_at(String logout_at) {
        this.logout_at = logout_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
