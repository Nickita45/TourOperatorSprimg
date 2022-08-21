package edu.buem.service.route.interfaces;

import edu.buem.model.Country;
import edu.buem.model.Route;

import java.util.List;

public interface IRouteService {
    //Crud
    Route create(Route route);
    Route get(String id);
    Route update(Route route);
    void delete(String id);
    List<Route> getAll();

}
