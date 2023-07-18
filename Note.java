import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Note {
    private String id;
    private String title;
    private String body;
    private Date date;

    public Note() {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + title + ", body=" + body + ", date=" + getDate() + "]";
    }
}