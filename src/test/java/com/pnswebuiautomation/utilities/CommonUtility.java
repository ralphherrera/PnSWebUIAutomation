package com.pnswebuiautomation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CommonUtility {

    private static final Logger log = LogManager.getLogger(CommonUtility.class);


    /**
     * Gets the current timestamp
     * @return current timestamp
     */
    public static LocalDateTime getCurrentTimeStamp() {
        return LocalDateTime.now();
    }

    /**
     * Get the duration between Start time and End Time
     * @param ldtStartTime Execution start time
     * @param ldtEndTime Execution end time
     * @return Difference between the start and end time
     */
    public static Long getElapsedTimeInMilliSeconds(LocalDateTime ldtStartTime, LocalDateTime ldtEndTime) {
        return Duration.between(ldtStartTime, ldtEndTime).toMillis();
    }

    /**
     *
     * @param ldt
     * @return
     */
    public static String covertLocalDateTimeToString(LocalDateTime ldt) {
        final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        return ldt.format(DATE_TIME_FORMATTER);
    }

    /**
     *
     * @param stepStartTime
     * @param stepEndTime
     * @param testCaseName
     * @param testStepName
     * @return
     */
    public static String processStepDuration(LocalDateTime stepStartTime, LocalDateTime stepEndTime, String testCaseName, String testStepName) {
        StringBuilder sb = new StringBuilder();
        sb.append(covertLocalDateTimeToString(stepStartTime));
        sb.append(",");
        sb.append(getElapsedTimeInMilliSeconds(stepStartTime, stepEndTime));
        sb.append(",");
        sb.append(testCaseName);
        sb.append(",");
        sb.append(testStepName);
        sb.append(",");
        sb.append(covertLocalDateTimeToString(stepStartTime));
        sb.append(",");
        sb.append(covertLocalDateTimeToString(stepEndTime));
        return sb.toString();
    }

    /**
     * Creates headers for the csv file to be generated
     * @return string headers for the csv file to be generated
     */
    public static String createCsvHeader() {
        StringBuilder csvHeader = new StringBuilder();
        csvHeader.append("Execution DateTime");
        csvHeader.append(",");
        csvHeader.append("Elapsed Time (MS)");
        csvHeader.append(",");
        csvHeader.append("Test Case");
        csvHeader.append(",");
        csvHeader.append("Test Step");
        csvHeader.append(",");
        csvHeader.append("Test Step Start Time");
        csvHeader.append(",");
        csvHeader.append("Test Step End Time");
        return csvHeader.toString();
    }
}
