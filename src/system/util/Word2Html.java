package system.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;
 
/**
 * java将word转换为HTML
 * @author wu.85@163.com
 *
 */
public class Word2Html {
    private static final String DEFAULT_PICTURE_FOLDER = "pictures";//默认word中图片存放位置
    private static final String DEFAULT_HTML_TYPE = ".html";//默认转换的HTML文件后缀
 
    public static void main(String argv[]) {
        File outputFolder = null;
        File outputPictureFolder = null;
        try {
            //转换后HTML文件存放位置
            outputFolder = new File(Word2Html.class.getResource("").toURI());
            if (null != outputFolder) {
                //转换后原word中图片存放位置
                String outputPictureFolderPath = outputFolder.getAbsolutePath()
                        + File.separator + DEFAULT_PICTURE_FOLDER;
                outputPictureFolder = new File(outputPictureFolderPath);
                outputPictureFolder.mkdir();
            }
        } catch (URISyntaxException e1) {
 
        }
        try {
            //被转换的word文件
            File convertedWordFile = new File(
            		"C://Users//user//Desktop//郭海航.doc");
            convert2Html(convertedWordFile, outputFolder, outputPictureFolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("打印信息");
    }
 
    public static void writeFile(String content, String path) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "GBK"));
            bw.write(content);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
            }
        }
    }
 
    /**
     * 
     * @param wordFile 被转换的word文件
     * @param outputFolder 转换后HTML文件存放位置
     * @param outputPictureFolder 转换后原word中图片存放位置
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static void convert2Html(File wordFile, File outputFolder,
            final File outputPictureFolder) throws TransformerException,
            IOException, ParserConfigurationException {
        //创建被转换的word HWPFDocument对象
        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(wordFile));
         
        //创建word转换器，并设置对于图片如何处理
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content, PictureType pictureType,
                    String suggestedName, float widthInches, float heightInches) {
                return outputPictureFolder.getName() + File.separator
                        + suggestedName;
            }
        });
        //开始转换word为HTML
        wordToHtmlConverter.processDocument(wordDocument);
        //开始转换word中图片到图片存放目录
        List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();
        if (pics != null) {
            for (int i = 0; i < pics.size(); i++) {
                Picture pic = (Picture) pics.get(i);
                try {
                    pic.writeImageContent(new FileOutputStream(
                            outputPictureFolder.getAbsolutePath()
                                    + File.separator
                                    + pic.suggestFullFileName()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
         
        //将word转换为HTML，输出到指定目录
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);
 
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "GBK");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
        writeFile(new String(out.toByteArray()), outputFolder.getAbsolutePath()
                + File.separator + wordFile.getName() + DEFAULT_HTML_TYPE);
    }
}