package com.msg.data.controller;

import com.msg.data.model.PartsModel;
import com.msg.data.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */
@RestController
@RequestMapping("/msg")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @RequestMapping(value="/insert-new-parts", method=RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("partform") PartsModel partsModel) {
        if(partsModel.getId_part_number() != null) {

            System.out.println("Data Part Number Sudah ada");
        } else {
            partsService.insertPartsNew(partsModel);
        }

        return new ModelAndView("redirect:/msg/part-list");
    }

    //menampilkan data parts
    @RequestMapping(value = "/part-list", method = RequestMethod.GET)
    public ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        List<PartsModel> list = partsService.getDataParts();
        modelAndView.addObject("stockpartlist", list);
        modelAndView.setViewName("stockpartlist");
        return modelAndView;

    }

    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/parts-number={partnum}", method = RequestMethod.GET)
    public ResponseEntity<PartsModel> getByPartNum(@PathVariable("partnum") String partnum) {
        PartsModel partsModel = partsService.getByIdPartNumb(partnum);
        return new ResponseEntity<PartsModel>(partsModel, HttpStatus.OK);
    }

}
