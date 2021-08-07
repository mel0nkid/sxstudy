/** MelonKid. Copyright (c) 2004-2019 All Rights Reserved. */
package com.melon.sx.study.onew;

import com.melon.sx.study.util.PinyinUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author melonkid
 * @version $Id: CibaOwRet.java, v 0.1 2019年12月05日 13:41 melonkid Exp $
 */
public class CibaOwRet {
  /** 音频 */
  private String tts;

  private String content;

  private String note;

  private String translation;

  private String picture;

  private String picture2;

  private String dateline;

  private String pinyin;

  private String noteWithPinyin;

  /**
   * Getter method for property <tt>tts</tt>.
   *
   * @return property value of tts
   */
  public String getTts() {
    return tts;
  }

  /**
   * Setter method for property <tt>tts</tt>.
   *
   * @param tts value to be assigned to property tts
   */
  public void setTts(String tts) {
    this.tts = tts;
  }

  /**
   * Getter method for property <tt>content</tt>.
   *
   * @return property value of content
   */
  public String getContent() {
    return content;
  }

  /**
   * Setter method for property <tt>content</tt>.
   *
   * @param content value to be assigned to property content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Getter method for property <tt>note</tt>.
   *
   * @return property value of note
   */
  public String getNote() {
    return note;
  }

  /**
   * Setter method for property <tt>note</tt>.
   *
   * @param note value to be assigned to property note
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * Getter method for property <tt>translation</tt>.
   *
   * @return property value of translation
   */
  public String getTranslation() {
    return translation;
  }

  /**
   * Setter method for property <tt>translation</tt>.
   *
   * @param translation value to be assigned to property translation
   */
  public void setTranslation(String translation) {
    this.translation = translation;
  }

  /**
   * Getter method for property <tt>picture</tt>.
   *
   * @return property value of picture
   */
  public String getPicture() {
    return picture;
  }

  /**
   * Setter method for property <tt>picture</tt>.
   *
   * @param picture value to be assigned to property picture
   */
  public void setPicture(String picture) {
    this.picture = picture;
  }

  /**
   * Getter method for property <tt>picture2</tt>.
   *
   * @return property value of picture2
   */
  public String getPicture2() {
    return picture2;
  }

  /**
   * Setter method for property <tt>picture2</tt>.
   *
   * @param picture2 value to be assigned to property picture2
   */
  public void setPicture2(String picture2) {
    this.picture2 = picture2;
  }

  /**
   * Getter method for property <tt>dateline</tt>.
   *
   * @return property value of dateline
   */
  public String getDateline() {
    return dateline;
  }

  /**
   * Setter method for property <tt>dateline</tt>.
   *
   * @param dateline value to be assigned to property dateline
   */
  public void setDateline(String dateline) {
    this.dateline = dateline;
  }

  public String getPinyin() {
    return pinyin;
  }

  public void setPinyin(String pinyin) {
    this.pinyin = pinyin;
  }

  public String getNoteWithPinyin() {
    return noteWithPinyin;
  }

  public void setNoteWithPinyin(String noteWithPinyin) {
    this.noteWithPinyin = noteWithPinyin;
  }

  /** 设置拼音 */
  public void generatePinyin() {
    if (StringUtils.isBlank(this.note)) {
      return;
    }

    char[] charArr = this.note.toCharArray();
    this.pinyin = PinyinUtil.convert(this.note);

    StringBuilder mutiNotes = new StringBuilder();
    String[] pinyinArr = pinyin.trim().split(" ");
    for (int i = 0; i < charArr.length; i++) {
      mutiNotes.append(charArr[i]);
      if (PinyinUtil.isChineseWord(charArr[i])) {
        mutiNotes.append("(").append(pinyinArr[i]).append(")");
      }
    }

    this.noteWithPinyin = mutiNotes.toString();
  }
}
