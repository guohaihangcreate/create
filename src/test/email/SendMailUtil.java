package test.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import test.ReadPropertity;

public class SendMailUtil {

	private String host = ""; // smtp服务器
	private String from = ""; // 发件人地址
	private String to = ""; // 收件人地址
	private String affix = ""; // 附件地址
	private String affixName = ""; // 附件名称s
	private String user = ""; // 用户名
	private String pwd = ""; // 密码
	private String subject = ""; // 邮件标题

	public void setAddress(String from, String to, String subject) {
		this.from = from;
		this.to = to;
		this.subject = subject;
	}

	public void setAffix(String affix, String affixName) {
		this.affix = affix;
		this.affixName = affixName;
	}

	public void send(String host, String user, String pwd, String text) {
		this.host = host;
		this.user = user;
		this.pwd = pwd;

		Properties props = new Properties();

		// 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
		props.put("mail.smtp.host", host);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		props.put("mail.smtp.auth", "true");

		// 用刚刚设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);

		// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
		// 用（你可以在控制台（console)上看到发送邮件的过程）
		session.setDebug(true);

		// 用session为参数定义消息对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 加载发件人地址
			message.setFrom(new InternetAddress(from));
			// 加载收件人地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			// 加载标题
			message.setSubject(subject);

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();

			// 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setText(text);
			multipart.addBodyPart(contentPart);
			// 添加附件
			BodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(affix);
			// 添加附件的内容
			messageBodyPart.setDataHandler(new DataHandler(source));
			// 添加附件的标题
			// 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
			sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
			messageBodyPart.setFileName("=?GBK?B?"
					+ enc.encode(affixName.getBytes()) + "?=");
			multipart.addBodyPart(messageBodyPart);

			// 将multipart对象放到message中
			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			// 连接服务器的邮箱
			transport.connect(host, user, pwd);
			// 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * affix附件位置，affixTitle附件标题，emailTitle邮件标题 args[0]发件账户，args[1]发件密码
	 * receiveEmail收件地址 text 邮件正文
	 */
	public void sendOfferEmail(String affix, String affixTitle,
			String emailTitle, String receiveEmail, String args[], String text) {
		// smtp服务器
		String emailsmtp = ReadPropertity.getProperty("emailsmtp");
		// 发件邮件账户
		String emailaddress = "";
		// 发件账户密码
		String emailpass = "";

		if (args != null && args.length > 0) {
			emailaddress = args[0];
		} else {
			emailaddress = ReadPropertity.getProperty("emailaddress");
		}
		if (args != null && args.length > 0) {
			emailpass = args[1];
		} else {
			emailpass = ReadPropertity.getProperty("emailpass");
		}

		SendMailUtil cn = new SendMailUtil();
		// 设置发件人地址、收件人地址和邮件标题
		cn.setAddress(emailaddress, receiveEmail, emailTitle);
		// 设置要发送附件的位置和标题
		cn.setAffix(affix, affixTitle);
		// 设置smtp服务器以及邮箱的帐号和密码
//		 cn.send("smtp.mxhichina.com", "hr@xiangmu.ren", "AAaa1234");
		cn.send(emailsmtp, emailaddress, emailpass, text);

	}

	public static void main(String[] args) {

		SendMailUtil cn = new SendMailUtil();
		String affix = "D:\\workspace\\create\\WebRoot\\sendedOffer\\郭海航offer&&14531982775378517.doc";
		String affixTitle = "张庆丽offer.doc";
		String emailTitle = "项目经理郭海航的简历";
		String receiveEmail = "guohaihang0512@163.com";
		String[] arg = new String[2];
		arg[0] = "hr@xiangmu.ren";
		arg[1] = "AAaa1234";
		String text = "张庆利,\n   你好！\n很高兴您被我公司项目部聘用为Java开发工程师一职，现向您发送录取通知书，请您按offer上要求准备相应入职资料，希望您在新的公司有新的起点与收获。";
		cn.sendOfferEmail(affix, affixTitle, emailTitle, receiveEmail, arg,
				text);
	}
}