package edu.buem.service.voucher.interfaces;

import edu.buem.model.Country;
import edu.buem.model.Voucher;

import java.util.List;

public interface IVoucherService {
    //Crud
    Voucher create(Voucher voucher);
    Voucher get(String id);
    Voucher update(Voucher voucher);
    void delete(String id);
    List<Voucher> getAll();

}
