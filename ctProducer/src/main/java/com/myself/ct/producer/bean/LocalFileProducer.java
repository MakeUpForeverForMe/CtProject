package com.myself.ct.producer.bean;

import com.myself.ct.common.bean.DataIn;
import com.myself.ct.common.bean.DataOut;
import com.myself.ct.common.bean.Producer;
import com.myself.ct.common.util.DateUtil;
import com.myself.ct.common.util.NumberUtil;

import java.io.IOException;
import java.util.Date;
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
      while (flag) {
        // 从通讯录随机查找两个电话号码（主叫，被叫）
        int call1index = (int) (Math.random() * contacts.size());
        int call2index;
        do {
          call2index = (int) (Math.random() * contacts.size());
        } while (call1index != call2index);
        Contact contact1 = contacts.get(call1index);
        Contact contact2 = contacts.get(call2index);

        // 生成随机的通话时间
        // 限定通话时间的范围
        String startDT = "20200101000000";
        String endDT = "20210101000000";
        // 通话时间的格式
        String dtFormat = "yyyyMMddHHmmss";
        // 通话时间的开始、结束时间（秒类型）
        long startTime = DateUtil.parse(startDT, dtFormat).getTime();
        long endTime = DateUtil.parse(endDT, dtFormat).getTime();
        // 通话开始时间（秒类型）
        long callTime = startTime + (long) ((endTime - startTime) * Math.random());
        // 通话时间字符串
        String callTimeString = DateUtil.format(new Date(callTime), dtFormat);

        // 生成随机的通话时长
        String duration = NumberUtil.format((int) (Math.random() * 3000), 4);

        // 生成通话记录
        CallLog callLog = new CallLog(contact1.getTell(), contact2.getTell(), callTimeString, duration);

        // 将通话记录刷写道文件中
        out.write(callLog);

        // 每秒钟生成两条数据
        Thread.sleep(500);
      }
    } catch (IOException | InterruptedException e) {
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
