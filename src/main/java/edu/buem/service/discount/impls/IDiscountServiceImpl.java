package edu.buem.service.discount.impls;

import edu.buem.model.Discount;
import edu.buem.repository.discount.DiscountFakeRepository;
import edu.buem.repository.discount.DiscountMongoRepository;
import edu.buem.service.discount.interfaces.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IDiscountServiceImpl implements IDiscountService {

    private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Discount> discounts = new ArrayList<Discount>(Arrays.asList(
            new Discount("1", "name1", 3, "descp", now, now),
            new Discount("2", "name2", 6, "descp", now, now)

    ));
    @Autowired
    DiscountMongoRepository repository;

    @PostConstruct
    void init()
    {
        //repository.saveAll(discounts);
    }
    @Override
    public Discount create(Discount discount) {
        discount.setCreatedAt(LocalDateTime.now());
        return repository.save(discount);
    }

    @Override
    public Discount get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Discount update(Discount discount) {
        discount.setUpdatedAt(LocalDateTime.now());
        return repository.save(discount);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Discount> getAll() {
        return repository.findAll();
    }
}
