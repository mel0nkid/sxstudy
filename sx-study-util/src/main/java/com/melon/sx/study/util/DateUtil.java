package com.melon.sx.study.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author imelonkid
 * @date 2021/08/07 14:09
 **/
public class DateUtil {

    public static final String DATE_FULL = "yyy-MM-dd hh:mm:ss SSS";

    /** 简单日期格式 */
    public static final String DATE_SIMPLE = "yyyy-MM-dd";

    public static String formatSimple(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIMPLE);
        return sdf.format(date);
    }

}
