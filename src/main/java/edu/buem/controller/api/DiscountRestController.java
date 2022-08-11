package edu.buem.controller.api;

import edu.buem.model.Discount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;

@RequestMapping("/api/v1/discounts")
@RestController
public class DiscountRestController {
    Discount discount = new Discount("1","name1",3,"descp",
            LocalDateTime.now(), LocalDateTime.now());
    @RequestMapping("/ex")
    public Discount showExample()
    {
         return discount;
    }
}
