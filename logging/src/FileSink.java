public class FileSink implements LogSink {

    @Override
    public void log(String msg) {
        System.out.println("File sink: " + msg);
    }
}
