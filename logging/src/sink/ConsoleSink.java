package sink;

public class ConsoleSink implements LogSink {

    @Override
    public void log(String msg) {
        System.out.println("Console sink: " + msg);
    }
}
