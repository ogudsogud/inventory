package com.msg.data.controller;

import com.msg.data.service.PriviligeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */

@Controller
@RequestMapping("msg_parts")
public class PrivilageController {

    @Autowired
    private PriviligeService priviligeService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "Login";
    }

}
