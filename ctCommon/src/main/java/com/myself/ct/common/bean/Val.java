package com.myself.ct.common.bean;

/**
 * 值对象接口
 */
public interface Val {
  /**
   * 设置值对象
   *
   * @param value 设置值对象
   */
  void setValue(Object value);

  /**
   * 获取值对象
   *
   * @return 返回值对象
   */
  Object getValue();
}
