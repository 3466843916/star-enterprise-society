package com.sxpi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxpi.model.dto.Login;
import com.sxpi.service.ZLoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author happy
 * @create 2025-02-19-{TIME}
 */
@Service
@Transactional

public class ZLoginServiceImpl implements ZLoginService {
    @Value("${my.appid}")
    private String appid;
    @Value("${my.secret}")
    private String secret;

    private final RestTemplate restTemplate = new RestTemplate();
    // 发送get请求
    private String sendGetRequest(String url) {
        return restTemplate.getForObject(url, String.class);
    }
    // 发送post请求
    private String sendPostRequest(String url, String code){
        RestTemplate restTemplate = new RestTemplate();

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // requestJson中填写微信的加密数据和偏移量
        String requestJson = "{\"code\":\""+code+"\"}";

        // 创建 HttpEntity 对象
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        // 发送POST请求，由于微信接口需要access_token，这里的ACCESS_TOKEN需要替换为你的实际的access_token
        return restTemplate.postForObject(url, entity, String.class);
    }

    /**
     * 获取手机号
     */
    public String getPhone(Login login){
        // 获取access_token
        String access_token = this.getAccessToken();

        // 获取手机号
        String url1 = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + access_token; // 要发送POST请求的URL
        System.out.println(url1);
        String responseData = this.sendPostRequest(url1, login.getCode());
        System.out.println("获取手机号返回的json数据===" + responseData);

        JSONObject jsonObject2 = JSON.parseObject(responseData);
        String phoneNumber = jsonObject2.getJSONObject("phone_info").getString("phoneNumber");
        System.out.println("获取的手机号===" + phoneNumber);

        return phoneNumber;
    }

    /**
     * 获取access_token
     */
    private String getAccessToken(){
        // 获取access_token
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret; // 要发送GET请求的URL
        System.out.println("appidaaaaaaaaa = " + appid);
        System.out.println("secretaaaaaaaa = " + secret);
        String json = this.sendGetRequest(url);
        System.out.println("返回的数据 = " + json);
        String access_token = JSON.parseObject(json).getString("access_token");
        System.out.println("获取access_token返回的数据 = " + JSON.parseObject(json));
        System.out.println("access_token===" + access_token);

        return access_token;
    }

    /**
     * 获取用户id openid
     */
    public String getOpenid(String openIdCode){
        String str = this.sendGetRequest("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + openIdCode + "&grant_type=authorization_code");
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println("获取openid返回的json数据 = " + jsonObject);
        String openid = jsonObject.getString("openid");
        System.out.println("openid = " + openid);
        return openid;
    }
}
