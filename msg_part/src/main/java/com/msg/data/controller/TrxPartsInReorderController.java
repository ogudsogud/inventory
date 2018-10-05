package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.TrxPartsReorderModel;
import com.msg.data.service.TrxPartsReorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 26/09/2018.
 */

@RestController
@RequestMapping("/reorder")
public class TrxPartsInReorderController {

    @Autowired
    private TrxPartsReorderService trxPartsReorderService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody TrxPartsReorderModel trxPartsReorderModel, UriComponentsBuilder uriComponentsBuilder) {
//        if (trxPartsReorderService.isPartsInExist(partInModel.getId_parts_number()) == true) {
        trxPartsReorderService.insertReorder(trxPartsReorderModel);
        return new ResponseEntity(new ErrCode("201", "Data berhasil Disimpan"), HttpStatus.CREATED);
    }
//        return  new ResponseEntity(new ErrCode("409", "Data Stock sudah ada"), HttpStatus.CONFLICT);
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<TrxPartsReorderModel>> getDataPartsIn(){
        if (trxPartsReorderService.getPartsReorder().isEmpty()) {
            return new ResponseEntity(new ErrCode("201", "Data Kosong"), HttpStatus.OK);
        }
        List<TrxPartsReorderModel> list = trxPartsReorderService.getPartsReorder();
        return new ResponseEntity<List<TrxPartsReorderModel>>(list, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TrxPartsReorderModel> updatePartsReorder(@RequestBody TrxPartsReorderModel trxPartsReorderModel) {
        trxPartsReorderService.updateTrxParteorder(trxPartsReorderModel);
        return new ResponseEntity(new ErrCode("201", "Data berhasil diubah"), HttpStatus.OK);
    }

    @DeleteMapping("/delete={id_trx_reorder}")
    public ResponseEntity<Void> deletePartsReorder(@PathVariable("id_trx_reorder") String trx_parts_reorder) {
        trxPartsReorderService.deletePartsReorder(trx_parts_reorder);
        return new ResponseEntity(new ErrCode("201", "Data berhasil Dihapus"), HttpStatus.OK);
    }

}
