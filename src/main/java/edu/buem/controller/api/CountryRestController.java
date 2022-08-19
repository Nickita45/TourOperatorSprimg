package edu.buem.controller.api;

import edu.buem.model.Country;
import edu.buem.service.country.impls.ICountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/countries")
@RestController
public class CountryRestController {

    @Autowired
    ICountryServiceImpl service;

    @GetMapping("/")
    public List<Country> showAll()
    {
         return service.getAll();
    }
    @GetMapping("/{id}")
    public Country showOne(@PathVariable String id)
    {
        return service.get(id);
    }
    @DeleteMapping("{id}")
    public void del(@PathVariable String id)
    {
        service.delete(id);
    }
    @PostMapping()
    public Country insertOne(@RequestBody Country discount)
    {
        return service.create(discount);
    }
    @PutMapping()
    public Country updateOne(@RequestBody Country discount){
        return service.update(discount);
    }
}
