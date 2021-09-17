package com.melon.sx.study;

import com.melon.sx.study.dto.ContentCheckRet;

/**
 * ContentCensor
 *
 * @author imelonkid
 * @date 2021/09/17 12:06
 **/
public interface ContentCensorService {

    ContentCheckRet checkContent(String content);
}
