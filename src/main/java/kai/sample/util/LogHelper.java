package kai.sample.util;

import org.slf4j.Logger;

public class LogHelper {

    public static void logInfo(Logger logger, String msg) {
        logInfo(logger, msg, null);
    }

    public static void logInfo(Logger logger, String msg, Object... params) {
        if (logger != null && logger.isInfoEnabled()) {
            logger.info(msg, params);
        }
    }

    public static void logError(Logger logger, String msg) {
        logError(logger, msg, null);
    }

    public static void logError(Logger logger, String msg, Object... params) {
        if (logger != null && logger.isErrorEnabled()) {
            logger.error(msg, params);
        }
    }

}
