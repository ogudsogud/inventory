package com.msg.data.service;

import com.msg.data.model.LogUserLoginModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 17/09/2018.
 */
public interface LogUserLoginService {

    List<LogUserLoginModel> getDataLogin();

    boolean insertLog(String nik);

    boolean updateLog(String nik);

    boolean isNikExist(String nik);

    boolean isNikExistLogin(String nik);
}
