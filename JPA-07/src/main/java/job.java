import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "job")
public class job {
    @Id
    private String id;
    private String name;

    @ElementCollection
    @CollectionTable(
            name="job_perm", //job_perm 테이블 명
            joinColumns = @JoinColumn(name = "job_id") //job_perm 테이블의 job_id column
    )
    @Column(name = "perm") //job_perm 테이블의 permission column
    private Set<String> permissions = new HashSet<>();

    protected job() {}

    public job(String id, String name, Set<String> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
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

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
