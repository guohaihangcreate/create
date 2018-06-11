package create.controller.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.util.StringUtils;
import system.util.UtilCommon;
import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.report.AttendanceMonthReport;
import create.service.hrm.AttendanceRercordAllService;

@Controller
@RequestMapping("/attendanceReportController")
public class AttendanceReportController extends BaseController {

	private	AttendanceRercordAllService attendanceRercordAllService;

	public AttendanceRercordAllService getAttendanceRercordAllService() {
		return attendanceRercordAllService;
	}

	@Autowired
	public void setAttendanceRercordAllService(
			AttendanceRercordAllService attendanceRercordAllService) {
		this.attendanceRercordAllService = attendanceRercordAllService;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/attendanceMonthlyReport")
	public String attendanceMonthlyReport(HttpServletRequest request){
		List<AttendanceMonthReport> abnormalAttendanceMonthReportList = new ArrayList(); //异常考勤记录
		String departName = request.getParameter("departName");
		String userName = request.getParameter("userName");
		String status = request.getParameter("status");
		String workDate = request.getParameter("attendancDate");
		String abnormal = request.getParameter("abnormal");
		Map paramMap = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isEmpty(workDate)){
			paramMap.put("workDate", sdf.format(new Date()));
		}else{
			try {
				paramMap.put("workDate", workDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(!StringUtils.isEmpty(departName)){
			paramMap.put("departName", departName);
		}
		if(!StringUtils.isEmpty(userName)){
			paramMap.put("userName", userName);
		}
		if(!StringUtils.isEmpty(status)){
			paramMap.put("status", status);
		}else{
			paramMap.put("status", 0);//默认查询在职人员
		}
		request.setAttribute("attendancDate",paramMap.get("workDate"));
		request.setAttribute("departName", departName);
		request.setAttribute("attendancDateWeek", UtilCommon.dateToWeek(paramMap.get("workDate").toString()));
		String pageNow = request.getParameter("pageNow");
	
		// 获取总条数
		Long totalCount = attendanceRercordAllService.pageCounts(paramMap);
		HttpSession sessionMap = request.getSession(true);
		sessionMap.getAttribute("page");
		// 设置分页对象
		Page page = executePage(request, totalCount);
		// 设置分页页面信息
		paramMap.put("startIndex", page.getBeginIndex());//开始的位置
		paramMap.put("endIndex", page.getEveryPage());//每页显示条数
		List<AttendanceMonthReport> reportMonthList = attendanceRercordAllService.attendanceMonthlyReport(paramMap);
		if(page!=null){
			if(totalCount>(page.getEveryPage()*page.getCurrentPage())){
				page.setHasNextPage(true);
			}else{
				page.setHasNextPage(false);
			}
			// 如排序
			if (page.isSort()) {
				paramMap.put("orderName", page.getSortName());
				paramMap.put("descAsc", page.getSortState());
			} else {
				// 没有进行排序,默认排序方式
				paramMap.put("orderName", "age");
				paramMap.put("descAsc", "asc");
			}
		}
		request.setAttribute("page", page);
		//标记异常，并且构建检查异常的数据
		for(AttendanceMonthReport ar:reportMonthList){
			if(ar.getWorkDate()!=null){
				ar.setWorkDate(ar.getWorkDate()+" "+UtilCommon.dateToWeek(ar.getWorkDate()));
			}
			//判断打卡时间是否正常 ar.getCheckBeginTime() 大于 ar.getMixUserCheckTime()表示正常
			if(ar.getCheckBeginTime()!=null&&ar.getMixUserCheckTime()!=null){
				if((UtilCommon.timeCompare(ar.getCheckBeginTime(), ar.getMixUserCheckTime())==0)||ar.getMixUserCheckTime()==null){
					ar.setTimeResultBegin("异常");
					abnormalAttendanceMonthReportList.add(ar);//把异常记录保存
					ar.setColorTarget("1");
				}else{
					ar.setTimeResultBegin("正常");
				}
			}else{//考勤记录为空，直接标记异常
				ar.setTimeResultBegin("异常");
				abnormalAttendanceMonthReportList.add(ar);//把异常记录保存
				ar.setColorTarget("1");
			}
			if(ar.getCheckEndTime()!=null&&ar.getMaxuserCheckTime()!=null){
				if((UtilCommon.timeCompare(ar.getCheckEndTime(), ar.getMaxuserCheckTime())==1)||ar.getMaxuserCheckTime()==null){
					ar.setTimeResultEnd("异常");
					if(ar.getColorTarget()==null){//已经存在异常不需要重新添加
						abnormalAttendanceMonthReportList.add(ar);//把异常记录保存
					}
					ar.setColorTarget("1");
				}else{
					ar.setTimeResultEnd("正常");
				}
			}else{//考勤记录为空，直接标记异常
				ar.setTimeResultBegin("异常");
				if(ar.getColorTarget()==null){//已经存在异常不需要重新添加
					{
						abnormalAttendanceMonthReportList.add(ar);//把异常记录保存
					}
				}
				ar.setColorTarget("1");
			}
		}
		if(!StringUtils.isEmpty(abnormal)&&"1".equals(abnormal)){
			request.setAttribute("reportMonthList", abnormalAttendanceMonthReportList);
		}else{
			request.setAttribute("reportMonthList", reportMonthList);
		}
		return "/report/monthlyReport_List";
	}
}
