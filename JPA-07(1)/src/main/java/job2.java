import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class job2 {
    @Id
    private String id;
    private String name;

    @ElementCollection
    @CollectionTable(
            name="role_perm",
            joinColumns = @JoinColumn(name = "role_id")
    )
    private Set<information> informationSet = new HashSet<>();

    protected job2(){}

    public job2(String id, String name, Set<information> informationSet) {
        this.id = id;
        this.name = name;
        this.informationSet = informationSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<information> getInformationSet() {
        return informationSet;
    }

    public void setInformationSet(Set<information> informationSet) {
        this.informationSet = informationSet;
    }
}
