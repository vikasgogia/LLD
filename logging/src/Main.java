public class Main {

    public static void main(String[] args) {
        // Error log processor's destination is file.
        LogProcessor err = new ErrorLogProcessor(null);
        err.addObserver(new FileSink());

        // Info log processor's destination is console.
        LogProcessor info = new InfoLogProcessor(err);
        info.addObserver(new ConsoleSink());

        Logger logger = Logger.getInstance();
        logger.initialize(info);

        logger.log(LogLevel.INFO, "Info log it is.");
        logger.log(LogLevel.ERROR, "Error log it is.");
    }
}
