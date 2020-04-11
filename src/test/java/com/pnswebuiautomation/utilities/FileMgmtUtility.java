package com.pnswebuiautomation.utilities;

import com.pnswebuiautomation.constants.CommonConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class FileMgmtUtility {

    private static final Logger log = LogManager.getLogger(FileMgmtUtility.class);
    private static final String CHAR_ENCODING_UTF8 = "UTF-8";


    private static Properties readPropertyValue() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(CommonConstants.CONFIG_PROP_PATH);
            if (new File(CommonConstants.CONFIG_PROP_PATH).isFile()) {
                properties.load(fileInputStream);
            }
        } catch (IOException ioe) {
            log.error("config.properties not found!");
//            throw new IOException("config.properties not found!");
        } catch (Exception e) {
            log.error("Something went wrong reading the config.properties");
        }
        return properties;
    }

    public static String getPropertyValue(String key) {
//        logger.info("Getting value from config.properties with key {}", key);
        return readPropertyValue().getProperty(key);
    }

    public static Integer getNumberValue(String key) {
//        logger.info("Getting value from config.properties with key {}", key);
        Integer num = null;
        try {
            num = Integer.parseInt(getPropertyValue(key));
        } catch (NumberFormatException nfe) {
            log.error("Invalid number format for key {} in config.properties", key);
        }
        return num;
    }

    /**
     *
     * @param fileName
     * @param fileContents
     * @throws IOException
     */
    public static void writeTestStepDurationToCSV(String fileName, List<String> fileContents) {

        File file = new File(fileName);
        file.getParentFile().mkdirs();
        try (PrintWriter writer = new PrintWriter(file)){
            writer.write(CommonUtility.createCsvHeader());
            writer.write("\n");
            for (String s : fileContents) {
                writer.write(s);
                writer.write("\n");
            }
        } catch (IOException ioe) {
            log.error("Error writing csv file. Please see stacktrace [{}]", ioe.getMessage());
        }
    }
}