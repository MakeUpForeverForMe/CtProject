package com.myself.ct.producer.bean;

import com.myself.ct.common.bean.Data;

/**
 * 联系人
 */
public class Contact extends Data {
  private String tell;
  private String name;

  public String getTell() {
    return tell;
  }

  public void setTell(String tell) {
    this.tell = tell;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setValue(Object value) {
    super.setValue(value);
    String[] values = super.getValue().split(" ");
    setTell(values[0]);
    setName(values[1]);
  }

  @Override
  public String toString() {
    return "Contact[ " + tell + " , " + name + " ]";
  }
}
