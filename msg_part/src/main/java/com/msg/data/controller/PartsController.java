package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.PartsModel;
import com.msg.data.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @RequestMapping("/list")
    public ResponseEntity<List<PartsModel>> getAllPrts(){
        List<PartsModel> list = partsService.getDataParts();
        return new ResponseEntity<List<PartsModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert-new", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PartsModel partsModel, UriComponentsBuilder uriComponentsBuilder) {
//        if (partsService.isPartsExist(partsModel.getId_parts_number()) == true) {
            partsService.insertPartsNew(partsModel);
            return new ResponseEntity(new ErrCode("201", "Data PO berhasil Disimpan"), HttpStatus.CREATED);
//        }
//        return  new ResponseEntity(new ErrCode("409", "Data PO sudah ada"), HttpStatus.CONFLICT);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<PartsModel> updateUser(@RequestBody PartsModel partsModel) {
        partsService.updatePart(partsModel);
        return new ResponseEntity(new ErrCode("201", "Data Parts berhasil diubah"), HttpStatus.OK);
    }



    @DeleteMapping("/delete={partnumber}")
    public ResponseEntity<Void> deletePartNumber(@PathVariable("partnumber") String partnumber) {
        partsService.deletePartNumber(partnumber);
        return new ResponseEntity(new ErrCode("201", "Data Parts berhasil Dihapus"), HttpStatus.OK);
    }



    @RequestMapping(value = "/cari={partnumber}", method = RequestMethod.GET)
    public ResponseEntity getByPartNum(@PathVariable("partnumber") String partnumber) {
        if (partsService.getByIdPartNumb(partnumber) == null) {
            return new ResponseEntity(new ErrCode("409", "Data Parts Kosong"), HttpStatus.NOT_FOUND);
        }
        List<PartsModel> list = partsService.getByIdPartNumb(partnumber);
        return new ResponseEntity<List<PartsModel>>(list, HttpStatus.OK);
    }




    @RequestMapping(value = "/cari-partname={partsname}", method = RequestMethod.GET)
    public ResponseEntity getByParam(@PathVariable("partsname") String partsname) {
        if (partsService.getPartsName(partsname) == null){
            return new ResponseEntity(new ErrCode("409", "Data Parts Kosong"), HttpStatus.NOT_FOUND);
        }
        List<PartsModel> list = partsService.getPartsName(partsname);
        return new ResponseEntity<List<PartsModel>>(list, HttpStatus.OK);
    }


    @RequestMapping(value = "/cari-spec={spek}", method = RequestMethod.GET)
    public ResponseEntity getByspek(@PathVariable("spek") String spek) {
        if (partsService.getBySpek(spek) == null){
            return new ResponseEntity(new ErrCode("409", "Data Parts Kosong"), HttpStatus.NOT_FOUND);
        }
        List<PartsModel> list = partsService.getBySpek(spek);
        return new ResponseEntity<List<PartsModel>>(list, HttpStatus.OK);
    }

}
