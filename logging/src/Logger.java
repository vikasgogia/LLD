import entities.LogLevel;
import entities.LogMessage;
import processor.LogProcessor;

public class Logger {

    private static Logger instance;
    private LogProcessor processorChain;

    // No one can call the constructor.
    private Logger() {}

    // Singleton pattern.
    public static Logger getInstance() {
        if(instance == null) {
            // Thread safety.
            synchronized (Logger.class) {
                instance = new Logger();
            }
        }

        return instance;
    }

    // Chain of responsibility design pattern.
    public void initialize(LogProcessor chain) {
        this.processorChain = chain;
    }

    // Log a message.
    public void log(LogLevel level, String content) {
        LogMessage msg = new LogMessage(level, content);

        if(this.processorChain != null) {
            this.processorChain.log(msg);
        }
    }
}
