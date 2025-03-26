package edu.eci.cvds.ecicredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User u) {
        userService.createUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User successfully deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchUser(@PathVariable String id) {
        User searched = userService.searchUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(searched);
    }

    @GetMapping("/name/{name}")
    public Optional<User> searchUserByName(@PathVariable String name) {
        return userService.searchUserByName(name);
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        User userO = userService.authenticate(user.getName(),user.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(userO);
    }

    @GetMapping("/starting/{name}")
    public ArrayList<User> searchByStarting(@PathVariable String name) {
        return userService.findByStarting(name);
    }

}
