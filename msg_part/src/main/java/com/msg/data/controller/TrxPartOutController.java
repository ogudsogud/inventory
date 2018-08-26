package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.TrxPartOutModel;
import com.msg.data.service.TrxPartOutService;
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
@RequestMapping("/stock-out")
public class TrxPartOutController {

    @Autowired
    private TrxPartOutService partOutService;

    //menambahkan data stock-out baru
    @RequestMapping(value = "/insert-new", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody TrxPartOutModel partOutModel, UriComponentsBuilder uriComponentsBuilder) {
        if (partOutService.isPartsOutExist(partOutModel.getTicket_no()) == true) {
            partOutService.insertPartsOut(partOutModel);
            return new ResponseEntity(new ErrCode("201", "Data Stock Out berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Stock Out sudah ada"), HttpStatus.CONFLICT);
    }

    //menampilkan data stock yg keluar
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<TrxPartOutModel>> getDataParts(){
        List<TrxPartOutModel> list = partOutService.getPartsStockOut();
        return new ResponseEntity<List<TrxPartOutModel>>(list, HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<TrxPartOutModel> updateUser(@RequestBody TrxPartOutModel trxPartOutModel) {
        partOutService.updateTrxPart(trxPartOutModel);
        return new ResponseEntity(new ErrCode("201", "Data Stock Out berhasil diubah"), HttpStatus.OK);
    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/ticket-number={tikno}", method = RequestMethod.GET)
    public ResponseEntity<TrxPartOutModel> getByPartNum(@PathVariable("tikno") String ticket_no) {
        TrxPartOutModel partOutModelModel = partOutService.getByTiknoNumb(ticket_no);
        return new ResponseEntity<TrxPartOutModel>(partOutModelModel, HttpStatus.OK);
    }

}
