package edu.buem.service.routelog.impls;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.model.RouteLog;
import edu.buem.repository.routelog.RouteLogMongoRepository;
import edu.buem.service.routelog.interfaces.IRouteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class IRouteLogServiceImpl implements IRouteLogService {

    //private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(
            new Country("1", "Germany",false, 3, ClimateTypes.CONTINENTAL),
            new Country("2", "France", false, 6, ClimateTypes.DRY)

    ));
    @Autowired
    RouteLogMongoRepository repository;

    @PostConstruct
    void init()
    {
        //repository.saveAll(countries);
    }
    @Override
    public RouteLog create(RouteLog routeLog) {
        routeLog.setId(UUID.randomUUID().toString());
        routeLog.setCreatedAt(LocalDateTime.now());
        return repository.save(routeLog);
    }

    @Override
    public RouteLog get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public RouteLog update(RouteLog routeLog) {
        routeLog.setUpdatedAt(LocalDateTime.now());
        return repository.save(routeLog);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<RouteLog> getAll() {
        return repository.findAll();
    }
}
