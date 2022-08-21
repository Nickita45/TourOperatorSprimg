package edu.buem.repository.routelog;

import edu.buem.model.Country;
import edu.buem.model.RouteLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteLogMongoRepository extends MongoRepository<RouteLog, String> {
    List<RouteLog> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
