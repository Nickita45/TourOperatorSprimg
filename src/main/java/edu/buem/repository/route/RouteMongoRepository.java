package edu.buem.repository.route;

import edu.buem.model.Country;
import edu.buem.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteMongoRepository extends MongoRepository<Route, String> {
    List<Route> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
