package com.pnswebuiautomation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    private static final Logger log = LogManager.getLogger(CommonUtil.class);


    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH.mm.sss").format(new Date());
    }

}
