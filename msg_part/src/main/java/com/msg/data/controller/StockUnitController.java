package com.msg.data.controller;

import com.msg.data.model.StockUnitModel;
import com.msg.data.service.StockUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ogudsogud on 8/22/2018.
 */
@RestController
@RequestMapping("/stock-unit")
public class StockUnitController {

    @Autowired
    private StockUnitService stockUnitService;

    @RequestMapping("/list")
    public ResponseEntity<List<StockUnitModel>> getAllStockUnit(){
        List<StockUnitModel> list = stockUnitService.getStockUnit();
        return new ResponseEntity<List<StockUnitModel>>(list, HttpStatus.OK);
    }


}
