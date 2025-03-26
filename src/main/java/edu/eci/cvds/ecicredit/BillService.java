package edu.eci.cvds.ecicredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class BillService {

    BillRepository billRepo;

    @Autowired
    public BillService(BillRepository billRepo ){
        this.billRepo = billRepo;
    }


    public boolean createBill(Bill bill) {
        Bill b = bill;
        billRepo.save(b);
        return true;
    }

    public boolean deleteBill(String id){
        if(!billRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        billRepo.deleteById(id);
        return true;
    };

    public Bill searchBillById(String id){
        if(!billRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return billRepo.findByBillId(id);
    }

    public List<Bill> getAllBills() {
        return billRepo.findAll();
    }

}

