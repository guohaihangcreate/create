package create.controller.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import system.Constants;
import system.util.UtilCommon;
import system.util.http.HttpUtils;
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
import create.model.hrm.AttendanceRercordAll;
import create.model.hrm.User;
import create.model.system.CompanyInfo;
import create.service.hrm.AttendanceAlasssettingService;
import create.service.hrm.AttendanceClassService;
import create.service.hrm.AttendanceClassTimesService;
import create.service.hrm.AttendanceGroupService;
import create.service.hrm.AttendanceGroupclassRefSercice;
import create.service.hrm.AttendanceRercordAllService;
import create.service.hrm.CompanyInfoService;
import create.service.hrm.UserService;

public class SynDingTalk {
	
protected final Logger logger = Logger.getLogger(this.getClass());
	
	private CompanyInfoService companyInfoService;
	

	String  corpid = "";
	String secret = "" ;
	String sSOsecret = "";
	String channelSecret = "";
	String accessTokenUrl ;
	String access_token ;

	String corpid_ = null;
	String secret_= null;
	String sSOsecret_= null;
	String channelSecret_= null;
	String accessTokenUrl_= null;
	String access_token_= null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");//HH24小时表示方式，hh 12小时计时法

	static SimpleDateFormat simpleDateFormate = null;

	private AttendanceClassTimesService attendanceClassTimesService;

	private AttendanceGroupclassRefSercice  attendanceGroupclassRefSercice;

	private AttendanceGroupService attendanceGroupService;

	private AttendanceAlasssettingService attendanceAlasssettingService;

	private AttendanceClassService attendanceClassService;

