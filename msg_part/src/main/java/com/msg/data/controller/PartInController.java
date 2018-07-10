package com.msg.data.controller;


import com.msg.data.model.ErrCode;
import com.msg.data.model.PartInModel;
import com.msg.data.service.PartInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */

@RestController
@RequestMapping("msg/parts/stock-in")
public class PartInController {

    @Autowired
    private PartInService partInService;

    //menambahkan data stock-in baru
    @RequestMapping(value = "/insert-part-in", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PartInModel partInModel, UriComponentsBuilder uriComponentsBuilder) {
        if (partInService.isPartsInExist(partInModel.getPo_number()) == true) {
            partInService.insertPartsStock(partInModel);
            return new ResponseEntity(new ErrCode("201", "Data PO berhasil Disimpan"), HttpStatus.CREATED);
        }
            return  new ResponseEntity(new ErrCode("409", "Data PO sudah ada"), HttpStatus.CONFLICT);
    }

    //menampilkan data stock yg masuk
    @RequestMapping(value = "/get-parts-in", method = RequestMethod.GET)
    public ResponseEntity<List<PartInModel>> getDataParts(){
        List<PartInModel> list = partInService.getPartsStockIn();
        return new ResponseEntity<List<PartInModel>>(list, HttpStatus.OK);
    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/po-number={po}", method = RequestMethod.GET)
    public ResponseEntity<PartInModel> getByPartNum(@PathVariable("partnum") String po) {
        PartInModel partInModel = partInService.getByPoNumb(po);
        return new ResponseEntity<PartInModel>(partInModel, HttpStatus.OK);
    }

}
