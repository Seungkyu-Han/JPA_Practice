package school;

import jakarta.persistence.*;

@Entity
@Table(name = "school_table")
public class school {

    @Id
    @Embedded
    private info elementInfo;

    @AttributeOverrides({
            @AttributeOverride(name = "addr", column = @Column(name = "midaddr")),
            @AttributeOverride(name = "num", column = @Column(name = "midnum")),
    })
    @Embedded
    private info midInfo;

    protected school () {}

    public school(info elementInfo, info midInfo) {
        this.elementInfo = elementInfo;
        this.midInfo = midInfo;
    }

    public info getElementInfo() {
        return elementInfo;
    }

    public void setElementInfo(info elementInfo) {
        this.elementInfo = elementInfo;
    }

    public info getMidInfo() {
        return midInfo;
    }

    public void setMidInfo(info midInfo) {
        this.midInfo = midInfo;
    }

    @Override
    public String toString() {
        return "school{" +
                "elementInfo=" + elementInfo +
                ", midInfo=" + midInfo +
                '}';
    }
}
