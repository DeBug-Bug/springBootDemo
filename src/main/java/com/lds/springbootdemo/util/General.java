package com.lds.springbootdemo.util;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: repastSystem
 * @description: 通用工具类
 * @author:
 * @createData: 2019-06-23 12:39
 * @updateAuthor:
 * @updateData: 2019-06-23 12:39
 * @updateContent: 通用工具类
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */


public class General {
    // 返回时间
    public static String getTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    // 得到用户的ip地址
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    // 根据用户ip得到所在地址
    public static String getipAddress(HttpServletRequest request) {

        // 淘宝IP地址库：http://ip.taobao.com/instructions.php
        String add = null;
        String ip = getIp(request);
        try {
            // URL U = new
            // URL("http://ip.taobao.com/service/getIpInfo.php?ip=114.111.166.72");
            URL U = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="
                    + ip);
            URLConnection connection = U.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();
            JSONObject jsonObject = JSONObject.parseObject(result);
            Map<String, Object> map = (Map) jsonObject;
            String code = String.valueOf(map.get("code"));// 0：成功，1：失败。
            if ("1".equals(code)) {// 失败
                String data = String.valueOf(map.get("data"));// 错误信息
            } else if ("0".equals(code)) {// 成功
                Map<String, Object> data = (Map<String, Object>) map
                        .get("data");

                String country = String.valueOf(data.get("country"));// 国家
                String area = String.valueOf(data.get("area"));//
                String city = String.valueOf(data.get("city"));// 省（自治区或直辖市）
                String region = String.valueOf(data.get("region"));// 市（县）
                add = country + "-" + city + "-" + region;
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            add = "未联网";
        } catch (IOException e) {
            e.printStackTrace();
            add = "未联网";
        } catch(Exception e){
            e.printStackTrace();
            add="获取失败";
        }
        return add;
    }

    // 验证邮箱是否合法
    public static int chackEmail(String email) {
        if (email == null)
            return 0;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        if (m.matches())
            return 1;
        else
            return 0;

    }
    // 随机生成一个4位数字验证码
    public static String randomCode(){
        Random random=new Random();
        String code="";
        code=code+random.nextInt(9)+random.nextInt(9)
                +random.nextInt(9)+random.nextInt(9);
        return code;
    }
}
