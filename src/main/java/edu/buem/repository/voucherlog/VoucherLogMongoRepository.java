package edu.buem.repository.voucherlog;

import edu.buem.model.Voucher;
import edu.buem.model.VoucherLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VoucherLogMongoRepository extends MongoRepository<VoucherLog, String> {
    List<VoucherLog> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}