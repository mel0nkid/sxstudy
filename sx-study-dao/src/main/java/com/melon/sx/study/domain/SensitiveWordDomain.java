package com.melon.sx.study.domain;

/**
 * 敏感词
 *
 * @author imelonkid
 * @date 2021/09/17 21:34
 **/
public class SensitiveWordDomain {

    private int id;

    private String word;

    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SensitiveWordDomain{" + "id=" + id + ", word='" + word + '\'' + ", msg='" + msg
            + '\'' + '}';
    }
}
