package com.melon.sx.study.dto;

import java.util.List;

/**
 * 校验结果
 *
 * @author imelonkid
 * @date 2021/09/17 16:29
 **/
public class ContentCheckHit {

    /** 描述信息 */
    private String msg;

    /** 匹配结果 */
    private String conclusion;

    /** 命中文字 */
    private List<String> words;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
