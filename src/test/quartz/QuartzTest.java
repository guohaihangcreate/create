package test.quartz;


import java.io.Serializable;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

//import system.util.QuartzManager;

/**
 * @Description: 测试类
 * 
 * @ClassName: QuartzTest.java
 */
@Component(value="QuartzTest")
public class QuartzTest implements Serializable , Job{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 日志对象 */
	  private static final Logger LOG =  Logger.getLogger(QuartzTest.class);
	  
	  public void run() {
		    if (LOG.isInfoEnabled()) {
		      LOG.info("数据转换任务线程开始执行");
		    }
		    System.out.println("【系统启动】开始(每1秒输出一次)...");
		  }
	  @Test
    public void quartz() {
        try {
//            SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
//            Scheduler sche = gSchedulerFactory.getScheduler();
//            String job_name = "动态任务调度";
//            System.out.println("【系统启动】开始(每1秒输出一次)...");
//            QuartzManager.addJob(sche, job_name, QuartzJobExample.class, "0/1 * * * * ?");
//            Thread.sleep(3000);
//            System.out.println("【修改时间】开始(每2秒输出一次)...");
//            QuartzManager.modifyJobTime(sche, job_name, "10/2 * * * * ?");
//            Thread.sleep(4000);
//            System.out.println("【移除定时】开始...");
//            QuartzManager.removeJob(sche, job_name);
//            System.out.println("【移除定时】成功");
//            System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");
//            QuartzManager.addJob(sche, job_name, QuartzJobExample.class, "*/10 * * * * ?");
//            Thread.sleep(30000);
//            System.out.println("【移除定时】开始...");
//            QuartzManager.removeJob(sche, job_name);
            System.out.println("【移除定时】成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("我他妈终于进来了wss");
	}
}
