package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;

public class HwpeDoc_Util {
  
   @Test
   public void testWrite() throws Exception {
	 //随机数
		Random random = new Random();
		String filename =  "郭海航123" + "&&" + System.currentTimeMillis()
		+ String.valueOf(random.nextInt(10000))+".doc";
      String templatePath = "D:\\workspace\\create\\WebRoot\\template\\offer\\offer_template_default.doc";
      String htmlfile = "D:\\workspace\\create\\WebRoot\\sendedOffer\\"+filename;
      InputStream is = new FileInputStream(templatePath);
      HWPFDocument doc = new HWPFDocument(is);
      Range range = doc.getRange();
      //把range范围内的${reportDate}替换为当前的日期
      range.replaceText("${name}", "安静");
		range.replaceText("${gangwei}", "UI设计师");
		range.replaceText("${ruzhiDateTime}", "2015年10月23日 9:00:00");
		range.replaceText("${ruzhiDateTime1}", "2015年10月23日 10:00:00");
		range.replaceText("${rzlxr}", "张瑜");
		range.replaceText("${rzlxrmobil", "15801579188");
		range.replaceText("${syq}", "2");
		// 税前工资
		range.replaceText("${sqgz}", "8000");
		// 试用期工资
		range.replaceText("${syqgz}", "6400");
		// 转正以后工资
		range.replaceText("${zzhgz}", "8000");
		Date newDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月DD日");
		range.replaceText("${offersentdate}", sdf.format(newDate));
      OutputStream os = new FileOutputStream(htmlfile);
      //把doc输出到输出流中
      doc.write(os);
      this.closeStream(os);
      this.closeStream(is);
   }
   /*
    * poi倒出word
    */
	   public void writeWord(String docfile,String htmlfile,Map dateMap) throws Exception {
	      InputStream is = new FileInputStream(docfile);
	      HWPFDocument doc = new HWPFDocument(is);
	      Range range = doc.getRange();
	      //把range范围内的${reportDate}替换为当前的日期
	      range.replaceText("${name}", dateMap.get("name").toString());
	      range.replaceText("${gangwei}",dateMap.get("gangwei").toString());
		  range.replaceText("${bm}",dateMap.get("bm").toString());
			range.replaceText("${ruzhiDateTime}", dateMap.get("ruzhiDateTime").toString());
			range.replaceText("${ruzhiDateTime1}", dateMap.get("ruzhiDateTime1").toString());
			range.replaceText("${rzlxr}", dateMap.get("rzlxr").toString());
			range.replaceText("${rzlxrmobil}", dateMap.get("rzlxrmobil").toString());
			range.replaceText("${syq}", dateMap.get("syq").toString());
			// 税前工资
			range.replaceText("${sqgz}", dateMap.get("sqgz").toString());
			// 试用期工资
			range.replaceText("${syqgz}", dateMap.get("syqgz").toString());
			// 转正以后工资
			range.replaceText("${zzhgz}", dateMap.get("zzhgz").toString());
			Date newDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月DD日");
			range.replaceText("${offersentdate}", dateMap.get("offersentdate").toString());
			OutputStream os = new FileOutputStream(htmlfile);
	      //把doc输出到输出流中
	      doc.write(os);
	      this.closeStream(os);
	      this.closeStream(is);
	   }
  
   /**
    * 关闭输入流
    * @param is
    */
   private static void closeStream(InputStream is) {
      if (is != null) {
         try {
            is.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
 
   /**
    * 关闭输出流
    * @param os
    */
   private static void closeStream(OutputStream os) {
      if (os != null) {
         try {
            os.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
  
 
   public static void main(String[] args) throws Exception {
	   //随机数
		Random random = new Random();
		String filename =  "郭海航123" + "&&" + System.currentTimeMillis()
		+ String.valueOf(random.nextInt(10000))+".doc";
     String templatePath = "D:\\workspace\\create\\WebRoot\\template\\offer\\offer_template_default.doc";
     String htmlfile = "D:\\workspace\\create\\WebRoot\\sendedOffer\\"+filename;
     InputStream is = new FileInputStream(templatePath);
     HWPFDocument doc = new HWPFDocument(is);
     Range range = doc.getRange();
     //把range范围内的${reportDate}替换为当前的日期
     range.replaceText("${bm}", "项目部");
     range.replaceText("${name}", "安静");
	 range.replaceText("${gangwei}", "UI设计师");
	range.replaceText("${ruzhiDateTime}", "2015年10月23日 9:00:00");
	range.replaceText("${ruzhiDateTime1}", "2015年10月23日 10:00:00");
	range.replaceText("${rzlxr}", "张瑜");
	range.replaceText("${rzlxrmobil}", "15801579188");
	range.replaceText("${syq}", "2");
	// 税前工资
	range.replaceText("${sqgz}", "8000");
	// 试用期工资
	range.replaceText("${syqgz}", "6400");
	// 转正以后工资
	range.replaceText("${zzhgz}", "8000");
	Date newDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	range.replaceText("${offersentdate}", sdf.format(newDate));
     OutputStream os = null;
	try {
		os = new FileOutputStream(htmlfile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("打印测试信息");
     //把doc输出到输出流中
     doc.write(os);
     closeStream(os);
     closeStream(is);
	}
}