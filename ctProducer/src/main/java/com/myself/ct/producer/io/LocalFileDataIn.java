package com.myself.ct.producer.io;

import com.myself.ct.common.bean.Data;
import com.myself.ct.common.bean.DataIn;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 本地文件数据输入
 */
public class LocalFileDataIn implements DataIn {
  private BufferedReader reader = null;

  public LocalFileDataIn(String path) {
    setPath(path);
  }

  @Override
  public void setPath(String path) {
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object read() throws IOException {
    return null;
  }

  /**
   * 读取数据，返回数据集合
   *
   * @param clazz 传入对象
   * @param <T>   对象约束
   * @return 返回集合对象
   */
  @Override
  public <T extends Data> List<T> read(Class<T> clazz) {
    List<T> ts = new ArrayList<>();
    // 从数据文件中读取所以数据
    String line = null;
    try {
      while (null != (line = reader.readLine())) {
        // 将数据转换为指定类型的对象，封装为集合返回
        T t = clazz.newInstance();
        t.setValue(line);
        ts.add(t);
      }
    } catch (IOException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return ts;
  }

  /**
   * 关闭资源
   */
  @Override
  public void close() {
    if (null != reader) {
      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
