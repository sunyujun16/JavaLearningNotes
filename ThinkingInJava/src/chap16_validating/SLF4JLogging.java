package chap16_validating;

import org.slf4j.*;

public class SLF4JLogging {
    private static Logger log =
            LoggerFactory.getLogger(SLF4JLogging.class);

    public static void main(String[] args) {
        String s = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("classpath => " + s );

        log.info("hello logging");
    }
}
