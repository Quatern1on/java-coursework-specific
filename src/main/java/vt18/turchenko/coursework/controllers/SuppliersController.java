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
import vt18.turchenko.coursework.services.SupplierService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/suppliers")
public class SuppliersController {

    @Autowired
    private SupplierService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String parts(Model model) {
        model.addAttribute("activePage", "suppliers");
        model.addAttribute("suppliers", service.listAll());
        return "suppliers";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("activePage", "suppliers");
        model.addAttribute("suppliers", new Supplier());
        model.addAttribute("action", "add");
        model.addAttribute("header", "Add supplier");
        return "suppliers_form";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("suppliers") Supplier supplier, BindingResult bindingResult, Model model) {
        model.addAttribute("activePage", "suppliers");
        model.addAttribute("suppliers", supplier);
        model.addAttribute("action", "add");
        model.addAttribute("header", "Add supplier");

        if (bindingResult.hasErrors()) {
            return "suppliers_form";
        }

        service.save(supplier);

        return "redirect:/suppliers";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String edit(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("activePage", "suppliers");
        model.addAttribute("suppliers", service.find(id));
        model.addAttribute("action", "edit/" + id);
        model.addAttribute("header", "Edit supplier");

        return "suppliers_form";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String edit(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("part") Supplier supplier,
            BindingResult bindingResult, Model model
    ) {
        model.addAttribute("activePage", "suppliers");
        model.addAttribute("suppliers", supplier);
        model.addAttribute("action", "edit/" + id);
        model.addAttribute("header", "Edit supplier");

        if (bindingResult.hasErrors()) {
            return "suppliers_form";
        }

        supplier.setId(id);
        service.save(supplier);

        return "redirect:/suppliers";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/suppliers";
    }
}
