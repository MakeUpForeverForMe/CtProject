package com.myself.ct.common.bean;

import java.io.Closeable;
import java.io.IOException;

/**
 * 数据输出到什么位置
 */
public interface DataOut extends Closeable {
  /**
   * 设置输出路径
   *
   * @param path 字符串型的路径
   */
  void setPath(String path);

  /**
   * 写出数据
   *
   * @param data 传入Object类型的数据
   * @throws IOException 抛出异常
   */
  void write(Object data) throws IOException;

  /**
   * 写出数据
   *
   * @param data 传入String类型的数据
   * @throws IOException 抛出异常
   */
  void write(String data) throws IOException;
}
