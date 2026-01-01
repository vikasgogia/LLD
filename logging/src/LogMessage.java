public class LogMessage {

    private final LogLevel level;
    private final String content;
    private final long timestamp;

    // Constructor.
    public LogMessage(LogLevel level, String content) {
        this.level = level;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    // Getter.
    public LogLevel getLevel() {
        return level;
    }

    // Getter.
    public long getTimestamp() {
        return timestamp;
    }

    // Getter.
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "level=" + level +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
