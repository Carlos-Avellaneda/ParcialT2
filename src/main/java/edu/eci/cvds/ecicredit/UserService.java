package edu.eci.cvds.ecicredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepo;
    BillController reservationController;
    @Autowired
    public UserService(UserRepository userRepo, BillController reservationController){
        this.userRepo= userRepo;
        this.reservationController = reservationController;
    }

    public boolean createUser(User u) {
        u.setName(u.getName().toLowerCase());
        u.setPassword(u.getPassword().toLowerCase());
        userRepo.save(u);
        return true;
    }

    public boolean deleteUser(String id) {
        if(!userRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        for(Bill bill : BillController.searchBillByUserId(id)){
          BillController.deleteBill(bill.getId());
        }
        userRepo.deleteById(id);
        return true;
    }

    public User searchUser(String id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalUser.get();
    }

    public Optional<User> searchUserByName(String name) {
        return userRepo.findByName(name);
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User authenticate(String name, String password) {
        Optional<User> user = userRepo.findByName(name);
        if(user.isPresent() && user.get().getPassword().equals(password)){

            user.get().setPassword(null);

            return user.get();
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    public ArrayList<User> findByStarting(String name) {
        return userRepo.findByStartingWith(name);
    }
}

