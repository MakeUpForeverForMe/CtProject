package com.myself.ct.producer;

import com.myself.ct.common.bean.Producer;
import com.myself.ct.producer.bean.LocalFileProducer;
import com.myself.ct.producer.io.LocalFileDataIn;
import com.myself.ct.producer.io.LocalFileDataOut;

/**
 * 启动对象
 */
public class BootStrap {
  public static void main(String[] args) throws Exception {
    // 构建生产者对象
    Producer producer = new LocalFileProducer();

    producer.setIn(new LocalFileDataIn("C:\\Users\\Forever\\Desktop\\code\\contact.log"));

    producer.setOut(new LocalFileDataOut("C:\\Users\\Forever\\Desktop\\code\\call.log"));
    // 生产数据
    producer.produce();
    // 关闭生产者对象
    producer.close();
  }
}
