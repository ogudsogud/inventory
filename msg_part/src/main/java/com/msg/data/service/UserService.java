package com.msg.data.service;

import com.msg.data.model.UserModel;

/**
 * Created by yoga.wiguna on 20/07/2018.
 */
public interface UserService {

    UserModel getByNikPassword(String nik, String password);
}