	private	AttendanceRercordAllService attendanceRercordAllService;

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AttendanceRercordAllService getAttendanceRercordAllService() {
		return attendanceRercordAllService;
	}
	@Autowired
	public void setAttendanceRercordAllService(
			AttendanceRercordAllService attendanceRercordAllService) {
		this.attendanceRercordAllService = attendanceRercordAllService;
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

	/*
	 * 获取钉钉考勤排期
	 * dateTime 格式 yyyy-MM-dd hh:mm:ss
	 */
	public void DingTalkAttendanceClassToCreate(String dateTime){
		simpleDateFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		SmartworkAttendsListscheduleRequest req = new SmartworkAttendsListscheduleRequest();
		try {
			req.setWorkDate(simpleDateFormate.parse(dateTime));
		} catch (Exception e) {
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
			if(!StringUtils.isEmpty(ReadPropertity.getProperty("create_xd_corpid"))){
				corpid = ReadPropertity.getProperty("create_xd_corpid").trim();
			}
			if(!StringUtils.isEmpty(ReadPropertity.getProperty("create_xd_secret"))){
				secret = ReadPropertity.getProperty("create_xd_secret").trim();
			}
			if(!StringUtils.isEmpty(ReadPropertity.getProperty("xd_SSOsecret"))){
				sSOsecret=ReadPropertity.getProperty("xd_SSOsecret").trim();
			}
			if(!StringUtils.isEmpty(ReadPropertity.getProperty("xd_ChannelSecret"))){
				channelSecret=ReadPropertity.getProperty("xd_ChannelSecret").trim();
			}
		}
		accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
		access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
		return access_token;
	}
/*
 * <Host/>里面的改成 autoDeploy="false" deployOnStartup="false" 这样就可以避免tomcat服务器中自启动导致quartz定时任务被触发两次。（当然还可以按需求修改，毕竟每个项目的需求都不尽相同。）
 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public  void synDingTalkAttendanceRecordDetail(){
		List<List> dingtalkQueryList = null;
		UtilCommon commonUtil = new UtilCommon();//工具类
		String checkDateFrom = sdf.format(commonUtil.getStartTime());
		String checkDateTo = sdf.format(commonUtil.getnowEndTime());
		List<CompanyInfo> companys = companyInfoService.selectCompanyByPropterty(null);
		for(CompanyInfo c:companys){
			dingtalkQueryList = new ArrayList();
			List userList = new ArrayList();
			List userList_1 = new ArrayList();
			List userList_2 = new ArrayList();
			List userList_3 = new ArrayList();
			List userList_4 = new ArrayList();
			//最多支持200员工
			Map paramMap = new HashMap();
			paramMap.put("companyId", c.getCompanyid());
			paramMap.put("status", 0);//查询在职人员
			List<User> userAllList = userService.pageListByParamMap(paramMap);
			for(User u:userAllList){
				if(!StringUtils.isEmpty(u.getDingtalkId())&&userList.size()<50){
					userList.add(u.getDingtalkId());
				}
				else if(!StringUtils.isEmpty(u.getDingtalkId())&&userList.size()>=50&&userList_1.size()<50){
					userList_1.add(u.getDingtalkId());
				}
				else if(!StringUtils.isEmpty(u.getDingtalkId())&&userList_1.size()>=50&&userList_2.size()<50){
					userList_2.add(u.getDingtalkId());
				}
				else if(!StringUtils.isEmpty(u.getDingtalkId())&&userList_2.size()>=50&&userList_3.size()<50){
					userList_3.add(u.getDingtalkId());
				}
				else if(!StringUtils.isEmpty(u.getDingtalkId())&&userList_3.size()>=50&&userList_4.size()<50){
					userList_4.add(u.getDingtalkId());
				}
			}
			if(userList.size()>0){
				dingtalkQueryList.add(userList);
			}
			if(userList_1.size()>0){
				dingtalkQueryList.add(userList_1);
			}
			if(userList_2.size()>0){
				dingtalkQueryList.add(userList_2);
			}
			if(userList_3.size()>0){
				dingtalkQueryList.add(userList_3);
			}
			if(userList_4.size()>0){
				dingtalkQueryList.add(userList_4);
			}
			for(List ulist:dingtalkQueryList){
				if(ulist!=null&&ulist.size()>0){
						insertDingTalkAttendanceRecordAll(ulist,checkDateFrom,checkDateTo,c.getCompanyid());
						dingtalkQueryList.removeAll(ulist);
					}
				}
			}
	}
	
	public  void insertDingTalkAttendanceRecordAll(List userList,String checkDateFrom,String checkDateTo,Integer companyId){
		access_token_ = getAccess_tokenBycorpId(String.valueOf(companyId));
		UtilCommon commonUtil = new UtilCommon();//工具类
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userIds", userList);
		jsonObject.put("checkDateFrom", checkDateFrom);
		jsonObject.put("checkDateTo", checkDateTo);
		String resultStr = HttpUtils.doPost("https://oapi.dingtalk.com/attendance/listRecord?access_token="+access_token_, jsonObject, "UTF-8");
		JSONObject resut = JSONObject.parseObject(resultStr);
		JSONArray jsonArray_ = (JSONArray) resut.get("recordresult");
		if(jsonArray_!=null&&jsonArray_.size()>0){
			for(int i=0;i<jsonArray_.size();i++){
				JSONObject resutJSO = (JSONObject) jsonArray_.get(i);
				//根据返回的数据类型 初始化兑现并且新增数据库
				AttendanceRercordAll attendanceRercordAll = new AttendanceRercordAll();
				attendanceRercordAll.setGroupid(resutJSO.getString("groupId"));
				attendanceRercordAll.setPlanid(resutJSO.getString("planId"));
				attendanceRercordAll.setUserid(resutJSO.getString("userId"));
				attendanceRercordAll.setChecktype(resutJSO.getString("checkType"));
				attendanceRercordAll.setSourcetype(resutJSO.getString("sourceType"));
				attendanceRercordAll.setTimeresult(resutJSO.getString("timeResult"));
				attendanceRercordAll.setLocationresult(resutJSO.getString("locationResult"));
				attendanceRercordAll.setApproveid(resutJSO.getString("approveId"));
				attendanceRercordAll.setProcinstid(resutJSO.getString("procInstId"));
				attendanceRercordAll.setCompanyID(String.valueOf(companyId));
				if("Y".equals(resutJSO.getString("isLegal"))){
					attendanceRercordAll.setIslegal(1);//1位true，0位false
				}else{
					attendanceRercordAll.setIslegal(0);//1位true，0位false
				}
				attendanceRercordAll.setClassid(resutJSO.getString("classId"));
				attendanceRercordAll.setDeviceid(resutJSO.getString("deviceId"));
				attendanceRercordAll.setUseraddress(resutJSO.getString("userAddress"));
				attendanceRercordAll.setUserlongitude(resutJSO.getString("userLongitude"));
				attendanceRercordAll.setUseraccuracy(resutJSO.getString("userAccuracy"));
				attendanceRercordAll.setUserssid(resutJSO.getString("userSsid"));
				attendanceRercordAll.setUsermacaddr(resutJSO.getString("userMacAddr"));
				if(!StringUtils.isEmpty(resutJSO.getString("workDate"))){
					attendanceRercordAll.setWorkdate(sdf.format(commonUtil.longToDate(Long.valueOf(resutJSO.getString("workDate")))));
				}
				if(!StringUtils.isEmpty(resutJSO.getString("baseCheckTime"))){
					attendanceRercordAll.setBasechecktime(sdf.format(commonUtil.longToDate(Long.valueOf(resutJSO.getString("baseCheckTime")))));
				}
				if(!StringUtils.isEmpty(resutJSO.getString("userCheckTime"))){
					attendanceRercordAll.setUserchecktime(sdf.format(commonUtil.longToDate(Long.valueOf(resutJSO.getString("userCheckTime")))));
				}
				if(!StringUtils.isEmpty(resutJSO.getString("planCheckTime"))){
					attendanceRercordAll.setPlanchecktime(sdf.format(commonUtil.longToDate(Long.valueOf(resutJSO.getString("planCheckTime")))));
				}
				if(!StringUtils.isEmpty(resutJSO.getString("gmtCreate"))){
					attendanceRercordAll.setGmtcreate(sdf.format(commonUtil.longToDate(Long.valueOf(resutJSO.getString("gmtCreate")))));
				}
				if(!StringUtils.isEmpty(resutJSO.getString("gmtModified"))){
					attendanceRercordAll.setGmtmodified(sdf.format(commonUtil.longToDate(Long.valueOf(resutJSO.getString("gmtModified")))));
				}
				attendanceRercordAll.setBaseaddress(resutJSO.getString("baseAddress"));
				attendanceRercordAll.setBaselongitude(resutJSO.getString("baseLongitude"));
				attendanceRercordAll.setBaseaccuracy(resutJSO.getString("baseAccuracy"));
				attendanceRercordAll.setBasessid(resutJSO.getString("baseSsid"));
				attendanceRercordAll.setBasemacaddr(resutJSO.getString("baseMacAddr"));
				attendanceRercordAll.setOutsideremark(resutJSO.getString("outsideRemark"));
				attendanceRercordAllService.insertAttendanceRercordAllSelective(attendanceRercordAll);
			}
		}
	}
	
	
	/*
	 * 钉钉考勤设置同步到系统中
	 */
	@Test
	public  void synDingTalkAttendance(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");//HH24小时表示方式，hh 12小时计时法
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		SmartworkAttendsGetsimplegroupsRequest req = new SmartworkAttendsGetsimplegroupsRequest();
		req.setOffset(0L);
		req.setSize(10L);
		//先测试柯锐特互动
		String companyId = "3";
		access_token_ = getAccess_tokenBycorpId(companyId);
//		accessTokenUrl_ = ReadPropertity.getProperty("accessTokenUrl");
//		access_token_ = DingTalkService.getAccessToken(accessTokenUrl_,corpid_,secret_);
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
		JSONObject groupsJsonObject = (JSONObject) ((JSONObject) resultJsonObject.get("result")).get("groups");
		JSONArray groupjsonArray = (JSONArray) groupsJsonObject.get("at_group_for_top_vo");
		//考勤组json对象
		JSONObject groupjsonObject = null;
		AttendanceGroup agroup = null;
		JSONObject settingObject = null;
		for(int i=0;i<groupjsonArray.size();i++){
			groupjsonObject = groupjsonArray.getJSONObject(i);
			String classes_list = groupjsonObject.getString("classes_list");
			if(!StringUtils.isEmpty(classes_list)&&classes_list.indexOf("[")>0){
				classes_list = classes_list.substring(classes_list.indexOf("[")+1, classes_list.indexOf("]"));
			}
			agroup = new AttendanceGroup();//考勤组对象
			agroup.setYl3(classes_list);
			String type = groupjsonObject.getString("type");
			agroup.setType(type);
			if(StringUtils.isNotEmpty(groupjsonObject.getString("group_id"))){
				agroup.setGroupId(Integer.valueOf(groupjsonObject.getString("group_id")));
			}
			//添加错误信息到日志
			else{
				logger.error("钉钉同步考勤组Id is null!");
			}
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
				agroup.setYl1(yl1);
			}
			//考勤组下面员工人数存放在yl2中
			if(StringUtils.isNotEmpty(groupjsonObject.getString("member_count"))){
				agroup.setYl2(groupjsonObject.getString("member_count"));
			}
			//保存考勤组表 在增加前先查询数据库中是否存在，如果存在更新数据
			if(agroup.getGroupId()!=null){
				if(attendanceGroupService.serachAttendanceGroupByPK(agroup.getGroupId())!=null){
					attendanceGroupService.updateAttendanceGroupByPrimaryKeySelective(agroup);
				}else{
					attendanceGroupService.insertSelectiveAttendanceGroup(agroup);
				}
			}
			//考勤组和考勤班次关系表
			AttendanceGroupclassRef agroupRef = null;
			//考勤班次
			AttendanceClassTimes attendanceClassTimes = null;
			AttendanceAlasssetting attendanceAlasssetting = null;	
			AttendanceClass attendanceClass = null;
			/*
			 * 考勤组对应的考勤班次信息
			 */
			JSONArray jsonClassAarry = ((JSONObject) groupjsonObject.get("selected_class")).getJSONArray("at_class_vo");
			for(int j=0;j<jsonClassAarry.size();j++){
				//保存考勤组和班次对应的信息表
				agroupRef = new AttendanceGroupclassRef();
				if(StringUtils.isNotEmpty(groupjsonObject.getString("group_id"))){
					agroupRef.setGroupid(Integer.valueOf(groupjsonObject.getString("group_id")));
				}
				JSONObject classObject = (JSONObject) jsonClassAarry.get(j);
				String class_id = classObject.getString("class_id");
				//设置班次和考勤组的关系表
				if(StringUtils.isNotEmpty(class_id)){
					agroupRef.setClassid(Integer.valueOf(class_id));
				}
				/*
				 * 新增考勤组和考勤班次关系表，考勤组Id关联
				 */
				Map param = new HashMap();
				param.put("groupid", groupjsonObject.getString("group_id"));
				param.put("classid", class_id);
				List<AttendanceGroupclassRef> agroupReflist = attendanceGroupclassRefSercice.serachAttendanceGroupclassRefByProperty(param);
				if(agroupReflist!=null&&agroupReflist.size()>0){
					agroupRef.setGroupclassid(agroupReflist.get(0).getGroupclassid());//取出第一条数据的ID更新数据库
					attendanceGroupclassRefSercice.updateAttendanceGroupclassRefByPrimaryKeySelective(agroupRef);
				}else{
					attendanceGroupclassRefSercice.insertSelectiveAttendanceGroupclassRef(agroupRef);
				}
				attendanceClassTimes = new  AttendanceClassTimes();
				attendanceClass = new AttendanceClass();
				if(StringUtils.isNotEmpty(class_id)){
					//这是考勤排班信息
					attendanceClass.setClassid(class_id);
					attendanceClassTimes.setClassId(Integer.valueOf(class_id));
				}
				String class_name = classObject.getString("class_name");
				//这是考勤排班信息
				attendanceClass.setClassname(class_name);
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
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							try {
								attendanceClassTimes.setRestEndTime(sdf.parse(timesObject.getString("check_time")));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						/*
						 * 新增考勤班次时间设置信息  根据考勤班次查询是否在表中已经存在，存在的话更新即可或者不操作，不存在再新增
						 */
						Map param1 = new HashMap();
						param1.put("classId", class_id);
						List<AttendanceClassTimes> attendanceClassTimesList =  attendanceClassTimesService.serachAttendanceClassTimesByProperty(param1);
						if(attendanceClassTimesList!=null&&attendanceClassTimesList.size()>0){
							attendanceClassTimes.setId(attendanceClassTimesList.get(0).getId());//取第一条数据的id根据id更新数据库中数据
							attendanceClassTimesService.updateAttendanceClassTimesByPrimaryKeySelective(attendanceClassTimes);
						}else{
							attendanceClassTimesService.insertSelectiveAttendanceClassTimes(attendanceClassTimes);
						}
					}

				}
				/*
				 * 新增考勤班次信息  根据考勤班次查询是否在表中已经存在，存在的话更新即可，不存在再新增
				 */
				attendanceClass.setGroupid(String.valueOf(agroup.getGroupId()));
				AttendanceClass attendance_Class = attendanceClassService.serachAttendanceClassGroupByPK(Integer.valueOf(attendanceClass.getClassid()));
				if(attendance_Class!=null){
					attendanceClassService.updateAttendanceClassByPrimaryKeySelective(attendanceClass);
				}else{
					attendanceClassService.insertSelectiveAttendanceClass(attendanceClass);
				}
				settingObject = (JSONObject) classObject.get("setting");
			}
			attendanceAlasssetting = new AttendanceAlasssetting();
			//允许迟到时长，单位分钟
			attendanceAlasssetting.setClassId(attendanceClass.getClassid());
			int absenteeism_late_minutes = settingObject.getInteger("absenteeism_late_minutes");
			attendanceAlasssetting.setAbsenteeismLateMinutes(absenteeism_late_minutes);
			String class_setting_id = settingObject.getString("class_setting_id");//考勤班次ID
			attendanceAlasssetting.setClassSettingId(class_setting_id);
			String is_off_duty_free_check = settingObject.getString("is_off_duty_free_check");
			attendanceAlasssetting.setIsOffDutyFreeCheck(is_off_duty_free_check);//Y表示下班不强制打卡，N表示下班强制打卡
			attendanceAlasssetting.setPermitLateMinutes(settingObject.getInteger("permit_late_minutes"));//允许迟到时长，单位分钟
			attendanceAlasssetting.setSeriousLateMinutes(settingObject.getInteger("serious_late_minutes"));//严重迟到时长，单位分钟
			attendanceAlasssetting.setWorkTimeMinutes(settingObject.getInteger("work_time_minutes"));//工作时长，单位分钟，-1表示关闭该功能

			Map setMap = new HashMap();
			setMap.put("classId", attendanceClass.getClassid());
			List<AttendanceAlasssetting> attendanceAlasssettingList = attendanceAlasssettingService.serachAttendanceAlasssettingsByProperty(setMap);
			if(attendanceAlasssettingList!=null&&attendanceAlasssettingList.size()>0){
				attendanceAlasssetting.setId(attendanceAlasssettingList.get(0).getId());//获取第一条数据的id更新相关数据的数据库
				attendanceAlasssettingService.updateAttendanceAlasssettingByPrimaryKeySelective(attendanceAlasssetting);
			}else{
				attendanceAlasssettingService.insertSelectiveAttendanceAlasssetting(attendanceAlasssetting);//保存排班设置信息
			}
		}
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}
@Autowired
	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

}
