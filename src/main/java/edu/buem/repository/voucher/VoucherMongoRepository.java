package edu.buem.repository.voucher;

import edu.buem.model.Country;
import edu.buem.model.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VoucherMongoRepository extends MongoRepository<Voucher, String> {
    List<Voucher> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
