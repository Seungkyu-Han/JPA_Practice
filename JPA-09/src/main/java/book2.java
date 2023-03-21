import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "book")
public class book2 {
    @Id
    private String id;
    private String title;
    private String content;
    @ElementCollection
    @CollectionTable(
            name = "book_prop",
            joinColumns = @JoinColumn(name = "book_id")
    )
    @MapKeyColumn(name = "name")
    private Map<String, PropValue> props = new HashMap<>();

    public book2(String id, String title, String content, Map<String, PropValue> props) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.props = props;
    }

    protected book2 () {}

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

    public Map<String, PropValue> getProps() {
        return props;
    }

    public void setProps(Map<String, PropValue> props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "book2{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", props=" + props +
                '}';
    }
}
