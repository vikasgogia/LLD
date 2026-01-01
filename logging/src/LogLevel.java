public enum LogLevel {

    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);

    private final int level;

    // Constructor.
    LogLevel(int level) {
        this.level = level;
    }

    // Getter.
    public int getLevel() {
        return level;
    }
}
