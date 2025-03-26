package edu.eci.cvds.ecicredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins = "*")
public class BillController {
    @Autowired
     BillService billService;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody Bill bill) {
        billService.createBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bill successfully booked");
    }

    @DeleteMapping("/{id}")
    public static ResponseEntity<String> deleteBill(@PathVariable String id) {
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill successfully deleted ");
    }



    @GetMapping("/user/{userId}")
    public static List<Bill> searchBillByUserId(@PathVariable String userId) {
        return billService.searchReservationByUserId(userId);
    }

    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }










}