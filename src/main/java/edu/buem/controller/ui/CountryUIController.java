package edu.buem.controller.ui;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.service.country.impls.ICountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/countries/")
@Controller
public class CountryUIController {

    @Autowired
    ICountryServiceImpl service;

    @GetMapping("")
    public String showAll(Model model)
    {
        model.addAttribute("countries",service.getAll());
        model.addAttribute("enums", ClimateTypes.values());
        return "countries";
    }
    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id)
    {
        service.delete(id);
        return "redirect:/ui/v1/countries/";
    }
    @RequestMapping( method = RequestMethod.POST)
    public String addCountry(@ModelAttribute Country country, Model model) {
        model.addAttribute("country", country);

        service.create(country);

        return "redirect:/ui/v1/countries/";
    }
    @GetMapping(value = "/edit/{id}")
    public String updateItem(Model model, @PathVariable("id") String id){
        Country itemForm = service.get(id);
        Country itemToUpdate = new Country();

        itemToUpdate.setId(itemForm.getId());
        itemToUpdate.setName(itemForm.getName());
        itemToUpdate.setDescription(itemForm.getDescription());
        itemToUpdate.setCreatedAt(itemForm.getCreatedAt());
        itemToUpdate.setUpdatedAt(LocalDateTime.now());////????????

        itemToUpdate.setClimateTypes(itemForm.getClimateTypes());
        itemToUpdate.setLevelTourism(itemForm.getLevelTourism());
        itemToUpdate.setVisa(itemForm.isVisa());

        model.addAttribute("item", itemToUpdate);
        model.addAttribute("enums", ClimateTypes.values());
        return "updateItem";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateCountry( @ModelAttribute("form") Country form){
        System.out.println(form);

        Country itemForm = service.get(form.getId());
        Country itemtoUpdate = new Country();
        itemtoUpdate.setId(form.getId());
        itemtoUpdate.setName(form.getName());
        itemtoUpdate.setDescription(form.getDescription());
        itemtoUpdate.setCreatedAt(itemForm.getCreatedAt());
        itemtoUpdate.setUpdatedAt(LocalDateTime.now());////????????

        itemtoUpdate.setClimateTypes(form.getClimateTypes());
        itemtoUpdate.setLevelTourism(form.getLevelTourism());
        itemtoUpdate.setVisa(form.isVisa());

        service.update(itemtoUpdate);

        return "redirect:/ui/v1/countries/";
    }
}
