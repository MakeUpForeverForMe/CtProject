package com.myself.ct.producer.io;

import com.myself.ct.common.bean.DataOut;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 本地文件数据文件输出
 */
public class LocalFileDataOut implements DataOut {
  private PrintWriter writer = null;

  public LocalFileDataOut(String path) {
    setPath(path);
  }

  @Override
  public void setPath(String path) {
    try {
      writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void write(Object data) {
    try {
      write(data.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 将数据字符串书写到文件中
   *
   * @param data 传入String类型的数据
   */
  @Override
  public void write(String data) {
    try {
      writer.println(data);
      writer.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 释放资源
   */
  @Override
  public void close() {
    if (writer != null) {
      try {
        writer.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
