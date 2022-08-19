package edu.buem.controller.ui;

import edu.buem.model.Country;
import edu.buem.service.country.impls.ICountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ui/v1/countries/")
@Controller
public class CountryUIController {

    @Autowired
    ICountryServiceImpl service;

    @GetMapping("")
    public String showAll(Model model)
    {
        model.addAttribute("countries",service.getAll());
        return "countries";
    }
    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id)
    {
        service.delete(id);
        return "redirect:/ui/v1/countries/";
    }
    @PostMapping("/countries")
    public String greetingSubmit(@ModelAttribute Country country, Model model) {
        model.addAttribute("country", country);
        return "redirect:/ui/v1/countries/";
    }
}
