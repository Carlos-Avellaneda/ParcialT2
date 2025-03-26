package edu.eci.cvds.ecicredit;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

/**
 * This is the class User, these represent the users that will be using the application, users that are admins have
 * access to manage (CRUD) all labs, reservations and users. Those who are not admins can only manage their only reservations
 * and create new ones under their ID
 */
@Document(collection = "users")
public class User  {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;
    String name;

    String password;
    boolean role;

    public User(String name, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
    }
    public User(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {return password;}

    public void setPassword(String contra) {this.password = contra;}


}

