package com.melon.sx.study.repository;

import com.melon.sx.study.dto.ContentCheckRet;

public interface BaiduApiRepository {

    ContentCheckRet checkContent(String content);
}
