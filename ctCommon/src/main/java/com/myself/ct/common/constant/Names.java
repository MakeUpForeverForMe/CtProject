package com.myself.ct.common.constant;

import com.myself.ct.common.bean.Val;

/**
 * 名称常量枚举类
 */
public enum Names implements Val {
  NAMESPACE("ct");

  private String name;

  Names(String name) {
    this.name = name;
  }

  @Override
  public void setValue(Object value) {
    this.name = (String) value;
  }

  @Override
  public String getValue() {
    return this.name;
  }
}
