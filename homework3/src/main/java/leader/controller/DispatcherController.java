package leader.controller;

/**
 * Created by linkai on 2017/3/3.
 */
public class DispatcherController {

    public void handleGetRequest(String requestHeader) {
        int index = requestHeader.indexOf("/?");
        if (index == -1) {
            System.out.println("GET参数是：" + "null");
        } else {
            int begin = requestHeader.indexOf("/?") + 2;
            int end = requestHeader.indexOf("HTTP/");
            String condition = requestHeader.substring(begin, end);
            System.out.println("GET参数是：" + condition);
        }
    }

    public void handlePostRequest(String requestHeader) {
        int begin = requestHeader.indexOf("Content-Lengh:") + "Content-Length:".length();
        String postParamterLength = requestHeader.substring(begin).trim();
        int contentLength = Integer.parseInt(postParamterLength);
        System.out.println("POST参数长度是：" + Integer.parseInt(postParamterLength));
//        StringBuilder sb = new StringBuilder();
//        if (contentLength > 0) {
//            for (int i = 0; i < contentLength; i++) {
//                sb.append((char) bd.read());
//            }
//            System.out.println("POST参数是：" + sb.toString());
//        }
    }
}
