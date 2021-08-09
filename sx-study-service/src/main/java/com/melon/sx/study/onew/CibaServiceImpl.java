/**
 * 金山词霸服务实现类
 *
 * MelonKid.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.melon.sx.study.onew;

import cn.melonkid.commons.lang.parser.JSONUtil;
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
    public CibaOwRet get(String date) {
        // 远程调用，获取每日一言
        String result = HttpUtil.doGet(ciBaApi + date);
        CibaOwRet cibaOwRet = JSONUtil.fromJSON(result, CibaOwRet.class);
        // 设置日期
        cibaOwRet.setDateline(date);

        // 对每日一言进行拼音注释
        cibaOwRet.generatePinyin();
        return cibaOwRet;
    }
}