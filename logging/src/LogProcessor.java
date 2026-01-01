import java.util.ArrayList;
import java.util.List;

public abstract class LogProcessor {
    // Linked list next pointer
    protected LogProcessor next;

    private List<LogSink> observers = new ArrayList<>();

    protected LogFormatter formatter = new TextFormatter();

    // Constructor.
    public LogProcessor(LogProcessor next) {
        this.next = next;
    }

    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    protected LogFormatter getFormatter() {
        return this.formatter;
    }

    // Observer design pattern.
    public void addObserver(LogSink observer) {
        observers.add(observer);
    }

    protected void notifyObservers(String msg) {
        for (LogSink observer : observers) {
            observer.log(msg);
        }
    }

    public void log(LogMessage msg) {
        if(next != null) {
            next.log(msg);
        }
    }
}
