package com.myself.ct.common.bean;

/**
 * 数据对象
 */
public abstract class Data implements Val {
  private Object content;

  @Override
  public void setValue(Object value) {
    this.content = value;
  }

  @Override
  public Object getValue() {
    return this.content;
  }
}
