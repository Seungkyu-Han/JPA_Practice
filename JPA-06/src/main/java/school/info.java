package school;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class info {

    @Column(name = "eleaddr")
    private String addr;
    @Column(name = "elenum")
    private String num;

    protected info(){}

    public info(String addr, String num) {
        this.addr = addr;
        this.num = num;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
