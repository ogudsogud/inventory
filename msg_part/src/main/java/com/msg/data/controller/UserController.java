package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.LogUserLoginModel;
import com.msg.data.model.UserModel;
import com.msg.data.service.LogUserLoginService;
import com.msg.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 04/10/2018.
 */
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogUserLoginService logUserLoginService;



    @RequestMapping("/list")
    public ResponseEntity<List<UserModel>> getAllUser(){
        List<UserModel> list = userService.getUser();
        return new ResponseEntity<List<UserModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Void> nikPasswd(@RequestBody UserModel userModel, LogUserLoginModel userLoginModel, UriComponentsBuilder uriComponentsBuilder) {
        if (userService.isNikExist(userModel.getNik(), userModel.getPasswd()) == true) {
            logUserLoginService.insertLog(userModel.getNik());
            return new ResponseEntity(new ErrCode("201", "Berhasil Login" ), HttpStatus.OK);
        } if (logUserLoginService.isNikExist(userModel.getNik()) == false) {
            return new ResponseEntity(new ErrCode("201", "Silahkan logut"), HttpStatus.OK);
        }
        return new ResponseEntity(new ErrCode("404", "Silahkan Registrasi "), HttpStatus.NOT_FOUND);
    }
}
