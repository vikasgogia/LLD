package formatter;

import entities.LogMessage;

public class TextFormatter implements LogFormatter {

    @Override
    public String format(LogMessage msg) {
        return "[" + msg.getLevel() + "] " + msg.getTimestamp() + " " + msg.getContent();
    }
}
