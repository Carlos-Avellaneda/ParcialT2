package edu.eci.cvds.ecicredit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByName(String name);

    @Query("{'name': {$regex:'^?0',$options: 'i'}}")
    ArrayList<User>findByStartingWith(String name);
}