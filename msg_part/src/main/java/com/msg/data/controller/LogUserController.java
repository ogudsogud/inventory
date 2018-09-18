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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 27/08/2018.
 */

@RestController
@RequestMapping("/")
public class LogUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogUserLoginService logUserLoginService;



    @RequestMapping("/list")
    public ResponseEntity<List<LogUserLoginModel>> getAllPrts(){
        List<LogUserLoginModel> list = logUserLoginService.getDataLogin();
        return new ResponseEntity<List<LogUserLoginModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Void> nikPasswd(@RequestBody UserModel userModel, LogUserLoginModel userLoginModel, UriComponentsBuilder uriComponentsBuilder) {
        if (userService.isNikExist(userModel.getNik(), userModel.getPasswd()) == true) {
            logUserLoginService.insertLog(userModel.getNik());
            return new ResponseEntity(new ErrCode("201", "Berhasil Login" ), HttpStatus.OK);
        } else if (logUserLoginService.isNikExist(userModel.getNik()) == false) {
            return new ResponseEntity(new ErrCode("201", "Silahkan logut"), HttpStatus.OK);
        }
        return new ResponseEntity(new ErrCode("404", "Silahkan Registrasi "), HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<Void> logout(@RequestBody UserModel userModel, UriComponentsBuilder uriComponentsBuilder) {
        if (logUserLoginService.isNikExist(userModel.getNik()) == true) {
            logUserLoginService.updateLog(userModel.getNik());

        }
        return new ResponseEntity(new ErrCode("201", "Berhasil Logut" ), HttpStatus.OK);
    }


    @RequestMapping(value = "/registrasi", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody UserModel userModel, UriComponentsBuilder uriComponentsBuilder) {
        if (userService.isNikExist(userModel.getNik(), userModel.getPasswd()) == true) {
            userService.insertUser(userModel);
            return new ResponseEntity(new ErrCode("201", "User berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data user sudah ada"), HttpStatus.CONFLICT);
    }
}
