/**
 * MelonKid.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.melon.sx.study.onew;

import com.alibaba.fastjson.JSON;
import com.melon.sx.study.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author melonkid
 * @version $Id: CibaServiceImpl.java, v 0.1 2019年12月05日 13:44 melonkid Exp $
 */
@Service
@PropertySource("classpath:application.properties")
public class CibaServiceImpl implements CibaService {

    @Value("${onew.ciba.api}")
    private String ciBaApi;

    @Override
    public CibaOwRet get() {
        String result = HttpUtil.doGet(ciBaApi);
        CibaOwRet cibaOwRet = JSON.parseObject(result, CibaOwRet.class);
        cibaOwRet.generatePinyin();
        return cibaOwRet;
    }
}