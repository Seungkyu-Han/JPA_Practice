import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "book")
public class book {
    @Id
    private String id;
    private String title;
    private String content;
    @ElementCollection
    @CollectionTable(
            name = "book_prop",
            joinColumns = @JoinColumn(name="book_id")
    )
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, String> props = new HashMap<>();

    protected book(){}

    public book(String id, String title, String content, Map<String, String> props) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.props = props;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getProps() {
        return props;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", props=" + props +
                '}';
    }
}
