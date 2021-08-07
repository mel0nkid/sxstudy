package com.melon.sx.study.util;

/**
 * @author melonkid
 * @date 2021/8/4
 */
public class RandomUtil {

  /**
   * [from, to)
   *
   * @param from
   * @param to
   * @return
   */
  public static int rand(int from, int to) {
    return from + (int) (Math.random() * (to - from));
  }

  /**
   * [from, to]
   *
   * @param from
   * @param to
   * @return
   */
  public static int rand1(int from, int to) {
      return from + (int) (Math.random() * (to - from + 1));
  }

}
