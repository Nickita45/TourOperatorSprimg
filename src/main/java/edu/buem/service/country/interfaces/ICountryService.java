package edu.buem.service.country.interfaces;

import edu.buem.model.Country;

import java.util.List;

public interface ICountryService {
    //Crud
    Country create(Country discount);
    Country get(String id);
    Country update(Country discount);
    void delete(String id);
    List<Country> getAll();

}
