package system.convert;
import system.convert.Doc2Html;
import system.convert.Docx2Html;
public class ConvertWordToHtml {
	/**
	 * 将word文档转换为html文件
	 * 例如：cwth("H:/test/", "34.docx", "H:/test/", "34.html");
	 * @param inPath
	 * @param inFileName
	 * @param outPath
	 * @param outFileName
	 * @throws Exception
	 * auth dean.wu
	 */
	public static void cwth(String inPath,String inFileName,String outPath,String outFileName) throws Exception{
		if(inFileName.endsWith(".docx") || inFileName.endsWith(".DOCX")){
			//07
			Docx2Html.convertDocxToHtml(inPath, inFileName, outPath, outFileName);
		}else{
			//03
			Doc2Html.convertDocToHtml(inPath, inFileName, outPath, outFileName);
		}
	}
	
	public static void main(String args[]) throws Exception{
		cwth("C://Users//user//Desktop//", "环境搭建.docx", "D:/", "3333.html");
	}
}
