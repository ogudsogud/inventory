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
    public ModelAndView saveOrUpdate(@ModelAttribute("partForm") PartsModel partsModel) {
        if(partsService.isPartsExist(partsModel.getId_part_number()) == true) {

            partsService.insertPartsNew(partsModel);

        } else {
            System.out.println("Data Part Number Sudah ada");
        }

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

    @RequestMapping(value="/parts-update/{id_mtr_parts}", method=RequestMethod.GET)
    public ModelAndView editParts(@PathVariable String id_mtr_parts) {
        ModelAndView model = new ModelAndView();

        PartsModel partsModel = partsService.getByIdPart(id_mtr_parts);
        model.addObject("partUpdate", partsModel);

        model.setViewName("partupdate");
        return model;
    }


    @RequestMapping(value="/parts-delete/{id_mtr_parts}", method=RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable("id_mtr_parts") String id_mtr_parts) {
        partsService.deleteById(id_mtr_parts);

        return new ModelAndView("redirect:/msg/parts-list");
    }



    //mancari data parts berdasarkan parameter
    @RequestMapping(value = "/parts-number={partnum}", method = RequestMethod.GET)
    public ResponseEntity<PartsModel> getByPartNum(@PathVariable("partnum") String partnum) {
        PartsModel partsModel = partsService.getByIdPartNumb(partnum);
        return new ResponseEntity<PartsModel>(partsModel, HttpStatus.OK);
    }

}
