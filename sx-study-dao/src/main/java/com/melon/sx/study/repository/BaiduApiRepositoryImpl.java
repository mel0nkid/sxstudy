package com.melon.sx.study.repository;

import com.melon.sx.study.dao.BaiduApiDao;
import com.melon.sx.study.dto.ContentCheckRet;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * BaiduApiRespository
 *
 * @author imelonkid
 * @date 2021/09/17 17:32
 **/
@Repository
public class BaiduApiRepositoryImpl implements BaiduApiRepository {

    @Autowired
    private BaiduApiDao baiduApiDao;

    @Override
    public ContentCheckRet checkContent(String content) {
        JSONObject jsonObject = baiduApiDao.checkText(content);
        return ContentCheckRet.generateCheckRet(jsonObject);
    }
}
