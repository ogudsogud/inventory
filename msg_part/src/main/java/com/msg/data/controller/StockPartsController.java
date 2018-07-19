package com.msg.data.controller;

import com.msg.data.model.StockPartsModel;
import com.msg.data.service.StockPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
@RestController
@RequestMapping("/msg")
public class StockPartsController {

    @Autowired
    private StockPartsService stockPartsService;

    //menampilkan data parts
    @RequestMapping(value = "/part-list", method = RequestMethod.GET)
//    public ResponseEntity<List<StockPartsModel>> getDataParts(){

        public ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        List<StockPartsModel> list = stockPartsService.getDataStockParts();

        modelAndView.addObject("partlist", list);
        modelAndView.setViewName("partlist");
        return modelAndView;

//        List<StockPartsModel> list = stockPartsService.getDataParts();
//        return new ResponseEntity<List<StockPartsModel>>(list, HttpStatus.OK);
    }

    //menambahkan data parts baru
    @RequestMapping(value = "/insert-new-parts", method = RequestMethod.GET)
//    public ResponseEntity<Void> createCluster(@RequestBody StockPartsModel stockPartsModel, UriComponentsBuilder uriComponentsBuilder) {
//        if (stockPartsService.isStockPartsExist(stockPartsModel.getId_part_number()) == true) {
//            stockPartsService.insertStockPartsNew(stockPartsModel);
//            return new ResponseEntity(new ErrCode("201", "Data Part berhasil Disimpan"), HttpStatus.CREATED);
//        }
//            return  new ResponseEntity(new ErrCode("409", "Data Part sudah ada"), HttpStatus.CONFLICT);
        public ModelAndView addEmployee() {
            ModelAndView model = new ModelAndView();

            StockPartsModel stockPartsModel = new StockPartsModel();
            model.addObject("partForm", stockPartsModel);

            model.setViewName("partlist_form");
            return model;
    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/parts-number={partnum}", method = RequestMethod.GET)
    public ResponseEntity<StockPartsModel> getByPartNum(@PathVariable("partnum") String partnum) {
        StockPartsModel stockPartsModel = stockPartsService.getPartNumb(partnum);
        return new ResponseEntity<StockPartsModel>(stockPartsModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/parts-name={partname}", method = RequestMethod.GET)
    public ResponseEntity<StockPartsModel> getByPartName(@PathVariable("partname") String partname) {
        StockPartsModel stockPartsModel = stockPartsService.getByStockPartName(partname);
        return new ResponseEntity<StockPartsModel>(stockPartsModel, HttpStatus.OK);
    }

}
