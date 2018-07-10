package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.PartOutModel;
import com.msg.data.service.PartOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */

@RestController
@RequestMapping("msg/parts/stock-out")
public class PartOutController {

    @Autowired
    private PartOutService partOutService;

    //menambahkan data stock-out baru
    @RequestMapping(value = "/insert-part-out", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PartOutModel partOutModel, UriComponentsBuilder uriComponentsBuilder) {
        if (partOutService.isPartsOutExist(partOutModel.getPo_number()) == true) {
            partOutService.insertPartsOut(partOutModel);
            return new ResponseEntity(new ErrCode("201", "Data Stock Out berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Stock Out sudah ada"), HttpStatus.CONFLICT);
    }

    //menampilkan data stock yg keluar
    @RequestMapping(value = "/get-out-parts", method = RequestMethod.GET)
    public ResponseEntity<List<PartOutModel>> getDataParts(){
        List<PartOutModel> list = partOutService.getPartsStockOut();
        return new ResponseEntity<List<PartOutModel>>(list, HttpStatus.OK);
    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/po-number={po}", method = RequestMethod.GET)
    public ResponseEntity<PartOutModel> getByPartNum(@PathVariable("partnum") String po) {
        PartOutModel partInModel = partOutService.getByPoNumb(po);
        return new ResponseEntity<PartOutModel>(partInModel, HttpStatus.OK);
    }

}
