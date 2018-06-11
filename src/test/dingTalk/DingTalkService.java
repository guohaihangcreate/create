package test.dingTalk;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
public class DingTalkService {

	/**
     * accessToken
     * @param url
     * @param corpid
     * @param secret
     * @return
     */
    public static String getAccessToken(String url,String corpid,String secret){
        String requestUrl = url + "?corpid="+corpid+"&corpsecret="+secret;
        String result = HttpUtils.doGet(requestUrl);
        String accessToken = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject = JSON.parseObject(result);
        String msg = (String)jsonObject.get("errmsg");
        if("ok".equals(msg)){
            accessToken = (String)jsonObject.get("access_token");
        }
        return accessToken;
    }

    public static JSONArray getCardList(String accessToken, String workDateFrom, String workDateTo, String offset, String limit){
        String recordUrl = "https://oapi.dingtalk.com/attendance/list?access_token="+accessToken;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("workDateFrom",workDateFrom);
        jsonObject.put("workDateTo",workDateTo);
        jsonObject.put("offset",offset);
        jsonObject.put("limit",limit);
        String result = HttpUtils.doPost(recordUrl,jsonObject,"utf-8");
        JSONObject resutJSON = JSONObject.parseObject(result);
        String msg = (String)resutJSON.get("errmsg");
        JSONArray jsonArray = null;
        if("ok".equals(msg)){
            jsonArray = (JSONArray) resutJSON.get("recordresult");
        }
        return jsonArray;
    }
}
	
