package com.msg.data.controller;


import com.msg.data.model.ErrCode;
import com.msg.data.model.TrxPartInModel;
import com.msg.data.service.TrxPartInService;
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
@RequestMapping("/stock-in")
public class TrxPartInController {

    @Autowired
    private TrxPartInService trxPartInService;

    //menambahkan data stock-in baru
    @RequestMapping(value = "/insert-new", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody TrxPartInModel partInModel, UriComponentsBuilder uriComponentsBuilder) {
        if (trxPartInService.isPartsInExist(partInModel.getId_parts_number()) == true) {
            trxPartInService.insertPartsStock(partInModel);
            return new ResponseEntity(new ErrCode("201", "Data PO berhasil Disimpan"), HttpStatus.CREATED);
        }
            return  new ResponseEntity(new ErrCode("409", "Data PO sudah ada"), HttpStatus.CONFLICT);
    }

    //menampilkan data stock yg masuk
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<TrxPartInModel>> getDataParts(){
        List<TrxPartInModel> list = trxPartInService.getPartsStockIn();
        return new ResponseEntity<List<TrxPartInModel>>(list, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TrxPartInModel> updateUser(@RequestBody TrxPartInModel partsModel) {
        trxPartInService.updateTrxPart(partsModel);
        return new ResponseEntity(new ErrCode("201", "Data Parts berhasil diubah"), HttpStatus.OK);
    }

    @DeleteMapping("/delete={partnumber}")
    public ResponseEntity<Void> deletePartNumber(@PathVariable("partnumber") String partnumber) {
        trxPartInService.deletePartNumber(partnumber);
        return new ResponseEntity(new ErrCode("201", "Data PO berhasil Dihapus"), HttpStatus.OK);
    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/parts-number={partnum}", method = RequestMethod.GET)
    public ResponseEntity<TrxPartInModel> getByPartNum(@PathVariable("partnum") String partsnumber) {
        TrxPartInModel partInModel = trxPartInService.getPartsNumber(partsnumber);
        return new ResponseEntity<TrxPartInModel>(partInModel, HttpStatus.OK);
    }

}
