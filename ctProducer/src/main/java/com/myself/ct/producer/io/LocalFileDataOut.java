package com.myself.ct.producer.io;

import com.myself.ct.common.bean.DataOut;

import java.io.IOException;

/**
 * 本地文件数据文件输出
 */
public class LocalFileDataOut implements DataOut {
  public LocalFileDataOut(String path) {
    setPath(path);
  }

  @Override
  public void setPath(String path) {

  }

  @Override
  public void close() throws IOException {

  }
}
