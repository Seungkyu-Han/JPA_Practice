package UserProgram;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String email;
    private String name;
    private LocalDateTime create_date;

    protected User(){}

    public User(String email, String name, LocalDateTime create_date) {
        this.email = email;
        this.name = name;
        this.create_date = create_date;
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

    public LocalDateTime getCreate_data() {
        return create_date;
    }

    public void setCreate_data(LocalDateTime create_data) {
        this.create_date = create_data;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", create_data=" + create_date +
                '}';
    }
}
