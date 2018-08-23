package com.msg.data.controller;

import com.msg.data.model.BrandModel;
import com.msg.data.model.ErrCode;
import com.msg.data.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 23/08/2018.
 */

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/list")
    public ResponseEntity<List<BrandModel>> getAllPrts(){
        List<BrandModel> list = brandService.getDataBrand();
        return new ResponseEntity<List<BrandModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert-new", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody BrandModel brandModel, UriComponentsBuilder uriComponentsBuilder) {
        if (brandService.isBrandExist(brandModel.getBrand_name()) == true) {
            brandService.insertBrand(brandModel);
            return new ResponseEntity(new ErrCode("201", "Data Brand berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Brand sudah ada"), HttpStatus.CONFLICT);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<BrandModel> updateUser(@RequestBody BrandModel brandModel) {
        brandService.updateBrand(brandModel);
        return new ResponseEntity(new ErrCode("201", "Data Brand berhasil diubah"), HttpStatus.OK);
    }

    @DeleteMapping("/delete={brandname}")
    public ResponseEntity<Void> deletePartNumber(@PathVariable("brandname") String brandname) {
        brandService.deleteBrand(brandname);
        return new ResponseEntity(new ErrCode("201", "Data Parts berhasil Dihapus"), HttpStatus.OK);
    }

}
