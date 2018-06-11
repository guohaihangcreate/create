package system.util;   

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * �ṩ������ת����JSON�ַ����ķ���
 * @author       ���� ���ഺ
 * @version      �汾 0.01
 * @filename     �ļ��� JSONUtil.java
 * @date         �������� Oct 10, 2009
 * @description  ����
 */
public class JSONUtil {
  
 
 
/**
 * ��һ������ת����JSON�ַ�����ʾ���ö���Ӧ�÷��� JavaBean�淶��
 * ��������ĳ�����Բ������ֻ��ַ����������Խ������ԣ����������JSON�ַ�����
 * 
 * ��������:toJSON
 * ����:���ഺ
 * ��������:Oct 10, 2009
 * ��������:  
 * @param Ҫת���Ķ���
 * @return �����ö����JSON�ַ���������������������ֵ
 */ 
public static String toJSON(Object obj) {
HashMap<String, String> map = new HashMap<String, String>();
Class c = obj.getClass();
Field[] fields = c.getDeclaredFields();
for (int i = 0; i < fields.length; i++) {
String name = fields[i].getName();
try {
fields[i].setAccessible(true);
Object o = fields[i].get(obj);
if (o instanceof Number) {
map.put("\"" + name + "\"", o.toString());
} else if (o instanceof String) {
map.put("\"" + name + "\"", "\"" + o.toString() + "\"");
}
} catch (IllegalArgumentException e) {
} catch (IllegalAccessException e) {
}
}
String s = map.toString();
String str = s.replaceAll("\"=", "\":");
return str;
}
/**
 * ��һ����������ת����JSON�ַ���
 * ��������:toJSON
 * ����:���ഺ
 * ��������:Oct 10, 2009
 * ��������:  
 * @param Ҫת���Ķ�������
 * @return ת����õ����ַ���
 */
public static String toJSON(Object[] objs) {
String[] strs = new String[objs.length];
for (int i = 0; i < objs.length; i++) {
strs[i] = toJSON(objs[i]);
}
return toJSONArray(strs);
}
/**
 * �����JSON�ַ���ת����һ��JSON�ַ�����������һ����ʶ���ȵ�����length
 * ��������:toJSONArray
 * ����:���ഺ
 * ��������:Oct 10, 2009
 * ��������:  
 * @param  Ҫת���Ķ��JSON�ַ���
 * @return ������һ��JSON�ַ���
 */
public static String toJSONArray(String[] strs) {
StringBuffer sb = new StringBuffer();
sb.append("{");
for (int i = 0; i < strs.length; i++) {
sb.append("\"");
sb.append(i);
sb.append("\":");
sb.append(strs[i]);
sb.append(",");
}
sb.append("\"length\":");
sb.append(strs.length);
sb.append("}");
return sb.toString();
}
/**
    * ����
    * 
    * @param args
    */
@SuppressWarnings("unchecked")
public static void main(String[] args) {
User user = new User();
user.setId("1234");
user.setName("hahaha");
user.setAge(21);
User user1 = new User();
user1.setId("5767");
user1.setName("hehehe");
user1.setAge(18);
    
User[] users={user1,user};
System.out.println(JSONUtil.toJSON(users));
ArrayList list = new ArrayList();
list.add(user);
list.add(user1);
// System.out.println(JSON.toJSON(user));
System.out.println(JSONUtil.toJSON(list.toArray()));
}
}
/**
* �������Ե���
* 
* @author Bom Wu
* @create Mar 13, 2009
*/
class User {
private String name;
private String id;
private int age;
public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
}