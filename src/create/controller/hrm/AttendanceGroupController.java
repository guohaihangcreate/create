package create.controller.hrm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.Constants;
import test.ReadPropertity;
import test.dingTalk.DingTalkService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.SmartworkAttendsGetsimplegroupsRequest;
import com.dingtalk.api.request.SmartworkAttendsListscheduleRequest;
import com.dingtalk.api.response.SmartworkAttendsGetsimplegroupsResponse;
import com.dingtalk.api.response.SmartworkAttendsListscheduleResponse;
import com.taobao.api.ApiException;

import create.model.hrm.AttendanceAlasssetting;
import create.model.hrm.AttendanceClass;
import create.model.hrm.AttendanceClassTimes;
import create.model.hrm.AttendanceGroup;
import create.model.hrm.AttendanceGroupclassRef;
import create.model.hrm.Depart;
import create.service.hrm.AttendanceAlasssettingService;
import create.service.hrm.AttendanceClassService;
import create.service.hrm.AttendanceClassTimesService;
import create.service.hrm.AttendanceGroupService;
import create.service.hrm.AttendanceGroupclassRefSercice;
/*
 * 考勤组获取
 */
@Controller
@RequestMapping("/attendanceGroupController")
public class AttendanceGroupController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	String  corpid = "";
	String secret = "" ;
	String sSOsecret = "";
	String channelSecret = "";
	String accessTokenUrl ;
	String access_token ;
	
	static SimpleDateFormat simpleDateFormate = null;
	
	private AttendanceClassTimesService attendanceClassTimesService;

	private AttendanceGroupclassRefSercice  attendanceGroupclassRefSercice;
	
	private AttendanceGroupService attendanceGroupService;
	
	private AttendanceAlasssettingService attendanceAlasssettingService;
	
	private AttendanceClassService attendanceClassService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryAttendanceGroupList")
	public String queryAttendanceGroupList(AttendanceGroup attendanceGroup, HttpServletRequest request) {
		Map param = new HashMap();
		param.put("groupName", attendanceGroup.getGroupName());
		List<AttendanceGroup> attendanceGroupList= attendanceGroupService.serachAttendanceGroupsByProperty(param);
		request.setAttribute("attendanceGroupList", attendanceGroupList);
		return "hrm/attendanceGroupList";
	}
	
	/*
	 * 获取钉钉中考勤组
	 * dateTime 格式 yyyy-MM-dd hh:mm:ss
	 */
	public void DingTalkAttendanceGroupToCreate(String dateTime){
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		SmartworkAttendsGetsimplegroupsRequest req = new SmartworkAttendsGetsimplegroupsRequest();
		req.setOffset(0L);
		req.setSize(10L);
		String[] corpId_Array = Constants.corpId_Array;
		for(String companyId:corpId_Array){
			if(companyId!=null&&!"".equals(companyId)){
				access_token = getAccess_tokenBycorpId(companyId);
				SmartworkAttendsGetsimplegroupsResponse rsp=null;
				try {
					rsp = client.execute(req, access_token);
				} catch (ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JSONObject myJsonObject = JSONObject.parseObject(rsp.getBody());
				JSONObject jsonObject = JSONObject.parseObject(myJsonObject.get("dingtalk_smartwork_attends_getsimplegroups_response").toString());
				//是否有错误
				jsonObject.get("error_msg");
				JSONObject resultJsonObject = (JSONObject) jsonObject.get("result");
				resultJsonObject.get("group_id");
				resultJsonObject.get("is_default");
				resultJsonObject.get("group_name");
				System.out.println(rsp.getBody());
			}
		}
	}
	
	/*
	 * 获取钉钉考勤排期
	 * dateTime 格式 yyyy-MM-dd hh:mm:ss
	 */
	public void DingTalkAttendanceClassToCreate(String dateTime){
		simpleDateFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		SmartworkAttendsListscheduleRequest req = new SmartworkAttendsListscheduleRequest();
		try {
			req.setWorkDate(simpleDateFormate.parse(dateTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setOffset(0L);
		req.setSize(200L);
		String[] corpId_Array = Constants.corpId_Array;
		for(String companyId:corpId_Array){
			if(companyId!=null&&!"".equals(companyId)){
				access_token = getAccess_tokenBycorpId(companyId);
				SmartworkAttendsListscheduleResponse rsp=null;
				try {
					rsp = client.execute(req, access_token);
				} catch (ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(rsp.getBody());
			}
		}
	}
	
	
	public String getAccess_tokenBycorpId(String companyId){
		if("3".equals(companyId)){
			corpid = ReadPropertity.getProperty("create_hd_corpid");
	        secret = ReadPropertity.getProperty("create_hd_secret");
	        sSOsecret=ReadPropertity.getProperty("create_hd_SSOsecret");
	        channelSecret=ReadPropertity.getProperty("create_hd_ChannelSecret");
		}
//		柯锐特信息技术
		if("1".equals(companyId)){
			corpid = ReadPropertity.getProperty("create_corpid");
	        secret = ReadPropertity.getProperty("create_secret");
	        sSOsecret=ReadPropertity.getProperty("create_SSOsecret");
	        channelSecret=ReadPropertity.getProperty("create_ChannelSecret");
		}
//		迅达在线
		if("6".equals(companyId)){
			corpid = ReadPropertity.getProperty("create_xd_corpid");
	        secret = ReadPropertity.getProperty("create_xd_secret");
	        sSOsecret=ReadPropertity.getProperty("xd_SSOsecret");
	        channelSecret=ReadPropertity.getProperty("xd_ChannelSecret");
		}
		accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
        access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
        return access_token;
	}
	
	
	public static void main(String[] args) throws ParseException {
		String corpid_ = null;
		String secret_= null;
		String sSOsecret_= null;
		String channelSecret_= null;
		String accessTokenUrl_= null;
		String access_token_= null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		SmartworkAttendsGetsimplegroupsRequest req = new SmartworkAttendsGetsimplegroupsRequest();
		req.setOffset(0L);
		req.setSize(10L);
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
        access_token_ = DingTalkService.getAccessToken(accessTokenUrl_,corpid_,secret_);
        SmartworkAttendsGetsimplegroupsResponse rsp=null;
		try {
			rsp = client.execute(req, access_token_);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject myJsonObject = JSONObject.parseObject(rsp.getBody());
		JSONObject jsonObject = JSONObject.parseObject(myJsonObject.get("dingtalk_smartwork_attends_getsimplegroups_response").toString());
		//request_id
		jsonObject.get("request_id");
		JSONObject resultJsonObject = (JSONObject) jsonObject.get("result");
//		resultJsonObject.getJSONArray("result");
		JSONObject groupsJsonObject = (JSONObject) ((JSONObject) resultJsonObject.get("result")).get("groups");
		JSONArray groupjsonArray = (JSONArray) groupsJsonObject.get("at_group_for_top_vo");
		//考勤组json对象
		JSONObject groupjsonObject = null;
		for(int i=0;i<groupjsonArray.size();i++){
			groupjsonObject = groupjsonArray.getJSONObject(i);
			groupjsonObject.getString("type");
			String classes_list = groupjsonObject.getString("classes_list");
			if(!StringUtils.isEmpty(classes_list)&&classes_list.indexOf("[")>0){
				classes_list = classes_list.substring(classes_list.indexOf("[")+1, classes_list.indexOf("]"));
			}
			AttendanceGroup agroup = new AttendanceGroup();//考勤组对象
			agroup.setYl3(classes_list);
			if(StringUtils.isNotEmpty(groupjsonObject.getString("group_id"))){
				agroup.setGroupId(Integer.valueOf(groupjsonObject.getString("group_id")));
			}
			//添加错误信息到日志
//			else{
//				logger.error("钉钉同步考勤组Id is null!");
//			}
			if(StringUtils.isNotEmpty(groupjsonObject.getString("group_name"))){
				agroup.setGroupName(groupjsonObject.getString("group_name"));
			}
			if(StringUtils.isNotEmpty(groupjsonObject.getString("is_default"))){
				if(groupjsonObject.getBoolean("is_default")){
					agroup.setIsDefault(1);//是否为默认，默认为1非默认0
				}else{
					agroup.setIsDefault(0);//是否为默认，默认为1非默认0

				}
			}
			//管理员列表存放在yl1中
			if(StringUtils.isNotEmpty(groupjsonObject.getString("manager_list"))){
				String managerjsonString = groupjsonObject.getString("manager_list");
				String yl1 = null;
				if(managerjsonString.indexOf("[")>0){
					yl1 = managerjsonString.substring(managerjsonString.indexOf("[")+1, managerjsonString.indexOf("]"));
				}
				agroup.setYl2(yl1);
			}
			//考勤组下面员工人数存放在yl2中
			if(StringUtils.isNotEmpty(groupjsonObject.getString("member_count"))){
				agroup.setYl2(groupjsonObject.getString("member_count"));
			}
			//保存考勤组表
//			attendanceGroupService.insertSelectiveAttendanceGroup(agroup);
			//考勤组和考勤班次关系表
			AttendanceGroupclassRef agroupRef = new AttendanceGroupclassRef();
			if(StringUtils.isNotEmpty(groupjsonObject.getString("group_id"))){
				agroupRef.setGroupid(Integer.valueOf(groupjsonObject.getString("group_id")));
			}
			//考勤班次
			AttendanceClassTimes attendanceClassTimes =new  AttendanceClassTimes();
			AttendanceAlasssetting attendanceAlasssetting;			/*
			 * 考勤组对应的考勤班次信息
			 */
			JSONArray jsonClassAarry = ((JSONObject) groupjsonObject.get("selected_class")).getJSONArray("at_class_vo");
			for(int j=0;j<jsonClassAarry.size();j++){
				JSONObject classObject = (JSONObject) jsonClassAarry.get(j);
				String class_id = classObject.getString("class_id");
				//设置班次和考勤组的关系表
				if(StringUtils.isNotEmpty(class_id)){
					agroupRef.setClassid(Integer.valueOf(class_id));
				}
				//保存考勤组和班次对应的信息表
//				attendanceGroupclassRefSercice.insertSelectiveAttendanceGroupclassRef(agroupRef);
				
				if(StringUtils.isNotEmpty(class_id)){
					attendanceClassTimes.setClassId(Integer.valueOf(class_id));
				}
				String class_name = classObject.getString("class_name");
				attendanceClassTimes.setClassName(class_name);
				//班次打卡时间段
				JSONObject sectionsObject = (JSONObject) classObject.get("sections");
				JSONArray sectionsVoJSONArray = (JSONArray) sectionsObject.get("at_section_vo");
				for(int n=0;n<sectionsVoJSONArray.size();n++){
					JSONObject timesVoObject = (JSONObject) sectionsVoJSONArray.get(n);
					JSONObject times =  (JSONObject) timesVoObject.get("times");
					JSONArray time_voClassAarry = times.getJSONArray("at_time_vo");
					for(int h=0;h<time_voClassAarry.size();h++){
						JSONObject timesObject = (JSONObject) time_voClassAarry.get(h);
						timesObject.getString("across");//打卡时间跨度
						attendanceClassTimes.setCheckType(timesObject.getString("check_type"));
						//上班时间
						if("OnDuty".equals(timesObject.getString("check_type"))){
							try {
								attendanceClassTimes.setRestBeginTime(sdf.parse(timesObject.getString("check_time")));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							try {
								attendanceClassTimes.setRestEndTime(sdf.parse(timesObject.getString("check_time")));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				attendanceAlasssetting = new AttendanceAlasssetting();
				JSONObject settingObject = (JSONObject) classObject.get("setting");
				//允许迟到时长，单位分钟
				int absenteeism_late_minutes = settingObject.getInteger("absenteeism_late_minutes");
				attendanceAlasssetting.setAbsenteeismLateMinutes(absenteeism_late_minutes);
				String class_setting_id = settingObject.getString("class_setting_id");//考勤班次ID
				attendanceAlasssetting.setClassSettingId(class_setting_id);
				String is_off_duty_free_check = settingObject.getString("is_off_duty_free_check");
				attendanceAlasssetting.setIsOffDutyFreeCheck(is_off_duty_free_check);//Y表示下班不强制打卡，N表示下班强制打卡
				attendanceAlasssetting.setPermitLateMinutes(settingObject.getInteger("permit_late_minutes"));//允许迟到时长，单位分钟
				attendanceAlasssetting.setSeriousLateMinutes(settingObject.getInteger("serious_late_minutes"));//严重迟到时长，单位分钟
				attendanceAlasssetting.setWorkTimeMinutes(settingObject.getInteger("work_time_minutes"));//工作时长，单位分钟，-1表示关闭该功能
//				attendanceAlasssettingService.insertSelectiveAttendanceAlasssetting(attendanceAlasssetting);//保存排班设置信息
			}
		}
	
		
	
	
		
	}
	
	public AttendanceClassTimesService getAttendanceClassTimesService() {
		return attendanceClassTimesService;
	}
	@Autowired
	public void setAttendanceClassTimesService(
			AttendanceClassTimesService attendanceClassTimesService) {
		this.attendanceClassTimesService = attendanceClassTimesService;
	}

	public AttendanceGroupclassRefSercice getAttendanceGroupclassRefSercice() {
		return attendanceGroupclassRefSercice;
	}
	@Autowired
	public void setAttendanceGroupclassRefSercice(
			AttendanceGroupclassRefSercice attendanceGroupclassRefSercice) {
		this.attendanceGroupclassRefSercice = attendanceGroupclassRefSercice;
	}

	public AttendanceGroupService getAttendanceGroupService() {
		return attendanceGroupService;
	}
	@Autowired
	public void setAttendanceGroupService(
			AttendanceGroupService attendanceGroupService) {
		this.attendanceGroupService = attendanceGroupService;
	}

	public AttendanceAlasssettingService getAttendanceAlasssettingService() {
		return attendanceAlasssettingService;
	}
	@Autowired
	public void setAttendanceAlasssettingService(
			AttendanceAlasssettingService attendanceAlasssettingService) {
		this.attendanceAlasssettingService = attendanceAlasssettingService;
	}

	public AttendanceClassService getAttendanceClassService() {
		return attendanceClassService;
	}
	@Autowired
	public void setAttendanceClassService(
			AttendanceClassService attendanceClassService) {
		this.attendanceClassService = attendanceClassService;
	}



	
}
