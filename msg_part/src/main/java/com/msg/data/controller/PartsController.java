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


    @RequestMapping(value="/parts-add", method=RequestMethod.GET)
    public ModelAndView addParts() {
        ModelAndView model = new ModelAndView();

        PartsModel partsModel = new PartsModel();
        model.addObject("partForm", partsModel);

        model.setViewName("partform");
        return model;
    }


    @RequestMapping(value="/parts-save", method=RequestMethod.POST)
    public ModelAndView saveNew(@ModelAttribute("partForm") PartsModel partsModel) {
        if(partsService.isPartsExist(partsModel.getId_part_number()) == true) {

            partsService.insertPartsNew(partsModel);

        } else {
            System.out.println("Data Part Number Sudah ada");
        }

        return new ModelAndView("redirect:/msg/parts-list");
    }


    @RequestMapping(value="/save-update", method=RequestMethod.POST)
    public ModelAndView saveUpdate(@ModelAttribute("partUpdate") PartsModel partsModel) {
        partsService.updatePart(partsModel);
        return new ModelAndView("redirect:/msg/parts-list");
    }



    //menampilkan data parts
    @RequestMapping(value = "/parts-list", method = RequestMethod.GET)
    public ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        List<PartsModel> list = partsService.getDataParts();
        modelAndView.addObject("partList", list);
        modelAndView.setViewName("partlist");
        return modelAndView;

    }

    @RequestMapping(value="/parts-update/{id_parts_number}", method=RequestMethod.GET)
    public ModelAndView editParts(PartsModel partsModel) {
        ModelAndView model = new ModelAndView();

        model.addObject("partUpdate", partsModel);

        model.setViewName("partupdate");

        return model;
    }


    @RequestMapping(value="/parts-delete/{id_parts_number}", method=RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable("id_parts_number") String id_parts_number) {
        partsService.deletePartNumber(id_parts_number);

        return new ModelAndView("redirect:/msg/parts-list");
    }



    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/parts-number={partnum}", method = RequestMethod.GET)
    public ResponseEntity<PartsModel> getByPartNum(@PathVariable("partnum") String partnum) {
        PartsModel partsModel = partsService.getByIdPartNumb(partnum);
        return new ResponseEntity<PartsModel>(partsModel, HttpStatus.OK);
    }

}
