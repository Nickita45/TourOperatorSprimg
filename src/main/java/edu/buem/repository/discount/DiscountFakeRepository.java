package edu.buem.repository.discount;

import edu.buem.model.Discount;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class DiscountFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private ArrayList<Discount> discounts = new ArrayList<Discount>(Arrays.asList(
            new Discount("1", "name1", 3, "descp", now, now),
            new Discount("2", "name2", 6, "descp", now, now)

    ));
    public List<Discount> findAll()
    {
        return this.discounts;
    }

    public Discount findById(String id) {
        return this.discounts.stream().filter(discount -> discount.getId().equals(id)).findFirst().orElse(null);
    }

    public Discount update(Discount discount) {
        deleteById(discount.getId());
        discount.setUpdatedAt(LocalDateTime.now());
        discounts.add(discount);
        return discount;
    }

    public void deleteById(String id) {
        Discount discount = this.findById(id);
        this.discounts.remove(discount);

    }

    public Discount save(Discount discount) {
        discount.setId(UUID.randomUUID().toString());
        discount.setCreatedAt(LocalDateTime.now());
        this.discounts.add(discount);
        return discount;
    }
}
