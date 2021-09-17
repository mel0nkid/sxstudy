package com.melon.sx.study.dao;

import com.baidu.aip.contentcensor.AipContentCensor;
import javax.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

/**
 * 百度API
 *
 * @author imelonkid
 * @date 2021/09/17 16:50
 **/
@Repository
public class BaiduApiDao {

    //设置APPID/AK/SK
    public static final String APP_ID = "24863642";
    public static final String API_KEY = "Ljt93VZbph4m7ZxRuafdCHVl";
    public static final String SECRET_KEY = "K3zBCy8FO2Ei5GGfkE2yDsoG2d9WGpjN";

    private AipContentCensor client;

    @PostConstruct
    public void init() {
        client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //  System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
    }


    public JSONObject checkText(String text) {
        JSONObject jsonObject = client.textCensorUserDefined(text);
        return jsonObject;
    }
}
