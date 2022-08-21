package edu.buem.service.routelog.interfaces;

import edu.buem.model.Country;
import edu.buem.model.Route;
import edu.buem.model.RouteLog;

import java.util.List;

public interface IRouteLogService {
    //Crud
    RouteLog create(RouteLog routeLog);
    RouteLog get(String id);
    RouteLog update(RouteLog routeLog);
    void delete(String id);
    List<RouteLog> getAll();

}
