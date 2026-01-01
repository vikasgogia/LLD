public class JSONFormatter implements LogFormatter {


    @Override
    public String format(LogMessage msg) {
        return String.format("{\"level\":\"%s\", \"msg\":\"%s\", \"ts\":\"%d\"}",
                msg.getLevel(), msg.getContent(), msg.getTimestamp());
    }
}
