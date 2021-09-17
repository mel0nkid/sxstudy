package com.melon.sx.study.impl;

import com.melon.sx.study.ContentCensorService;
import com.melon.sx.study.dto.ContentCheckRet;
import com.melon.sx.study.repository.BaiduApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContentCensorService
 *
 * @author imelonkid
 * @date 2021/09/17 12:07
 **/
@Service
public class ContentCensorServiceImpl implements ContentCensorService {

    @Autowired
    private BaiduApiRepository baiduApiRepository;

    @Override
    public ContentCheckRet checkContent(String content) {
        return baiduApiRepository.checkContent(content);
    }
}
