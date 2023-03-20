import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class question2 {
    @Id
    private String id;
    private String text;

    @ElementCollection
    @CollectionTable(
            name = "question_choice",
            joinColumns = @JoinColumn(name = "question_id")
    )
    @OrderColumn(name = "idx")
    private List<choice> choiceList;

    protected question2 (){}

    public question2(String id, String text, List<choice> choiceList) {
        this.id = id;
        this.text = text;
        this.choiceList = choiceList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<choice> choiceList) {
        this.choiceList = choiceList;
    }
}
