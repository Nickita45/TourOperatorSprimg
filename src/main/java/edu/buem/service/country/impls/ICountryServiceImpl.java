package edu.buem.service.country.impls;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.repository.country.CountryMongoRepository;
import edu.buem.repository.routelog.RouteLogMongoRepository;
import edu.buem.service.country.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ICountryServiceImpl implements ICountryService {

    //private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(
            new Country("1", "Germany",false, 3, ClimateTypes.CONTINENTAL),
            new Country("2", "France", false, 6, ClimateTypes.DRY)

    ));
    @Autowired
    CountryMongoRepository repository;
    @Autowired
    RouteLogMongoRepository repositoryRouteLog;

    @PostConstruct
    void init()
    {
        //repository.saveAll(countries);
    }
    @Override
    public Country create(Country country) {
        country.setId(UUID.randomUUID().toString());
        country.setCreatedAt(LocalDateTime.now());
        return repository.save(country);
    }

    @Override
    public Country get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Country update(Country country) {
        country.setUpdatedAt(LocalDateTime.now());

        var listRoutes = repositoryRouteLog.findAll().stream()
                .filter(routeLog -> routeLog.getCountry().getId().equals(country.getId()))
                .collect(Collectors.toList());
        listRoutes.stream().forEach(routeLog -> {routeLog.setCountry(country);});
        repositoryRouteLog.saveAll(listRoutes);

        return repository.save(country);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Country> getAll() {
        return repository.findAll();
    }
}
