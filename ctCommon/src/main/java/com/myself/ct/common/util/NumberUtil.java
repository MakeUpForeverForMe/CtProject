package com.myself.ct.common.util;

import java.text.DecimalFormat;

/**
 * 数字工具类
 */
public class NumberUtil {
  /**
   * 将数字格式化为字符串
   *
   * @param num    传入一个想要格式化的数字
   * @param length 传入格式化数字的长度
   * @return 返回想要的长度的字符串
   */
  public static String format(int num, int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      builder.append("0");
    }
    DecimalFormat df = new DecimalFormat(builder.toString());
    return df.format(num);
  }
}
