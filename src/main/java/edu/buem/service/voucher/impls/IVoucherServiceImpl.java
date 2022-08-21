package edu.buem.service.voucher.impls;

import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.model.Voucher;
import edu.buem.repository.country.CountryMongoRepository;
import edu.buem.repository.voucher.VoucherMongoRepository;
import edu.buem.service.voucher.interfaces.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class IVoucherServiceImpl implements IVoucherService {

    //private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(
            new Country("1", "Germany",false, 3, ClimateTypes.CONTINENTAL),
            new Country("2", "France", false, 6, ClimateTypes.DRY)

    ));
    @Autowired
    VoucherMongoRepository repository;

    @PostConstruct
    void init()
    {
        //repository.saveAll(countries);
    }
    @Override
    public Voucher create(Voucher voucher) {
        voucher.setId(UUID.randomUUID().toString());
        voucher.setCreatedAt(LocalDateTime.now());
        return repository.save(voucher);
    }

    @Override
    public Voucher get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Voucher update(Voucher voucher) {
        voucher.setUpdatedAt(LocalDateTime.now());
        return repository.save(voucher);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Voucher> getAll() {
        return repository.findAll();
    }
}
