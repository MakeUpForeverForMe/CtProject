package com.myself.ct.common.bean;

import java.io.Closeable;

/**
 * 数据输出到什么位置
 */
public interface DataOut extends Closeable {
  void setPath(String path);
}
