package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.PartsModel;
import com.msg.data.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
@RestController
@RequestMapping("msg/part")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PartsModel partsModel, UriComponentsBuilder uriComponentsBuilder) {
        if (partsService.isPartsExist(partsModel.getPart_number()) == true) {
            partsService.insertParts(partsModel);
            return new ResponseEntity(new ErrCode("201", "Data Part berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Part sudah ada"), HttpStatus.CONFLICT);

    }
}
