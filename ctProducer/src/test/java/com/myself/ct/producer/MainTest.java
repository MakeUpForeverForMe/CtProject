package com.myself.ct.producer;

import com.myself.ct.common.util.NumberUtil;
import org.junit.Test;

import java.util.Random;

public class MainTest {
  @Test
  public void test1() {
    for (int i = 0; i < 10; i++) {
      System.out.println((int) (Math.random() * 5));
    }
  }

  @Test
  public void testRandom() {
    int max = 0;
    int min = 0;
    for (int i = 0; i < 50000; i++) {
      int k = new Random().nextInt(3000);
      max = Math.max(max, k);
      min = Math.min(min, k);
    }
    System.out.println("max = " + max + "\tmin = " + min);
  }

  @Test
  public void testFormat() {
    System.out.println(NumberUtil.format(10, 3));
  }
}
