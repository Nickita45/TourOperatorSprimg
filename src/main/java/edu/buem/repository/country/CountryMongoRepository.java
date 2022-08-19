package edu.buem.repository.country;

import edu.buem.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CountryMongoRepository extends MongoRepository<Country, String> {
    List<Country> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
