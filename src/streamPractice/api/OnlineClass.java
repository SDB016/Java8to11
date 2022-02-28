package streamPractice.api;

public class OnlineClass {
    private long id;
    private String title;
    private boolean closed;

    public OnlineClass(long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }
}
