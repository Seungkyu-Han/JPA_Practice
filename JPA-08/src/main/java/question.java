import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class question {
    @Id
    private String id;
    private String text;

    @ElementCollection
    @CollectionTable(
            name = "question_choice",
            joinColumns = @JoinColumn(name = "question_id")
    )
    @OrderColumn(name = "idx")
    @Column(name = "text")
    private List<String> choices;

    protected question () {}

    public question(String id, String text, List<String> choices) {
        this.id = id;
        this.text = text;
        this.choices = choices;
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

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
