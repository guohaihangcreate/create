package create.controller.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import system.util.Java2Word;

@Controller
@RequestMapping("/word")
public class DownLoadController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
    @RequestMapping(value = "/download",method = RequestMethod.POST)
    public void download(HttpServletRequest request,HttpServletResponse response){
        /**
         * 获取请求参数
         */
        // 获取应用的根路径
        String servletContextRealPath = request.getServletPath();
        // 获取模板文件
        File templateFile = new File(servletContextRealPath + "template/offer/offer_template_default.doc");
        ByteArrayOutputStream ostream = null;
        try {
            FileInputStream in = new FileInputStream(templateFile);
            HWPFDocument hwpfDocument = new HWPFDocument(in);
            // 替换读取到的 word 模板内容的指定字段
            Map<String,String> params = new HashMap<String,String>();
            params.put("$name$","安静");
            params.put("$gangwei$","UI设计师");
            Range range = hwpfDocument.getRange();
            for(Map.Entry<String,String> entry:params.entrySet()){
                range.replaceText(entry.getKey(),entry.getValue());
            }
            // 输出 word 内容文件流，提供下载

            // 随机生成一个文件名
            UUID randomUUID = UUID.randomUUID();
            String attachmentName = randomUUID.toString();
            ostream = new ByteArrayOutputStream();
            File zipFile=new File("D:\\12345678.doc");
            ByteArrayOutputStream byteOSZip = new ByteArrayOutputStream(4096);
            FileOutputStream fos2 = new FileOutputStream(zipFile);
            byteOSZip.writeTo(fos2);
            fos2.close();
            
            
            
            
            ServletOutputStream servletOS = response.getOutputStream();
            hwpfDocument.write(ostream);
            servletOS.write(ostream.toByteArray());
            servletOS.flush();
            servletOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        /**
         * 获取请求参数
         */
        // 获取模板文件
        File templateFile = new File("D:\\workspace\\create\\WebRoot\\template\\offer\\offer_template_default.doc");
        ByteArrayOutputStream ostream = null;
        try {
            FileInputStream in = new FileInputStream(templateFile);
            HWPFDocument hwpfDocument = new HWPFDocument(in);
            // 替换读取到的 word 模板内容的指定字段
            Map<String,String> params = new HashMap<String,String>();
            params.put("$name$","安静");
            params.put("$gangwei$","UI设计师");
            Range range = hwpfDocument.getRange();
            for(Map.Entry<String,String> entry:params.entrySet()){
                range.replaceText(entry.getKey(),entry.getValue());
            }
            // 输出 word 内容文件流，提供下载

            // 随机生成一个文件名
            UUID randomUUID = UUID.randomUUID();
            String attachmentName = randomUUID.toString();
            ostream = new ByteArrayOutputStream();
            File zipFile=new File("D:\\12345678.doc");
            ByteArrayOutputStream byteOSZip = new ByteArrayOutputStream(4096);
            FileOutputStream fos2 = new FileOutputStream(zipFile);
            byteOSZip.writeTo(fos2);
            fos2.close();
            hwpfDocument.write(ostream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}