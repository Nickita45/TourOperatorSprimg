package edu.buem.controller.ui;

import edu.buem.model.Client;
import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.service.client.impls.IClientServiceImpl;
import edu.buem.service.country.impls.ICountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ui/v1/clients/")
@Controller
public class ClientUIController {

    @Autowired
    IClientServiceImpl service;

    @GetMapping("")
    public String showAll(Model model)
    {
        model.addAttribute("clients",service.getAll());
        return "clients";
    }
    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id)
    {
        service.delete(id);
        return "redirect:/ui/v1/clients/";
    }
    @RequestMapping( method = RequestMethod.POST)
    public String addCountry(@ModelAttribute Client client, Model model) {
        model.addAttribute("client", client);

        service.create(client);

        return "redirect:/ui/v1/clients/";
    }

    @GetMapping(value = "/edit/{id}")
    public String updateItem(Model model, @PathVariable("id") String id){
        Client itemForm = service.get(id);
        Client itemToUpdate = new Client();

        itemToUpdate.setId(itemForm.getId());
        itemToUpdate.setName(itemForm.getName());
        itemToUpdate.setDescription(itemForm.getDescription());
        itemToUpdate.setCreatedAt(itemForm.getCreatedAt());
        //itemToUpdate.setUpdatedAt(LocalDateTime.now());////????????

        itemToUpdate.setFirstName(itemForm.getFirstName());
        itemToUpdate.setLastName(itemForm.getLastName());
        itemToUpdate.setPatronymic(itemForm.getPatronymic());
        itemToUpdate.setAddress(itemForm.getAddress());
        itemToUpdate.setPhone(itemForm.getPhone());
        itemToUpdate.setDiscountPercentage(itemForm.getDiscountPercentage());


        model.addAttribute("item", itemToUpdate);

        return "updateClient";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateCountry( @ModelAttribute("form") Client form){
        System.out.println(form);

        Client itemForm = service.get(form.getId());
        Client itemtoUpdate = new Client();
        itemtoUpdate.setId(form.getId());
        itemtoUpdate.setName(form.getName());
        itemtoUpdate.setDescription(form.getDescription());
        itemtoUpdate.setCreatedAt(itemForm.getCreatedAt());
        //itemtoUpdate.setUpdatedAt(LocalDateTime.now());////????????

        itemtoUpdate.setFirstName(itemForm.getFirstName());
        itemtoUpdate.setLastName(itemForm.getLastName());
        itemtoUpdate.setPatronymic(itemForm.getPatronymic());
        itemtoUpdate.setAddress(itemForm.getAddress());
        itemtoUpdate.setPhone(itemForm.getPhone());
        itemtoUpdate.setDiscountPercentage(itemForm.getDiscountPercentage());

        service.update(itemtoUpdate);

        return "redirect:/ui/v1/clients/";
    }
}
