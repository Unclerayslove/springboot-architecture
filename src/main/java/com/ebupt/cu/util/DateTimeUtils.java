package com.ebupt.cu.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName DateTimeUtils
 * @Description
 * @Author Leipei
 * @Date 2020/11/10 13:39
 * @Version V1.0
 **/
public class DateTimeUtils {

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * @return yyyyMMddHHmmss
     */
    public static String yyyyMMddHHmmss() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

}
