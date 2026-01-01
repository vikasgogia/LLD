package formatter;

import entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage msg);
}