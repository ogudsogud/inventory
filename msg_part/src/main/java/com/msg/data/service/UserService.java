package com.msg.data.service;

import com.msg.data.model.UserModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */
public interface UserService {

    List<UserModel> getUser();

    boolean insertUser(UserModel userModel);

    boolean isNikExist(String nik, String passwd);

    List<UserModel> getNik(String nik);

    List<UserModel> getPasswd(String passwd);
}
