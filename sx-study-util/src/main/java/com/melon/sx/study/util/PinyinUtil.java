package com.melon.sx.study.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author melonkid
 * @date 2021/8/4
 */
public class PinyinUtil {

  public static String convert(String hanzi) {
    // 输出格式设置
    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    /**
     * 输出大小写设置
     *
     * <p>LOWERCASE:输出小写 UPPERCASE:输出大写
     */
    format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

    /**
     * 输出音标设置
     *
     * <p>WITH_TONE_MARK:直接用音标符（必须设置WITH_U_UNICODE，否则会抛出异常） WITH_TONE_NUMBER：1-4数字表示音标
     * WITHOUT_TONE：没有音标
     */
    format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);

    /**
     * 特殊音标ü设置
     *
     * <p>WITH_V：用v表示ü WITH_U_AND_COLON：用"u:"表示ü WITH_U_UNICODE：直接用ü
     */
    format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

    char[] hanYuArr = hanzi.trim().toCharArray();
    StringBuilder pinYin = new StringBuilder();

    try {
      for (int i = 0, len = hanYuArr.length; i < len; i++) {
        // 匹配是否是汉字
        if (isChineseWord(hanYuArr[i])) {
          // 如果是多音字，返回多个拼音，这里只取第一个
          String[] pys = PinyinHelper.toHanyuPinyinStringArray(hanYuArr[i], format);
          pinYin.append(pys[0]).append(" ");
        } else {
          pinYin.append(hanYuArr[i]).append(" ");
        }
      }
    } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
      badHanyuPinyinOutputFormatCombination.printStackTrace();
    }
    return pinYin.toString();
  }

  public static boolean isChineseWord(char word) {
    return Character.toString(word).matches("[\\u4E00-\\u9FA5]+");
  }

  public static String convertWord(char hanzi) {
    // 输出格式设置
    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    /**
     * 输出大小写设置
     *
     * <p>LOWERCASE:输出小写 UPPERCASE:输出大写
     */
    format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

    /**
     * 输出音标设置
     *
     * <p>WITH_TONE_MARK:直接用音标符（必须设置WITH_U_UNICODE，否则会抛出异常） WITH_TONE_NUMBER：1-4数字表示音标
     * WITHOUT_TONE：没有音标
     */
    format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);

    /**
     * 特殊音标ü设置
     *
     * <p>WITH_V：用v表示ü WITH_U_AND_COLON：用"u:"表示ü WITH_U_UNICODE：直接用ü
     */
    format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

    try {
      // 匹配是否是汉字
      if (Character.toString(hanzi).matches("[\\u4E00-\\u9FA5]+")) {
        // 如果是多音字，返回多个拼音，这里只取第一个
        String[] pys = PinyinHelper.toHanyuPinyinStringArray(hanzi, format);
        return pys[0];
      } else {
        return String.valueOf(hanzi);
      }
    } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
      badHanyuPinyinOutputFormatCombination.printStackTrace();
    }
    return String.valueOf(hanzi);
  }

  public static void main(String[] args) {
    String pinYin = convertWord('秋');
    System.out.println("秋水共长天一色全拼：" + pinYin);
  }
}
