package chap16_validating;

import org.slf4j.*;

public class SLF4JLevels {
    private static Logger log =
            LoggerFactory.getLogger(SLF4JLevels.class);

    public static void main(String[] args) {

        String s = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("classpath => " + s );

        log.trace("Hello");
        log.debug("Logging");
        log.info("Using");
        log.warn("the SLF4J");
        log.error("Facade");
    }
}
