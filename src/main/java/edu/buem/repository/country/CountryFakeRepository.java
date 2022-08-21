package edu.buem.repository.country;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class CountryFakeRepository {
    //private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(
            new Country("1", "Germany",false, 3, ClimateTypes.CONTINENTAL),
            new Country("2","France", false, 6, ClimateTypes.DRY)

    ));
    public List<Country> findAll()
    {
        return this.countries;
    }

    public Country findById(String id) {
        return this.countries.stream().filter(discount -> discount.getId().equals(id)).findFirst().orElse(null);
    }

    public Country update(Country country) {
        deleteById(country.getId());
        country.setUpdatedAt(LocalDateTime.now());
        countries.add(country);
        return country;
    }

    public void deleteById(String id) {
        Country country = this.findById(id);
        this.countries.remove(country);

    }

    public Country save(Country country) {
        country.setId(UUID.randomUUID().toString());
        country.setCreatedAt(LocalDateTime.now());

        this.countries.add(country);
        return country;
    }
}
