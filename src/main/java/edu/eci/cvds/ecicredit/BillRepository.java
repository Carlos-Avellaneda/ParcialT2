package edu.eci.cvds.ecicredit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BillRepository extends MongoRepository<Bill, String> {

    ArrayList<Bill> findByUserId(String userId);

    Bill findByBillId(String Id);

}
