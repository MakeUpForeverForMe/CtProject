package com.myself.ct.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {
  /**
   * 将日期字符串按照指定格式解析为日期对象
   *
   * @param dateString 传入的字符串型的时间
   * @param format     传入的格式化格式
   * @return 返回格式化后的日期
   */
  public static Date parse(String dateString, String format) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    Date date = null;
    try {
      date = simpleDateFormat.parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /**
   * 将指定的日期按照指定的格式格式化为字符串
   *
   * @param date   传入的日期
   * @param format 传入的格式
   * @return 返回格式化后的字符串
   */
  public static String format(Date date, String format) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.format(date);
  }
}
