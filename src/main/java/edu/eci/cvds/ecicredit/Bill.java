package edu.eci.cvds.ecicredit;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document(collection = "bills")
public class Bill {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;
    String userId;
    int amount;
    public Bill(String userId, int amount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.userId =userId;
    }
    public Bill(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }


    public String getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    public boolean setLabId(int amo) {
        this.amount = amo;
        return true;
    }

    public boolean setUserId(String userId) {
        this.userId = userId;
        return true;
    }

}

