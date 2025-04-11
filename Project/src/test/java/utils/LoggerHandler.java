package utils;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
 
/**
* Description: LoggerHandler provides utility methods for logging messages
* at different levels such as TRACE, DEBUG, INFO, WARN, ERROR, and FATAL.
* It sets up logging configuration and appends log messages to timestamped files.
* 
* Creator: Bharshini V
*/
public class LoggerHandler {
    private static final Logger logger = Logger.getLogger(LoggerHandler.class);
 
    static {
        setupLoggers();
    }
 
    /**
     * Description: Configures loggers with a timestamped file.
     */
    private static void setupLoggers() {
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String logFileName = String.format("logs/logfile_%s.log", timestamp);
            PatternLayout layout = new PatternLayout("%d{ISO8601} %-5p %c - %m%n");
            FileAppender timestampedAppender = createFileAppender(logFileName, layout);
            logger.addAppender(timestampedAppender);
        } catch (Exception e) {
            logger.error("Failed to initialize logger file appender", e);
        }
    }
 
    /**
     * Description: Creates a file appender with the specified file name and layout.     
     * @param fileName The name of the file for logging.
     * @param layout The pattern layout for formatting log messages.
     * @return A configured FileAppender instance.
     * @throws Exception If an error occurs during appender creation.
     */
    private static FileAppender createFileAppender(String fileName, PatternLayout layout) throws Exception {
        return new FileAppender(layout, fileName, true);
    }
 
    /**
     * Description: Logs a trace-level message.   
     * @param message The message to be logged at TRACE level.
     */
    public static void trace(String message) {
        logger.trace(message);
    }
 
    /**
     * Description: Logs a debug-level message.     
     * @param message The message to be logged at DEBUG level.
     */
    public static void debug(String message) {
        logger.debug(message);
    }
 
    /**
     * Description: Logs an info-level message.     
     * @param message The message to be logged at INFO level.
     */
    public static void info(String message) {
        logger.info(message);
    }
 
    /**
     * Description: Logs a warn-level message.     
     * @param message The message to be logged at WARN level.
     */
    public static void warn(String message) {
        logger.warn(message);
    }
 
    /**
     * Description: Logs an error-level message.     
     * @param message The message to be logged at ERROR level.
     */
    public static void error(String message) {
        logger.error(message);
    }
 
    /**
     * Description: Logs a fatal-level message.     
     * @param message The message to be logged at FATAL level.
     */
    public static void fatal(String message) {
        logger.fatal(message);
    }
}