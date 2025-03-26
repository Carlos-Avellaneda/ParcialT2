package edu.eci.cvds.ecicredit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface BillRepository extends MongoRepository<Bill, String> {
    List<Bill> findByLabIdAndDayDate(String labId, LocalDate date);

    ArrayList<Bill> findByUserId(String userId);
    ArrayList<Bill> findByLabId(String labId);

    List<Bill> findReservationByDay_Date(LocalDate revDate);
    List<Bill> findByUserIdAndDayDate(String userId, LocalDate date);
    List<Bill> findByUserIdAndLabId(String userId, String labId);
    List<Bill> findByLabIdAndDayDateAndUserId(String labId, LocalDate date, String userId);


}
