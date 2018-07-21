package com.msg.data.controller;

import com.msg.data.service.UnitPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ogudsogud on 7/21/2018.
 */

@RestController
@RequestMapping("/msg")
public class UnitPartsController {

    @Autowired
    private UnitPartsService unitPartsService;


}
