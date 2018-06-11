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

	private String host = ""; // smtp������
	private String from = ""; // �����˵�ַ
	private String to = ""; // �ռ��˵�ַ
	private String affix = ""; // ������ַ
	private String affixName = ""; // ��������s
	private String user = ""; // �û���
	private String pwd = ""; // ����
	private String subject = ""; // �ʼ�����

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

		// ���÷����ʼ����ʼ������������ԣ�����ʹ�����׵�smtp��������
		props.put("mail.smtp.host", host);
		// ��Ҫ������Ȩ��Ҳ�����л����������У�飬��������ͨ����֤��һ��Ҫ����һ����
		props.put("mail.smtp.auth", "true");

		// �øո����úõ�props���󹹽�һ��session
		Session session = Session.getDefaultInstance(props);

		// ������������ڷ����ʼ��Ĺ�������console����ʾ������Ϣ��������ʹ
		// �ã�������ڿ���̨��console)�Ͽ��������ʼ��Ĺ��̣�
		session.setDebug(true);

		// ��sessionΪ����������Ϣ����
		MimeMessage message = new MimeMessage(session);
		try {
			// ���ط����˵�ַ
			message.setFrom(new InternetAddress(from));
			// �����ռ��˵�ַ
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			// ���ر���
			message.setSubject(subject);

			// ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
			Multipart multipart = new MimeMultipart();

			// �����ʼ����ı�����
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setText(text);
			multipart.addBodyPart(contentPart);
			// ��Ӹ���
			BodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(affix);
			// ��Ӹ���������
			messageBodyPart.setDataHandler(new DataHandler(source));
			// ��Ӹ����ı���
			// �������Ҫ��ͨ�������Base64�����ת�����Ա�֤������ĸ����������ڷ���ʱ����������
			sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
			messageBodyPart.setFileName("=?GBK?B?"
					+ enc.encode(affixName.getBytes()) + "?=");
			multipart.addBodyPart(messageBodyPart);

			// ��multipart����ŵ�message��
			message.setContent(multipart);
			// �����ʼ�
			message.saveChanges();
			// �����ʼ�
			Transport transport = session.getTransport("smtp");
			// ���ӷ�����������
			transport.connect(host, user, pwd);
			// ���ʼ����ͳ�ȥ
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * affix����λ�ã�affixTitle�������⣬emailTitle�ʼ����� args[0]�����˻���args[1]��������
	 * receiveEmail�ռ���ַ text �ʼ�����
	 */
	public void sendOfferEmail(String affix, String affixTitle,
			String emailTitle, String receiveEmail, String args[], String text) {
		// smtp������
		String emailsmtp = ReadPropertity.getProperty("emailsmtp");
		// �����ʼ��˻�
		String emailaddress = "";
		// �����˻�����
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
		// ���÷����˵�ַ���ռ��˵�ַ���ʼ�����
		cn.setAddress(emailaddress, receiveEmail, emailTitle);
		// ����Ҫ���͸�����λ�úͱ���
		cn.setAffix(affix, affixTitle);
		// ����smtp�������Լ�������ʺź�����
//		 cn.send("smtp.mxhichina.com", "hr@xiangmu.ren", "AAaa1234");
		cn.send(emailsmtp, emailaddress, emailpass, text);

	}

	public static void main(String[] args) {

		SendMailUtil cn = new SendMailUtil();
		String affix = "D:\\workspace\\create\\WebRoot\\sendedOffer\\������offer&&14531982775378517.doc";
		String affixTitle = "������offer.doc";
		String emailTitle = "��Ŀ����������ļ���";
		String receiveEmail = "guohaihang0512@163.com";
		String[] arg = new String[2];
		arg[0] = "hr@xiangmu.ren";
		arg[1] = "AAaa1234";
		String text = "������,\n   ��ã�\n�ܸ��������ҹ�˾��Ŀ��Ƹ��ΪJava��������ʦһְ������������¼ȡ֪ͨ�飬������offer��Ҫ��׼����Ӧ��ְ���ϣ�ϣ�������µĹ�˾���µ�������ջ�";
		cn.sendOfferEmail(affix, affixTitle, emailTitle, receiveEmail, arg,
				text);
	}
}