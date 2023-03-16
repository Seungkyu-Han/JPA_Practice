package user;

import jakarta.persistence.Embeddable;

@Embeddable
public class school {

    private String elementarySchool;
    private String middleSchool;
    private String highSchool;

    public school(String elementarySchool, String middleSchool, String highSchool) {
        this.elementarySchool = elementarySchool;
        this.middleSchool = middleSchool;
        this.highSchool = highSchool;
    }

    protected school() {

    }

    public String getElementarySchool() {
        return elementarySchool;
    }

    public void setElementarySchool(String elementarySchool) {
        this.elementarySchool = elementarySchool;
    }

    public String getMiddleSchool() {
        return middleSchool;
    }

    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    @Override
    public String toString() {
        return "school{" +
                "elementarySchool='" + elementarySchool + '\'' +
                ", middleSchool='" + middleSchool + '\'' +
                ", highSchool='" + highSchool + '\'' +
                '}';
    }
}
