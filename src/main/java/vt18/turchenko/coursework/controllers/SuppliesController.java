package vt18.turchenko.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vt18.turchenko.coursework.model.Supplier;
import vt18.turchenko.coursework.model.Supply;
import vt18.turchenko.coursework.model.SupplyDto;
import vt18.turchenko.coursework.services.SparePartService;
import vt18.turchenko.coursework.services.SupplierService;
import vt18.turchenko.coursework.services.SupplyService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/supplies")
public class SuppliesController {

    @Autowired
    private SupplyService service;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SparePartService sparePartService;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public String parts(Model model) {
        model.addAttribute("activePage", "supplies");
        model.addAttribute("supplies", service.listAll());
        return "supplies";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("activePage", "supplies");
        model.addAttribute("supply", new SupplyDto());
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("spareParts", sparePartService.listAll());
        model.addAttribute("action", "add");
        model.addAttribute("header", "Add supply");
        return "supplies_form";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("supply") SupplyDto supply, BindingResult bindingResult, Model model) {
        model.addAttribute("activePage", "supplies");
        model.addAttribute("supply", supply);
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("spareParts", sparePartService.listAll());
        model.addAttribute("action", "add");
        model.addAttribute("header", "Add supply");

        if (bindingResult.hasErrors()) {
            return "supplies_form";
        }

        service.save(supply);

        return "redirect:/supplies";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String edit(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("activePage", "supplies");
        model.addAttribute("supply", service.findDto(id));
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("spareParts", sparePartService.listAll());
        model.addAttribute("action", "edit/" + id);
        model.addAttribute("header", "Edit supply");

        return "supplies_form";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String edit(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("supply") SupplyDto supply,
            BindingResult bindingResult, Model model
    ) {
        model.addAttribute("activePage", "supplies");
        model.addAttribute("supply", supply);
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("spareParts", sparePartService.listAll());
        model.addAttribute("action", "edit/" + id);
        model.addAttribute("header", "Edit supply");

        if (bindingResult.hasErrors()) {
            return "supplies_form";
        }

        service.save(supply, id);

        return "redirect:/supplies";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/supplies";
    }
}
