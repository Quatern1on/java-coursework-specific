package vt18.turchenko.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vt18.turchenko.coursework.model.SparePart;
import vt18.turchenko.coursework.services.SparePartService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/parts")
public class SparePartsController {

    @Autowired
    private SparePartService service;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public String parts(Model model) {
        model.addAttribute("activePage", "parts");
        model.addAttribute("parts", service.listAll());
        return "parts";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("activePage", "parts");
        model.addAttribute("part", new SparePart());
        model.addAttribute("action", "add");
        model.addAttribute("header", "Add spare part");
        return "parts_form";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("part") SparePart part, BindingResult bindingResult, Model model) {
        model.addAttribute("activePage", "parts");
        model.addAttribute("part", part);
        model.addAttribute("action", "add");
        model.addAttribute("header", "Add spare part");

        if (bindingResult.hasErrors()) {
            return "parts_form";
        }

        service.save(part);

        return "redirect:/parts";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String edit(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("activePage", "parts");
        model.addAttribute("part", service.find(id));
        model.addAttribute("action", "edit/" + id);
        model.addAttribute("header", "Edit spare part");

        return "parts_form";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String edit(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("part") SparePart part,
            BindingResult bindingResult, Model model
    ) {
        model.addAttribute("activePage", "parts");
        model.addAttribute("part", part);
        model.addAttribute("action", "edit/" + id);
        model.addAttribute("header", "Edit spare part");

        if (bindingResult.hasErrors()) {
            return "parts_form";
        }

        part.setId(id);
        service.save(part);

        return "redirect:/parts";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete (@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/parts";
    }
}
