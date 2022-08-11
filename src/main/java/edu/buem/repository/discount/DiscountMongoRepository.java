package edu.buem.repository.discount;

import edu.buem.model.Discount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DiscountMongoRepository extends MongoRepository<Discount, String> {
    List<Discount> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
