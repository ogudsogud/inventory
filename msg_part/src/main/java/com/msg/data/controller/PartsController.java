package com.msg.data.controller;

import com.msg.data.model.ErrCode;
import com.msg.data.model.PartsModel;
import com.msg.data.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
@RestController
@RequestMapping("/msg-parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

    //menampilkan data parts
    @RequestMapping(value = "/list-new-parts", method = RequestMethod.GET)
//    public ResponseEntity<List<PartsModel>> getDataParts(){

        public ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        List<PartsModel> list = partsService.getDataParts();

        modelAndView.addObject("part_list_master", list);
        modelAndView.setViewName("part_list_master");
        return modelAndView;

//        List<PartsModel> list = partsService.getDataParts();
//        return new ResponseEntity<List<PartsModel>>(list, HttpStatus.OK);
    }

    //menambahkan data parts baru
    @RequestMapping(value = "/insert-new-parts", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PartsModel partsModel, UriComponentsBuilder uriComponentsBuilder) {
        if (partsService.isPartsExist(partsModel.getPart_number()) == true) {
            partsService.insertPartsNew(partsModel);
            return new ResponseEntity(new ErrCode("201", "Data Part berhasil Disimpan"), HttpStatus.CREATED);
        }
            return  new ResponseEntity(new ErrCode("409", "Data Part sudah ada"), HttpStatus.CONFLICT);
    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/parts-number={partnum}", method = RequestMethod.GET)
    public ResponseEntity<PartsModel> getByPartNum(@PathVariable("partnum") String partnum) {
        PartsModel partsModel = partsService.getByPartNumb(partnum);
        return new ResponseEntity<PartsModel>(partsModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/parts-name={partname}", method = RequestMethod.GET)
    public ResponseEntity<PartsModel> getByPartName(@PathVariable("partname") String partname) {
        PartsModel partsModel = partsService.getByPartName(partname);
        return new ResponseEntity<PartsModel>(partsModel, HttpStatus.OK);
    }

}
