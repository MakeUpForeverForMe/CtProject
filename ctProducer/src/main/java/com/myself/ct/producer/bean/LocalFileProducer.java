package com.myself.ct.producer.bean;

import com.myself.ct.common.bean.DataIn;
import com.myself.ct.common.bean.DataOut;
import com.myself.ct.common.bean.Producer;

import java.io.IOException;
import java.util.List;

/**
 * 本地数据文件的生产者
 */
public class LocalFileProducer implements Producer {
  private DataIn in;
  private DataOut out;
  private volatile boolean flag = true;

  @Override
  public void setIn(DataIn in) {
    this.in = in;
  }

  @Override
  public void setOut(DataOut out) {
    this.out = out;
  }

  /**
   * 生产数据
   */
  @Override
  public void produce() {
    try {
      // 读取通讯录的数据
      List<Contact> contacts = in.read(Contact.class);

      for (Contact contact : contacts) {
        System.out.println(contact);
      }

//      while (flag) {
      // 从通讯录随机查找两个电话号码（主叫，被叫）

      // 生成随机的通话时间

      // 生成随机的通话时长

      // 生成通话记录

      // 将通话记录刷写道文件中

//      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 关闭生产者
   */
  @Override
  public void close() {
    if (null != in) {
      try {
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (null != out) {
      try {
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
