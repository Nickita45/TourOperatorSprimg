package edu.buem.controller.api;

import edu.buem.model.Discount;
import edu.buem.service.discount.impls.IDiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1/discounts")
@RestController
public class DiscountRestController {

    @Autowired
    IDiscountServiceImpl service;

    @GetMapping("/")
    public List<Discount> showAll()
    {
         return service.getAll();
    }
    @GetMapping("/{id}")
    public Discount showOne(@PathVariable String id)
    {
        return service.get(id);
    }
    @DeleteMapping("{id}")
    public void del(@PathVariable String id)
    {
        service.delete(id);
    }
    @PostMapping()
    public Discount insertOne(@RequestBody Discount discount)
    {
        return service.create(discount);
    }
    @PutMapping()
    public Discount updateOne(@RequestBody Discount discount){
        return service.update(discount);
    }
}
