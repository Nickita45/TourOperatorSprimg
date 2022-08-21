package edu.buem.repository.client;

import edu.buem.model.Client;
import edu.buem.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClientMongoRepository extends MongoRepository<Client, String> {
    List<Client> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
