package edu.eci.cvds.ecicredit;

import java.time.LocalDate;
import java.util.List;

public interface BillService {

    boolean createBill(Bill reservation);
    boolean deleteBill(String id);
    Bill searchBill(String id);

    List<Bill> searchReservationByUserId(String teacherId);
    List<Bill> searchReservationByLabId(String labId);

    List<Bill> getAllBills();

}

