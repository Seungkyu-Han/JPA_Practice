import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user1")
public class User1{
    @Id
    private String name;
    private String email;

    protected User1() {}

    public User1(String name, String email){
        this.name = name;
        this.email = email;
    }
}