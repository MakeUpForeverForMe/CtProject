package com.myself.ct.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * 数据来源
 */
public interface DataIn extends Closeable {
  /**
   * 设置路径
   *
   * @param path 字符串型的路径
   */
  void setPath(String path);

  /**
   * 读取一行数据
   *
   * @return 以Object类型返回读取到的数据
   * @throws IOException 抛出异常
   */
  Object read() throws IOException;

  /**
   * 读取多航数据
   *
   * @param clazz 传入封装的类型
   * @param <T>   封装的类
   * @return 以List返回读取到的数据
   * @throws IOException 抛出异常
   */
  <T extends Data> List<T> read(Class<T> clazz) throws IOException;
}
