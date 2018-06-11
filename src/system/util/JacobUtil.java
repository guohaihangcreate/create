package system.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtil {

	// 8 代表word保存成html
	public static final int WORD_HTML = 8;

	/**
	 * word文档
	 */
	private Dispatch doc = null;

	private boolean saveOnExit;

	// **
	// *word运行程序对象
	// *
	private ActiveXComponent word;

	//	 
	// 所有word文档
	//
	private Dispatch documents;

	public static void main(String[] args) {

//		String docfile = "D:\\郭海航.doc";
//		String htmlfile = "D:\\郭海航.html";
//		JacobUtil.wordToHtml(docfile, htmlfile);

		String docfile = "D:\\guohaihang.doc";
		String htmlfile = "D:\\anjing1.doc";
		HashMap testMap = new HashMap();
		testMap.put("name", "安静");
		testMap.put("gangwei", "UI设计师");
		testMap.put("ruzhiDateTime", "2015年10月23日 9:00:00");
		testMap.put("ruzhiDateTime1", "2015年10月23日 10:00:00");
		testMap.put("rzlxr", "张瑜");
		testMap.put("rzlxr_mobil", "15801579188 ");
		testMap.put("syq", "2");
		testMap.put("sqgz", "8000");
		testMap.put("syqgz", "6400");
		testMap.put("zzhgz", "8000");
		testMap.put("offersentdate", "2016年 1月 04日");
		JacobUtil ut = new JacobUtil();
		ut.toWord(docfile, htmlfile, testMap);
	}

	/**
	 * WORD转HTML
	 * 
	 * @param docfile
	 *            WORD文件全路径
	 * @param htmlfile
	 *            转换后HTML存放路径
	 */
	public static void wordToHtml(String docfile, String htmlfile) {
		// 启动word应用程序(Microsoft Office Word 2003)
		ActiveXComponent app = new ActiveXComponent("Word.Application");
		System.out.println("*****正在转换...*****");
		try {
			// 设置word应用程序不可见
			app.setProperty("Visible", new Variant(false));
			// documents表示word程序的所有文档窗口，（word是多文档应用程序）
			Dispatch docs = app.getProperty("Documents").toDispatch();
			// 打开要转换的word文件
			Dispatch doc = Dispatch.invoke(
					docs,
					"Open",
					Dispatch.Method,
					new Object[] { docfile, new Variant(false),
							new Variant(true) }, new int[1]).toDispatch();
			// 作为html格式保存到临时文件
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
					htmlfile, new Variant(WORD_HTML) }, new int[1]);
			// 关闭word文件
			Dispatch.call(doc, "Close", new Variant(false));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭word应用程序
			app.invoke("Quit", new Variant[] {});
		}
		System.out.println("*****转换完毕********");
	}

	/**
	 * 打开文件
	 * 
	 * @param inputDoc
	 *            要打开的文件，全路径
	 * @return Dispatch 打开的文件
	 */
	public Dispatch open(String inputDoc) {
		return Dispatch.call(documents, "Open", inputDoc).toDispatch();
	}

	/**
	 * 选定内容
	 * 
	 * @return Dispatch 选定的范围或插入点
	 */
	public Dispatch select() {
		return word.getProperty("Selection").toDispatch();
	}

	/**
	 * 把插入点移动到文件首位置
	 * 
	 * @param selection
	 *            插入点
	 */
	public void moveStart(Dispatch selection) {
		Dispatch.call(selection, "HomeKey", new Variant(6));
	}

	/**
	 * 从选定内容或插入点开始查找文本
	 * 
	 * @param selection
	 *            选定内容
	 * @param toFindText
	 *            要查找的文本
	 * @return boolean true-查找到并选中该文本，false-未查找到文本
	 */
	public boolean find(Dispatch selection, String toFindText) {
		// 从selection所在位置开始查询
		Dispatch find = Dispatch.call(selection, "Find").toDispatch();
		// 设置要查找的内容
		Dispatch.put(find, "Text", toFindText);
		// 向前查找
		Dispatch.put(find, "Forward", "True");
		// 设置格式
		Dispatch.put(find, "Format", "True");
		// 大小写匹配
		Dispatch.put(find, "MatchCase", "True");
		// 全字匹配
		Dispatch.put(find, "MatchWholeWord", "True");
		// 查找并选中
		return Dispatch.call(find, "Execute").getBoolean();
	}

	/**
	 * 替换图片
	 * 
	 * @param selection
	 *            图片的插入点
	 * @param imagePath
	 *            图片文件（全路径）
	 */
	public void replaceImage(Dispatch selection, String imagePath) {
		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),
				"AddPicture", imagePath);
	}

	/**
	 * 把选定内容替换为设定文本
	 * 
	 * @param selection
	 *            选定内容
	 * @param newText
	 *            替换为文本
	 */
	public void replace(Dispatch selection, String newText) {
		// 设置替换文本
		Dispatch.put(selection, "Text", newText);
	}

	/**
	 * 替换表格
	 * 
	 * @param selection
	 *            插入点
	 * @param tableName
	 *            表格名称，形如table$1@1、table$2@1...table$R@N，R代表从表格中的第N行开始填充，
	 *            N代表word文件中的第N张表
	 * @param fields
	 *            表格中要替换的字段与数据的对应表
	 */
	public void replaceTable(Dispatch selection, String tableName, List dataList) {
		if (dataList.size() <= 1) {
			System.out.println("Empty table!");
			return;
		}
		// 要填充的列
		String[] cols = (String[]) dataList.get(0);
		// 表格序号
		String tbIndex = tableName.substring(tableName.lastIndexOf("@") + 1);
		// 从第几行开始填充
		int fromRow = Integer.parseInt(tableName.substring(tableName
				.lastIndexOf("$") + 1, tableName.lastIndexOf("@")));
		// 所有表格
		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
		// 要填充的表格
		Dispatch table = Dispatch.call(tables, "Item", new Variant(tbIndex))
				.toDispatch();
		// 表格的所有行
		Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
		// 填充表格
		for (int i = 1; i < dataList.size(); i++) {
			// 某一行数据
			String[] datas = (String[]) dataList.get(i);
			// 在表格中添加一行
			if (Dispatch.get(rows, "Count").getInt() < fromRow + i - 1)
				Dispatch.call(rows, "Add");
			// 填充该行的相关列
			for (int j = 0; j < datas.length; j++) {
				// 得到单元格
				Dispatch cell = Dispatch.call(table, "Cell",
						Integer.toString(fromRow + i - 1), cols[j])
						.toDispatch();
				// 选中单元格
				Dispatch.call(cell, "Select");
				// 设置格式
				Dispatch font = Dispatch.get(selection, "Font").toDispatch();
				Dispatch.put(font, "Bold", "0");
				Dispatch.put(font, "Italic", "0");
				// 输入数据
				Dispatch.put(selection, "Text", datas[j]);
			}
		}
	}

	/**
	 * 全局替换
	 * 
	 * @param selection
	 *            选定内容或起始插入点
	 * @param oldText
	 *            要替换的文本
	 * @param newText
	 *            替换为文本
	 */
	public void replaceAll(Dispatch selection, String oldText, Object replaceObj) {
		// 移动到文件开头
		moveStart(selection);
		if (oldText.startsWith("table") || replaceObj instanceof List) {
			replaceTable(selection, oldText, (List) replaceObj);
		} else {
			String newText = (String) replaceObj;
			if (oldText.indexOf("image") != -1
					|| newText.lastIndexOf(".bmp") != -1
					|| newText.lastIndexOf(".jpg") != -1
					|| newText.lastIndexOf(".gif") != -1)
				while (find(selection, oldText)) {
					replaceImage(selection, newText);
					Dispatch.call(selection, "MoveRight");
				}
			else
				while (find(selection, oldText)) {
					replace(selection, newText);
					Dispatch.call(selection, "MoveRight");
				}
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param outputPath
	 *            输出文件（包含路径）
	 */
	public void save(String outputPath) {
		Dispatch.call(Dispatch.call(word, "WordBasic").getDispatch(),
				"FileSaveAs", outputPath);
	}

	/**
	 * 关闭文件
	 * 
	 * @param document
	 *            要关闭的文件
	 */
	public void close(Dispatch doc) {
		Dispatch.call(doc, "Close", new Variant(saveOnExit));
	}

	/**
	 * 根据模板、数据生成word文件
	 * 
	 * @param inputPath
	 *            模板文件（包含路径）
	 * @param outPath
	 *            输出文件（包含路径）
	 * @param data
	 *            数据包（包含要填充的字段、对应的数据）
	 */
	public void toWord(String inputPath, String outPath, HashMap data) {
		System.out.println("开始转换offer");
		String oldText;
		Object newValue;
		try {
			doc = open(inputPath);
			Dispatch selection = select();
			Iterator keys = data.keySet().iterator();
			while (keys.hasNext()) {
				oldText = (String) keys.next();
				newValue = data.get(oldText);
				replaceAll(selection, oldText, newValue);
			}
			save(outPath);
		} catch (Exception e) {
			// debug.println("toword[Java2Word]------------操作word文件失败！"+e.getMessage(),true);

		} finally {
			if (doc != null)
				close(doc);
		}

		System.out.println("offer转换结束");
	}

}