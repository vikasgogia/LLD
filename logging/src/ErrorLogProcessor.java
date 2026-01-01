public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor next) {
        super(next);
    }

    public void log(LogMessage msg) {
        if(msg.getLevel() != LogLevel.ERROR) {
            super.log(msg);
            return;
        }
        notifyObservers(this.getFormatter().format(msg));
    }
}
