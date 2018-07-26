package com.msg.data.controller;

import com.msg.data.service.PriviligeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */

@Controller
@RequestMapping("msg")
public class PrivilageController {

    @Autowired
    private PriviligeService priviligeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

}
