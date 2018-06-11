package create.controller.hrm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import system.util.http.HttpUtils;
import test.ReadPropertity;
import test.dingTalk.DingTalkService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestAttendanceDetail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String corpid_ = null;
		String secret_= null;
		String sSOsecret_= null;
		String channelSecret_= null;
		String accessTokenUrl_= null;
		String access_token_= null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");//HH24小时表示方式，hh 12小时计时法
		//先测试柯锐特互动
		String companyId = "3";
//		柯锐特互动
//		修改完成以后同步更新修改钉钉中部门信息
		JSONObject resutJSON = null;
		if("3".equals(companyId)){
			corpid_ = ReadPropertity.getProperty("create_hd_corpid");
	        secret_ = ReadPropertity.getProperty("create_hd_secret");
	        sSOsecret_=ReadPropertity.getProperty("create_hd_SSOsecret");
	        channelSecret_=ReadPropertity.getProperty("create_hd_ChannelSecret");
		}
//		柯锐特信息技术
		if("1".equals(companyId)){
			corpid_ = ReadPropertity.getProperty("create_corpid");
	        secret_ = ReadPropertity.getProperty("create_secret");
	        sSOsecret_=ReadPropertity.getProperty("create_SSOsecret");
	        channelSecret_=ReadPropertity.getProperty("create_ChannelSecret");
		}
//		迅达在线
		if("6".equals(companyId)){
			corpid_ = ReadPropertity.getProperty("create_xd_corpid");
	        secret_ = ReadPropertity.getProperty("create_xd_secret");
	        sSOsecret_=ReadPropertity.getProperty("xd_SSOsecret");
	        channelSecret_=ReadPropertity.getProperty("xd_ChannelSecret");
		}
		accessTokenUrl_ = ReadPropertity.getProperty("accessTokenUrl");
//		Date currDate = new Date();
//		currDate.g
		Calendar calendar = Calendar.getInstance();  
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 24);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		//将毫秒至0  
		calendar.set(Calendar.MILLISECOND, 0);  
		//获得当前月第一天  
		Date sdate = calendar.getTime(); 
		Calendar cal = Calendar.getInstance();   
		cal.set(Calendar.HOUR_OF_DAY, 0);   
		cal.set(Calendar.SECOND, 0);   
		cal.set(Calendar.MINUTE, 0);   
		cal.set(Calendar.MILLISECOND, 0);
		Date ate = cal.getTime(); 
        access_token_ = DingTalkService.getAccessToken(accessTokenUrl_,corpid_,secret_);
        JSONObject jsonObject = new JSONObject();
        List userList = new ArrayList();
        userList.add("04671814372011");
        userList.add("083743602329078886");
        userList.add("02563655399819");
        userList.add("125656456221446360");
        jsonObject.put("userIds", userList);
        jsonObject.put("checkDateFrom", sdf.format(getStartTime()));
        jsonObject.put("checkDateTo", sdf.format(getnowEndTime()));
        String resultStr = HttpUtils.doPost("https://oapi.dingtalk.com/attendance/listRecord?access_token="+access_token_, jsonObject, "UTF-8");
        JSONObject json = JSONObject.parseObject(resultStr); 
        JSONArray jsonArray_ = (JSONArray) json.get("recordresult"); 
        JSONObject json__ = (JSONObject) jsonArray_.get(0);
        json__.getString("groupId");
//        "gmtModified": 1492594486000,
//        "isLegal": "N",
//        "baseCheckTime": 1492568460000,
//        "id": 933202551,
//        "userAddress": "北京市朝阳区崔各庄镇阿里中心.望京A座阿里巴巴绿地中心",
//        "userId": "manager7078",
//        "checkType": "OnDuty",
//        "timeResult": "Normal",
//        "deviceId": "cb7ace07d52fe9be14f4d8bec5e1ba79",
//        "corpId": "ding7536bfee6fb1fa5a35c2f4657eb6378f",
//        "sourceType": "USER",
//        "workDate": 1492531200000,
//        "planCheckTime": 1492568497000,
//        "gmtCreate": 1492594486000,
//        "locationMethod": "MAP",
//        "locationResult": "Outside",
//        "userLongitude": 116.486888,
//        "planId": 4550269081,
//        "groupId": 121325603,
//        "userAccuracy": 65,
//        "userCheckTime": 1492568497000,
//        "userLatitude": 39.999946,
//        "procInstId": "cb992267-9b70"
        
	}
	
	public static Date getStartTime() {  
        Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
    }  
	
	public static Date getnowEndTime() {  
        Calendar todayEnd = Calendar.getInstance();  
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
        todayEnd.set(Calendar.MINUTE, 59);  
        todayEnd.set(Calendar.SECOND, 59);  
        todayEnd.set(Calendar.MILLISECOND, 999);  
        return todayEnd.getTime();  
    } 

}
