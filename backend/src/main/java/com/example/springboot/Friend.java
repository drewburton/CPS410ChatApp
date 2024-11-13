package com.example.springboot;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Friend {
    
    /**
     *
     */
    @Id
    private Long id;
    private String name;
    private String email;
    
    public Friend(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Friend(Long id) {
        this.id = id;
    }

    // Constructors
    public Friend() {}
    
    public Friend(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Friend)) return false;
        Friend friend = (Friend) o;
        return id != null && id.equals(friend.id);
    }

    @Override
    public int hashCode() {
        return 31; // Or implement your own logic
    }
}


