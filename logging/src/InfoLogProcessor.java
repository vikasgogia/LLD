public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor next) {
        super(next);
    }

    public void log(LogMessage msg) {
        if(msg.getLevel() != LogLevel.INFO) {
            // Pass to next.
            super.log(msg);
            return;
        }
        notifyObservers(this.getFormatter().format(msg));
    }
}
