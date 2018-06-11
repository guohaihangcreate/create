package system.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobReplaceText {

	public static void main(String[] args) {
		String oldText = "13811545736";
		String newText = "1381****736";
		String filepath = "D:\\郭海航.doc";
		wordFindReplace(filepath,oldText,newText);
		}

	// 查找是否存在字符串，若存在则把要查找的字符串设置好。
	public static boolean find(Dispatch selection, String text) {
		Dispatch find = Dispatch.call(selection, "Find").toDispatch();
		Dispatch.put(find, "Text", text);// 设置要查找的文本
		Dispatch.put(find, "Forward", "True");// 向前找
		Dispatch.put(find, "Format", "True");// 设置格式
		Dispatch.put(find, "Matchcase", "True");// 大小写匹配
		Dispatch.put(find, "MatchWholeWord", "True");// 全字匹配
		return Dispatch.call(find, "Execute").getBoolean();// 查找并选中
	}

	// 全文替换,即文章中所有的字符串都被替换,去掉while则替换一次.
	public static void wordFindReplace(String wordpath, String oldtext,
			String newtext) {
		ActiveXComponent word = new ActiveXComponent("Word.Application");
		word.setProperty("Visible", new Variant(false));// 设置word不可见
		Dispatch docs = word.getProperty("Documents").toDispatch();
		Dispatch doc = Dispatch.call(docs, "Open", wordpath).toDispatch();// 打开word文件
		Dispatch selection = Dispatch.get(word, "Selection").toDispatch();// 选定范围或者插入点

		while (find(selection, oldtext))// 全文替换
		{
			Dispatch.put(selection, "Text", newtext);
			Dispatch.call(selection, "MoveRight");
		}
	}
	
	// 全文替换,即文章中所有的字符串都被替换,去掉while则替换一次.
	public static void wordFindReplaceAll(String wordpath,String alltest,
			String newtext,String newfilename) {
		
		ActiveXComponent word = new ActiveXComponent("Word.Application");
		word.setProperty("Visible", new Variant(true));// 设置word不可见
		Dispatch docs = word.getProperty("Documents").toDispatch();
		Dispatch doc = Dispatch.call(docs, "Open", wordpath).toDispatch();// 打开word文件
		Dispatch selection = Dispatch.get(word, "Selection").toDispatch();// 选定范围或者插入点

		String[] oldTexts = alltest.split("&");
		for(int i=0;i<oldTexts.length-1;i++){
			while (find(selection, oldTexts[i]))// 全文替换
			{
				Dispatch.put(selection, "Text", newtext);
				Dispatch.call(selection, "MoveRight");
			}
		}
		Dispatch.call(doc, "SaveAs", newfilename);
		
	}
	
}
