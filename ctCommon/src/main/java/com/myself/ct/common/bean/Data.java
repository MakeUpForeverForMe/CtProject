package com.myself.ct.common.bean;

/**
 * 数据对象
 */
public abstract class Data implements Val {
  private String content;

  @Override
  public void setValue(Object value) {
    this.content = (String) value;
  }

  @Override
  public String getValue() {
    return this.content;
  }
}
