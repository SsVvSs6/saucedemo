package org.tms.utils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageLogger {

    private static final String START_INFO_MESSAGE = "[%s]. Start";
    private static final String SUCCESS_INFO_MESSAGE = "[%s] - OK";
    private static final String WAITING_INFO_MESSAGE = "Waiting [%s]";

    public static void logStartProcessInfo(String processName) {
        log.info(String.format(START_INFO_MESSAGE, processName));
    }

    public static void logEndProcessInfo(String processName) {
        log.info(String.format(SUCCESS_INFO_MESSAGE, processName));
    }

    public static void logWaitingInfo(String waitingName) {
        log.info(String.format(WAITING_INFO_MESSAGE, waitingName));
    }
}
