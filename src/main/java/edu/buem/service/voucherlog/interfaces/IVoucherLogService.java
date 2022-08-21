package edu.buem.service.voucherlog.interfaces;

import edu.buem.model.Country;
import edu.buem.model.VoucherLog;

import java.util.List;

public interface IVoucherLogService {
    //Crud
    VoucherLog create(VoucherLog voucherLog);
    VoucherLog get(String id);
    VoucherLog update(VoucherLog voucherLog);
    void delete(String id);
    List<VoucherLog> getAll();

}
