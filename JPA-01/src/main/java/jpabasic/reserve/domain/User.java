package jpabasic.reserve.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;
    private String name;
    private LocalDateTime create_date;

    public User(String email, String name, LocalDateTime create_date) {
        this.email = email;
        this.name = name;
        this.create_date = create_date;
    }

    protected User() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }
}
