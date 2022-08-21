package edu.buem.service.voucherlog.impls;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.model.VoucherLog;
import edu.buem.repository.voucherlog.VoucherLogMongoRepository;
import edu.buem.service.voucherlog.interfaces.IVoucherLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class IVoucherLogServiceImpl implements IVoucherLogService {

    //private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(
            new Country("1", "Germany",false, 3, ClimateTypes.CONTINENTAL),
            new Country("2", "France", false, 6, ClimateTypes.DRY)

    ));
    @Autowired
    VoucherLogMongoRepository repository;

    @PostConstruct
    void init()
    {
        //repository.saveAll(countries);
    }
    @Override
    public VoucherLog create(VoucherLog voucherLog) {
        voucherLog.setId(UUID.randomUUID().toString());
        voucherLog.setCreatedAt(LocalDateTime.now());
        return repository.save(voucherLog);
    }

    @Override
    public VoucherLog get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public VoucherLog update(VoucherLog voucherLog) {
        voucherLog.setUpdatedAt(LocalDateTime.now());
        return repository.save(voucherLog);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<VoucherLog> getAll() {
        return repository.findAll();
    }
}
