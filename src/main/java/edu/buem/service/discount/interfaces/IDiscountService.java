package edu.buem.service.discount.interfaces;

import edu.buem.model.Discount;

import java.util.List;

public interface IDiscountService {
    //Crud
    Discount create(Discount discount);
    Discount get(String id);
    Discount update(Discount discount);
    void delete(String id);
    List<Discount> getAll();

}
