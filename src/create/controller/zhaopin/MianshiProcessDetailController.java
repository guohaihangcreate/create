package create.controller.zhaopin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import system.HwpeDoc_Util;
import test.ReadPropertity;
import test.SendMailUtil;
import create.controller.core.BaseController;
import create.model.hrm.Payroll;
import create.model.hrm.User;
import create.model.waipai.Createoffer;
import create.model.waipai.InterviewRecord;
import create.model.waipai.JianLi;
import create.service.hrm.PayrollService;
import create.service.hrm.UserService;
import create.service.waipai.CreateOfferService;
import create.service.waipai.InterviewRecordService;
import create.service.waipai.JianliService;

@Controller
@RequestMapping("/mianshiProcessDetailController")
public class MianshiProcessDetailController extends BaseController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	private CreateOfferService createOfferService;

	private InterviewRecordService interviewRecordService;

	private Createoffer createoffer;

	private InterviewRecord interviewRecord;
//	薪酬福利service
	private PayrollService payrollService;
	
	private UserService userService;
	
	

	private JianliService jianliService;

	public JianliService getJianliService() {
		return jianliService;
	}

	@Autowired
	public void setJianliService(JianliService jianliService) {
		this.jianliService = jianliService;
	}

	@RequestMapping("/saveProcessDetail")
	public ModelAndView saveProcessDetail(Createoffer offer,
			InterviewRecord interviewRecord, String pId,HttpServletRequest request) throws Exception {
		// 测试
		Integer isdeleted = Integer.valueOf(0);
		Date deletetime = new Date();
		// createdby 缺省暂时不添加
		Date createtime = new Date();
		//添加补充面试邀请记录
		interviewRecord.setJiid(Integer.valueOf(pId));
		interviewRecord.setIsdeleted(isdeleted);
		interviewRecord.setCreatetime(createtime);
		User user = (User) request.getSession().getAttribute("user");
		interviewRecord.setAtt3(String.valueOf(user.getId()));
		//先查询邀请记录是否存在
		HashMap map = new HashMap();
		map.put("khid", interviewRecord.getKhid());
		map.put("jiid", interviewRecord.getJiid());
		map.put("msjg", interviewRecord.getMsjg());
		List<InterviewRecord> records = interviewRecordService.selectInterviewRecordsByParam(map);
		if(records!=null&&records.size()>0){
			System.out.println("已经存在该项纪录");
		}else{
			interviewRecordService.insertSelective(interviewRecord);
		}

		
		//面试通过，启动发送offer
		if(interviewRecord.getMsjg()==0&&"1".equals(interviewRecord.getAtt4())){
			//添加offer发送记录
			offer.setIsdeleted(isdeleted);
			offer.setCreatetime(createtime);
			// 设置预留字段1为简历Id
			offer.setAtt1(pId);
			if("1".equals(interviewRecord.getAtt4())){
				createOfferService.insertSelective(offer);
			}
			
			JianLi jl = jianliService.selectByPrimaryKey(Integer.valueOf(pId));
			Calendar c = Calendar.getInstance();//获得一个日历的实例
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			面试通过添加入职人员到人员表中，并且向薪酬福利表中增加
			User u = new User();
//			身份证信息
			String idNo_ = offer.getId_no();
			u.setIdno(idNo_);
			u.setStatus(0);
			String userName = jl.getJianliName().split("&")[0];
			u.setUsername(userName);
//			邮件
			String email =  interviewRecord.getEmail().split(";")[0];
			u.setEmail(email);
			//入职部门
			//电话号码
			String telephone = jl.getJianliName().split("&")[2];
			u.setMobile0(telephone);
			u.setMobile1(telephone);
			c.setTime(new Date());
			u.setCreatetime(c.getTime());
			u.setDepartid(offer.getRzbm());
			u.setDepartName(offer.getRzbm_str());
			u.setJobName(offer.getGw_str());
			u.setJobid(offer.getGw());
			HttpSession sessionMap = request.getSession(true);
			User new_user = (User)sessionMap.getAttribute("user");
			u.setCreateby(new_user.getId());
			//非内部人员，这个字段设置成驻场客户的ID
			u.setInternalstaff(offer.getKhid());
			userService.insertUser(u);
			
			Payroll payroll = new Payroll();
			//关联用户ID
			payroll.setUserid(u.getId());
			//试用期工资
			Integer  syqgz= offer.getSyqgz();
			payroll.setPeriodwage(Float.valueOf(syqgz));
			//转正以后的工资
			Integer  gz= offer.getSqgz();
			payroll.setWage(Float.valueOf(gz));
			//入职时间
			Date rzstartDatetime = offer.getRzstartDatetime();
			payroll.setEnterdate(rzstartDatetime);
			//获取转正时间
			
		    Date date =  offer.getRzstartDatetime();;
		    c.setTime(date);//设置日历时间
		    c.add(Calendar.MONTH,offer.getSyq());//在日历的月份上增加试用期月份
		    Date zztime = c.getTime();
		    payroll.setZzdate(zztime);
			payrollService.insertSelective(payroll);
			//添加薪酬福利结束
			
			// 生成offer并且发送相应的邮件
			String offerpath = createOffer(offer, jl);
			SendMailUtil sendMailUtil = new SendMailUtil();
			//interviewRecord.getAtt4()=1表示需要发送offer
			if("1".equals(interviewRecord.getAtt4())){
				Date newDate = new Date();
				SimpleDateFormat asd = new SimpleDateFormat("yyyymmdd");
				String affixTitle = jl.getJianliName().split("&")[0]
						+ asd.format(newDate) + ".doc";
				String emailTitle = "柯锐特录取通知书-" + affixTitle;
				String text = jl.getJianliName().split("&")[0] + "\n你好！\n很高兴您被我公司"
						+ offer.getRzbm_str() + "聘用为" + offer.getGw_str()
						+ "一职，现向您发送录取通知书，请您按offer上要求准备相应入职资料，希望您在新的公司有新的起点与收获。";
				String[] to = interviewRecord.getEmail().split(";");
				String[] cs = interviewRecord.getEmail_cc().split(";");
				String[] ms = interviewRecord.getEmail_mm().split(";");
				String[] fileList = { offerpath };
				sendMailUtil.send_(to, cs, ms, emailTitle, text, "hr@xiangmu.ren",
						fileList,"smtp.mxhichina.com","hr@xiangmu.ren", "AAaa1234");
			}
			
		}
		return new ModelAndView(
				"redirect:/mianshiYaoQingController/toAddYaoQing.go?pId=" + pId);
	}
	
	

	
	

	public String createOffer(Createoffer offer, JianLi jl) throws Exception {
		// 随机数
		Random random = new Random();
		String name = jl.getJianliName().split("&")[0] + "_offer";
		// 获取面试者的姓名
		String filename = name + "&&" + System.currentTimeMillis()
				+ String.valueOf(random.nextInt(10000)) + ".doc";
		String docfile = ReadPropertity.getProperty("docfile");
		String htmlfile = ReadPropertity.getProperty("htmlfile")+ filename;
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy年MM月dd日 HH时");
		HashMap testMap = new HashMap();
		String name_ = jl.getJianliName().split("&")[0];
		testMap.put("name", name_);
		testMap.put("bm", offer.getRzbm_str());
		testMap.put("gangwei", offer.getGw_str());
		String ruzhiDateTime = sdftime.format(offer.getRzstartDatetime());
		String ruzhiDateTime1 = sdftime.format(offer.getRzendDatetime());
		testMap.put("ruzhiDateTime", ruzhiDateTime);
		testMap.put("ruzhiDateTime1", ruzhiDateTime1);	
		testMap.put("rzlxr", offer.getLianxiren());
		testMap.put("rzlxrmobil", offer.getRzlxrtele());
		testMap.put("syq", offer.getSyq());
		// 税前工资
		testMap.put("sqgz", offer.getSqgz());
		// 试用期工资
		if(offer.getSqgz()!=null&&offer.getSyqgzbl()!=null){
			testMap.put("syqgz", Float.valueOf(offer.getSqgz())
					* Float.valueOf(offer.getSyqgzbl() / 100));
		}
		// 转正以后工资
		if(offer.getSqgz()!=null){
			testMap.put("zzhgz", offer.getSqgz());
		}
		Date newDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		testMap.put("offersentdate", sdf.format(newDate));
		HwpeDoc_Util doc_util= new HwpeDoc_Util();
		doc_util.writeWord(docfile, htmlfile, testMap);
		return htmlfile;
	}

	public CreateOfferService getCreateOfferService() {
		return createOfferService;
	}

	@Autowired
	public void setCreateOfferService(CreateOfferService createOfferService) {
		this.createOfferService = createOfferService;
	}

	public InterviewRecordService getInterviewRecordService() {
		return interviewRecordService;
	}

	@Autowired
	public void setInterviewRecordService(
			InterviewRecordService interviewRecordService) {
		this.interviewRecordService = interviewRecordService;
	}

	public PayrollService getPayrollService() {
		return payrollService;
	}
	@Autowired
	public void setPayrollService(PayrollService payrollService) {
		this.payrollService = payrollService;
	}

	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
