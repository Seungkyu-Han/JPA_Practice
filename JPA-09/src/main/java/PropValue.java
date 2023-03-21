import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class PropValue {
    private String value;
    private boolean enabled;

    public PropValue(String value, boolean enabled) {
        this.value = value;
        this.enabled = enabled;
    }

    protected PropValue () {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "PropValue{" +
                "value='" + value + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
