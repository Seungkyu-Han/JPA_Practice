import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class information {
    @Column(name = "perm")
    private String permission;
    private String info;

    protected information () {}

    public information(String permission, String info) {
        this.permission = permission;
        this.info = info;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
