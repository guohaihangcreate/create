package test;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertity {
	
	 static Properties props = new Properties();
     static {
             try {
            	 	System.out.println(ReadPropertity.class.getClassLoader().getResourceAsStream(
                    "config/MailServer.properties"));
                     props.load(ReadPropertity.class.getClassLoader().getResourceAsStream(
                                     "config/MailServer.properties"));
                     props.load(ReadPropertity.class.getClassLoader().getResourceAsStream(
                     "config/createprop.properties"));
                     
                     props.load(ReadPropertity.class.getClassLoader().getResourceAsStream(
                     "config/dingtalk.properties"));
                     
             } catch (IOException e1) {
                     e1.printStackTrace();
             }
     }
     
     
     public static String getProperty(String key) {
             return props.getProperty(key);
     }
     
}
