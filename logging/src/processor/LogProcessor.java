package processor;

import entities.LogMessage;
import formatter.LogFormatter;
import formatter.TextFormatter;
import sink.LogSink;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogProcessor {
    // Linked list next pointer
    protected LogProcessor next;

    private List<LogSink> observers = new CopyOnWriteArrayList<>();

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
