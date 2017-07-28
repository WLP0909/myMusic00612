package util;

import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by WLP on 2017/7/11.
 */

public class AddressUtils {
         /*
         * 参数含义：
         *    dataURL       :访问的接口路径
         *    ip            ：ip地址
         *    encodingString:所访问接口规定的字符集编码
         */
         /*传入相关参数返回一个JSONObject组织的地址数据*/
    public String getAddress(String params, String encoding) throws Exception{
        String path = "http://ip.taobao.com/service/getIpInfo.php";
        String returnStr = this.getRs(path, params, encoding);
        JSONObject json=null;
        if(returnStr != null){
            json = new JSONObject(returnStr);
            if("0".equals(json.get("code").toString())){
                StringBuffer buffer = new StringBuffer();
                buffer.append(decodeUnicode(json.optJSONObject("data").getString("region")));//省份
                return buffer.toString();
            }else{
                return "获取地址失败�?";
            }
        }
        return null;
    }

    /*访问接口；接收返回数据*/
    public String getRs(String path, String params, String encoding){
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(path);
            connection = (HttpURLConnection)url.openConnection();// 新建连接实例
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫�?
            connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫�?
            connection.setDoInput(true);// 是否打开输出�? true|false
            connection.setDoOutput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(params);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),encoding));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine())!= null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connection.disconnect();// 关闭连接
        }
        return null;
    }

    /*如果没用JSONObject对象则可以通过这个方法进行对应字段unicode码转中文*/
    public static String decodeUnicode(String theString){
        char aChar;
        int len = theString.length();
        StringBuffer buffer = new StringBuffer(len);
        for (int i = 0; i < len;) {
            aChar = theString.charAt(i++);
            if(aChar == '\\'){
                aChar = theString.charAt(i++);
                if(aChar == 'u'){
                    int val = 0;
                    for(int j = 0; j < 4; j++){
                        aChar = theString.charAt(i++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                val = (val << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                val = (val << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                val = (val << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException( "Malformed      encoding.");
                        }
                    }
                    buffer.append((char) val);
                }else{
                    if(aChar == 't'){
                        aChar = '\t';
                    }
                    if(aChar == 'r'){
                        aChar = '\r';
                    }
                    if(aChar == 'n'){
                        aChar = '\n';
                    }
                    if(aChar == 'f'){
                        aChar = '\f';
                    }
                    buffer.append(aChar);
                }
            }else{
                buffer.append(aChar);
            }
        }
        return buffer.toString();
    }

    /*
      * 相关主要字段
      * {"country":"\u4e2d\u56fd",     国家      country
      * "country_id":"CN",
      * "area":"\u897f\u5357",         大地区   area
      * "area_id":"500000",
      * "region":"\u56db\u5ddd\u7701", 省份       region
      * "region_id":"510000",
      * "city":"\u6210\u90fd\u5e02",   城市       city
      * "city_id":"510100",
      * "county":"",                   市区       county
      * "county_id":"-1",
      * "isp":"\u7535\u4fe1",          网络(电信/网通/其他) isp
      * "isp_id":"100017",
      * "ip":"118.123.249.159"}
      * }
      */

    public static void main(String[] args) {
        AddressUtils addressUtils = new AddressUtils();
        String ip = "1.203.187.221";
        String address = "";
        try {
            address = addressUtils.getAddress("ip="+ip, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(address);
    }

}