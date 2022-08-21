package edu.buem.service.route.impls;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.model.Route;
import edu.buem.repository.country.CountryMongoRepository;
import edu.buem.repository.route.RouteMongoRepository;

import edu.buem.service.route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class IRouteServiceImpl implements IRouteService {

    //private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Route> countries = new ArrayList<Route>(Arrays.asList(


    ));
    @Autowired
    RouteMongoRepository repository;

    @PostConstruct
    void init()
    {
        //repository.saveAll(countries);
    }
    @Override
    public Route create(Route route) {
        route.setId(UUID.randomUUID().toString());
        route.setCreatedAt(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Route update(Route route) {
        route.setUpdatedAt(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Route> getAll() {
        return repository.findAll();
    }
}
