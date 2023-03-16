package user;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class user {

    @Id
    private String email;
    private String name;
    @Embedded
    private school school;

    protected user() {
    }

    public user(String email, String name, school school) {
        this.email = email;
        this.name = name;
        this.school = school;
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

    public school getSchool() {
        return school;
    }

    public void setSchool(school school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "user{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
