package system.util.http;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import create.test.dingTalk.SSLClient;
import test.Main;

/**
 * http请求工具类
 * @author ghh
 */
import java.util.ArrayList;
import java.util.List;
public class HttpUtils {

	public static String doPost(String url, JSONObject jsonObject, String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
            StringEntity entity = new StringEntity(jsonObject.toString(),charset);
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

	private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc2c705d84eec52ed&secret=3a6e5c939072c88397741382db94191b";
	
    public static String doGet(String url){
        String result = null;
        HttpGet request = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result= EntityUtils.toString(response.getEntity(),"utf-8");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	
}
    
    public static void main(String[] args) {
    	System.out.println(doGet(ACCESS_TOKEN_URL));
	}

}
