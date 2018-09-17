package com.msg.data.service;

/**
 * Created by yoga.wiguna on 17/09/2018.
 */
public interface LogUserLoginService {

//    boolean insertLog(LogUserLoginModel userLoginModel);

    boolean insertLog(String nik);

    boolean updateLog(String nik);

    boolean isNikExist(String nik);
}
