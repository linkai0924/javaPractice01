package leader.controller;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by linkai on 2017/3/3.
 */
public class DispatcherController {

    public JSONObject handleGetRequest(String requestHeader) {
        int index = requestHeader.indexOf("/?");
        if (index == -1) {
            System.out.println("GET参数是：" + "null");
        } else {
            int begin = requestHeader.indexOf("/?") + 2;
            int end = requestHeader.indexOf("HTTP/");
            String condition = requestHeader.substring(begin, end);
            System.out.println("GET参数是：" + condition);
        }
        return new JSONObject();
    }

    public JSONObject handlePostRequest(String requestHeader, BufferedReader bd) {
        try {
            //content-length
            int begin = requestHeader.indexOf("content-length") + "Content-Length:".length();
            String postParamterLength = requestHeader.substring(begin).trim();
            int contentLength = postParamterLength.length();
            StringBuilder sb = new StringBuilder();
            if (contentLength > 0) {
                for (int i = 0; i < contentLength; i++) {
                    sb.append((char) bd.read());
                }
                System.out.println("POST参数是：" + sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }
}
