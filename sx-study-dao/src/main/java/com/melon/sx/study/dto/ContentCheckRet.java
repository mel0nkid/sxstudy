package com.melon.sx.study.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 文本合规校验结果
 *
 * @author imelonkid
 * @date 2021/09/17 16:28
 **/
public class ContentCheckRet {

    /** 匹配结果 */
    private String conclusion;

    /** 命中结果 */
    private List<ContentCheckHit> contentCheckHits;


    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public List<ContentCheckHit> getContentCheckHits() {
        return contentCheckHits;
    }

    public void setContentCheckHits(List<ContentCheckHit> contentCheckHits) {
        this.contentCheckHits = contentCheckHits;
    }

    public static ContentCheckRet generateCheckRet(JSONObject jsonObject) {
        ContentCheckRet checkRet = new ContentCheckRet();
        checkRet.conclusion = jsonObject.getString("conclusion");
        List<ContentCheckHit> contentCheckHits = new ArrayList<>();
        checkRet.setContentCheckHits(contentCheckHits);
        JSONArray datas = jsonObject.getJSONArray("data");
        if (datas == null) {
            return checkRet;
        }

        Iterator<Object> datasIt = datas.iterator();
        while (datasIt.hasNext()) {
            ContentCheckHit contentCheckHit = new ContentCheckHit();
            contentCheckHits.add(contentCheckHit);
            JSONObject hitword = (JSONObject) datasIt.next();
            contentCheckHit.setMsg(hitword.getString("msg"));
            contentCheckHit.setConclusion(hitword.getString("conclusion"));
            JSONArray hits = hitword.getJSONArray("hits");

            Iterator<Object> hitsIt = hits.iterator();
            List<String> retWords = new ArrayList<>();
            contentCheckHit.setWords(retWords);
            while (hitsIt.hasNext()) {
                JSONArray words = ((JSONObject) hitsIt.next()).getJSONArray("words");
                if (words == null) {
                    continue;
                }

                Iterator<Object> wordsIt = words.iterator();
                while (wordsIt.hasNext()) {
                    retWords.add((String) wordsIt.next());
                }
            }
        }

        return checkRet;
    }
}
