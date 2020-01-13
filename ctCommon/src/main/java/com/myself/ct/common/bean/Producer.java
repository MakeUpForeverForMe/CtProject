package com.myself.ct.common.bean;

import java.io.Closeable;

/**
 * 生产者接口
 */
public interface Producer extends Closeable {
  /**
   * 数据来源
   *
   * @param in 来源对象
   */
  void setIn(DataIn in);

  /**
   * 数据输出地
   *
   * @param out 数据输出对象
   */
  void setOut(DataOut out);

  /**
   * 生产数据
   */
  void produce();
}
