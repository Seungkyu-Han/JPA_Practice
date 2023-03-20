import jakarta.persistence.Embeddable;

@Embeddable
public class choice {
    private String text;
    private boolean input;

    protected choice() {}

    public choice(String text, boolean input) {
        this.text = text;
        this.input = input;
    }

    public String getText() {
        return text;
    }

    public boolean getInput() {
        return input;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setInput(boolean input) {
        this.input = input;
    }
}
