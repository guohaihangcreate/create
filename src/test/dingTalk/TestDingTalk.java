package test.dingTalk;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.util.UtilCommon;
import system.util.http.HttpUtils;

import com.alibaba.fastjson.JSONObject;

import create.controller.core.SynDingTalk;
public class TestDingTalk {

	public static void main(String[] args) throws ParseException {
//		HttpUtils httpUtils = new HttpUtils();
//        String workDateFrom = "2017-11-03 08:00:00";
//        String workDateTo = "2017-11-03 18:00:00";
//        String offset = "0";//分页获取数据，0表示第一页
//        String limit = "10";//每页10条数据
//        String accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
//        String create_hd_corpid = ReadPropertity.getProperty("create_hd_corpid");
//        String create_hd_secret = ReadPropertity.getProperty("create_hd_secret");
//		String[] companyIDs = {"3","6","1"};
//		for(String companyId:companyIDs){
//			SynDingTalk sdt = new SynDingTalk();
//			String access_token = sdt.getAccess_tokenBycorpId(companyId);
//		     JSONObject jsonObject = new JSONObject();
//		        List userList = new ArrayList();
//		        userList.add("04671814372011");
//		        userList.add("083743602329078886");
//		        userList.add("07031028218333");
//		        userList.add("07031028205174");
////		        String[] userids = {"04671814372011","083743602329078886"};
//		        jsonObject.put("userIds", userList);
//		        jsonObject.put("checkDateFrom", "2107-12-05 00:00:00");
//		        jsonObject.put("checkDateTo", "2107-12-06 00:00:00");
//			    String attendance = HttpUtils.doPost("https://oapi.dingtalk.com/attendance/listRecord?access_token="+access_token, jsonObject, "UTF-8");
//			    System.out.println("全部考勤数据："+attendance);
//		}
//        String access_token = DingTalkService.getAccessToken(accessTokenUrl,create_hd_corpid,create_hd_secret);
        
//        String s = httpUtils.doGet("https://oapi.dingtalk.com/user/get?access_token="+access_token+"&userid=duanyucui");
////        System.out.println(s);
////        if(access_token!=null){
////            JSONArray jsonArray = DingTalkService.getCardList(access_token,workDateFrom,workDateTo,offset,limit);
////            System.out.println(jsonArray);
////        }
//        //获取考勤排班详情_start
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
//        SmartworkAttendsListscheduleRequest req = new SmartworkAttendsListscheduleRequest();
//        req.setWorkDate(sdf.parse("2017-12-27 11:11:11"));
//        req.setOffset(0L);
//        req.setSize(200L);
//        SmartworkAttendsListscheduleResponse rsp = null;
//		try {
//			rsp = client.execute(req, access_token);
//		} catch (ApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(rsp.getBody());
      //获取考勤排版详情——end
      //获取考勤组列表详情_start
//        DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
//        SmartworkAttendsGetsimplegroupsRequest req = new SmartworkAttendsGetsimplegroupsRequest();
//        req.setOffset(0L);
//        req.setSize(10L);
//        SmartworkAttendsGetsimplegroupsResponse rsp=null;
//		try {
//			rsp = client.execute(req, access_token);
//		} catch (ApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("考勤组列表详情："+rsp.getBody());
//      获取考勤组列表详情_end
//      考勤打卡记录_start
//        JSONObject jsonObject = new JSONObject();
//        List userList = new ArrayList();
//        userList.add("04671814372011");
//        userList.add("083743602329078886");
//        userList.add("07031028218333");
//        userList.add("07031028205174");
////        String[] userids = {"04671814372011","083743602329078886"};
//        jsonObject.put("userIds", userList);
//        jsonObject.put("checkDateFrom", "2107-12-05 00:00:00");
//        jsonObject.put("checkDateTo", "2107-12-06 00:00:00");
//	    String attendance = httpUtils.doPost("https://oapi.dingtalk.com/attendance/listRecord?access_token="+access_token, jsonObject, "UTF-8");
//	    System.out.println("全部考勤数据："+attendance);
//      考勤打卡记录_end
//      获取多个用户的签到记录_start
//        DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
//        SmartworkCheckinRecordGetRequest req = new SmartworkCheckinRecordGetRequest();
//        req.setUseridList("04671814372011,07031028218333,07031028205174,083743602329078886");
//        req.setStartTime(1494126861000L);
//        req.setEndTime(1495126861000L);
//        req.setCursor(0L);
//        req.setSize(100L);
//        SmartworkCheckinRecordGetResponse rsp=null;
//		try {
//			rsp = client.execute(req, access_token);
//		} catch (ApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(rsp.getBody());
//      获取多个用户的签到记录_end
//        
//        
//        
//      //创建人员
//        JSONObject jsonobject = new JSONObject();
//        jsonobject.put("userid", "55667788991");
//        jsonobject.put("name", "张三");
////        JSONObject jsonbject = new JSONObject();
////        jsonbject.put("22304827", "10");
////        jsonbject.put("22304826", "20");
////        jsonobject.put("orderInDepts", jsonbject);
//        List lis = new ArrayList();
//        lis.add(22304827);
////        lis.add(22304826);
//        jsonobject.put("department", lis);
//        jsonobject.put("position", "hr总监");
//        jsonobject.put("mobile", "13811545786");
//        jsonobject.put("tel", "010-89760030——26");
//        jsonobject.put("email", "zhangsan@gzdev.com");
//        jsonobject.put("isHide", "false");
//        jsonobject.put("jobnumber", "111111");
//        jsonobject.put("isSenior", "false");
//        JSONObject jsonject = new JSONObject();
//        jsonject.put("爱好", "旅游");
//        jsonject.put("年龄", "24");
//        String jsonString = httpUtils.doPost("https://oapi.dingtalk.com/user/create?access_token="+access_token, jsonobject, "UTF-8");
//        System.out.println(jsonString);
//        String sDingTalk = httpUtils.doGet("https://oapi.dingtalk.com/department/list?access_token="+access_token);
//        
//        System.out.println(sDingTalk);
		
		Date workDate = UtilCommon.longToDate(1517500800000l);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(workDate));
        
    }
	
}
