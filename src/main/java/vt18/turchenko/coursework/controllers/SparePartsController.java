package vt18.turchenko.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vt18.turchenko.coursework.services.SparePartService;

@Controller
public class SparePartsController {

    @Autowired
    private SparePartService service;

    @RequestMapping(path = "/parts", method = RequestMethod.GET)
    public String parts(Model model) {
        model.addAttribute("activePage", "parts");
        model.addAttribute("parts", service.listAll());
        return "parts";
    }
}
