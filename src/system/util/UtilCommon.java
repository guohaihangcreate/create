package system.util;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.springframework.expression.ParseException;

import create.model.hrm.User;
import create.model.system.Right;
import create.model.system.SysRole;
import create.model.tree.BaseTreeNode;
import create.model.tree.ITree;

public class UtilCommon {
	
	/*
	 * 时间比较方法，第一个字符串类型的参数大于第二个返回1，否则返回0
	 */
	public  static int timeCompare(String time1,String time2){
		DateFormat df = new SimpleDateFormat("HH:mm:ss");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd  
		 Date dt1 = null;
		 Date dt2 = null;
		try {
			dt1 = df.parse(time1);
			dt2 = df.parse(time2);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//将字符串转换为date类型  
	    if(dt1.getTime()>dt2.getTime())//比较时间大小,如果dt1大于dt2  
        {  
            return 1; 
        }  
        else  
        {  
            return 0;
        }  
	}
	
	/**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    public static String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
    //获取当前时间的0点0分0秒
    public static Date getStartTime() {  
        Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
    }  
	//获取当前时间的24点之前23点59分59秒
	public static Date getnowEndTime() {  
        Calendar todayEnd = Calendar.getInstance();  
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
        todayEnd.set(Calendar.MINUTE, 59);  
        todayEnd.set(Calendar.SECOND, 59);  
        todayEnd.set(Calendar.MILLISECOND, 999);  
        return todayEnd.getTime();  
    } 
	
	
	//获取当前时间的24点之前23点59分59秒
	public static Date longToDate(Long millis) {  
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
        return cal.getTime();  
    } 
	
	
	
	/*
	 * 删除重复元素，并保持顺序
	 * 
	 */
	@SuppressWarnings("unchecked")
	public   static   List  removeDuplicate(List list)   { 
	   for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )   { 
	    for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )   { 
	      if  (list.get(j).equals(list.get(i)))   { 
	        list.remove(j); 
	      } 
	    } 
	  } 
	  return list;
	} 
	
	/*
	 * auth_Mark权限标志
	 * 
	 */
	public static boolean checkAuthority(String auth_Mark,List<SysRole> currentRoles,Map authMap){
		boolean return_back=false;
		for(SysRole sr:currentRoles){
			List<Right> rights = (List<Right>) authMap.get(String.valueOf(sr.getRoleId()));
			if(rights!=null){
				for(Right r:rights){
					if(auth_Mark.equals(r.getTrMark())){
						return true;
					}
				}
			}
		}
		return return_back;
	}
	
	/*
	 * 得到本部門下的所有成員ID
	 * 
	 */
	public static String getDepartUserIDs(User user,List<User> allUsers){
		String return_back = "";
		for(User u:allUsers){
			if(user.getDepartid().equals(u.getDepartid())&&user.getCompanyId().equals(u.getCompanyId())){
				return_back+=u.getId()+",";
			}
		}
		return_back = return_back.substring(0, return_back.lastIndexOf(","));
		return return_back;
	}

	public static void reponse(HttpServletRequest request,
			HttpServletResponse response, Object msg) throws Exception {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(msg.toString());
		out.flush();
		out.close();
	}

	/**
	 * 字符串转换到时间格式
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param formatStr
	 *            需要格式的目标字符串 举例 yyyy-MM-dd
	 * @return Date 返回转换后的时间
	 * @throws ParseException
	 *             转换异常
	 */
	public static Date StringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
     * 日期转星期
     * 
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            try {
				datet = f.parse(datetime);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

	public static String getRoot(String treeId) {
		String s = "";
		// ITree treeDao = new TreeDAO();
		ITree treeDao = null;
		BaseTreeNode node = treeDao.get(new BaseTreeNode().setTreeId(treeId));
		s = "[";
		s += "{\"id\":\"" + node.getTreeId() + "\",\"name\":\""
				+ node.getTreeName() + "\",\"isParent\":" + node.isParent()
				+ "}";
		s = s.substring(0, s.length() - 1);
		s += "]";
		return s;
	}

	public static String getChild(String treeId) {
		String s = "[";
		// ITree treeDao = new TreeDAO();
		ITree treeDao = null;
		List<BaseTreeNode> children = treeDao.getChildTree(new BaseTreeNode()
				.setTreeId(treeId));
		for (BaseTreeNode node : children) {
			s += "{\"id\":\"" + node.getTreeId() + "\",\"name\":\""
					+ node.getTreeName() + "\",\"isParent\":" + node.isParent()
					+ "},";
		}
		s = s.substring(0, s.length() - 1);
		s += "]";
		return s;
	}

	public static void main(String[] args) {
		// SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar cal = Calendar.getInstance();
		// System.out.println("当前时间：" + sdft.format(cal.getTime()));
		// // 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		// cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// System.out.println("西方周日：" + sdft.format(cal.getTime()));
		//
		// // 增加一个星期，才是我们中国人理解的本周日的日期
		// cal.add(Calendar.WEEK_OF_YEAR, 2);
		// System.out.println("中国周日：" + sdft.format(cal.getTime()));
		// Calendar ca = Calendar.getInstance();
		// ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// ca.add(Calendar.WEEK_OF_YEAR, 2);
		// System.out.println("中国周一：" + sdft.format(ca.getTime()));
		// convertWeekByDate(new Date());
//		System.out.println(dateToWeek("2018-03-05 00:00:00"));
		first_endDayOfMonth();

	}

	public static String[] monday_sunday(Date time) {
		String[] monday_sunday = new String[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		String imptimeBegin = sdf.format(cal.getTime());
		// System.out.println("所在周星期一的日期：" + imptimeBegin);
		monday_sunday[0] = imptimeBegin;
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(cal.getTime());
		// System.out.println("所在周星期日的日期：" + imptimeEnd);
		monday_sunday[1] = imptimeEnd;
		return monday_sunday;

	}

	/*
	 * 获取本月第一天和当日和最后一天 第一个返回值为 本月第一天 第二个值为当前日期  第三个返回值为本月最后一天
	 */
	public static String[] first_endDayOfMonth() {
		String[] returndata = new String[3];
		String firstDay = "";
		String lastDay = "";
		String nowDay = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取前月的第一天
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		nowDay = format.format(cal_1.getTime());
		returndata[1]=nowDay;
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:" + firstDay);
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:" + lastDay);

		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		returndata[0] = first;
		System.out.println("===============first:" + first);

		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		returndata[2] = last;
		System.out.println("===============last:" + last);
		return returndata;
	}

	/*
	 * 获取给定时间的星期一和周日
	 */
	private static void convertWeekByDate(Date time) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		String imptimeBegin = sdf.format(cal.getTime());
		System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(cal.getTime());
		System.out.println("所在周星期日的日期：" + imptimeEnd);

	}
}