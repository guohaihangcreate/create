package test;

import java.io.*;
import java.net.*;
import sun.misc.*;

public class SendEmail {
	PrintWriter output;
	BufferedReader input;
	String string;
	Socket socket = null;
	String user = "it@ihangmei.com";

	public SendEmail() {
		try {
			socket = new Socket("smtp.partner.outlook.cn",587);
			output = new PrintWriter(new OutputStreamWriter(socket
					.getOutputStream()));
			input = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			output.println("helo ihangmei.com");
			output.flush();
			System.out.println(input.readLine());
			//验证登陆
			output.println("auth login");
			output.flush();
			System.out.println(input.readLine());
			//用户名
			String username = "it";
			output.println(new BASE64Encoder().encode(username.getBytes()));
			output.flush();
			System.out.println(input.readLine());
			//密码
			String password = "Tness@2011";
			output.println(new BASE64Encoder().encode(password.getBytes()));
			output.flush();
			System.out.println(input.readLine());
			//发件人
			output.println("mail from: <it@ihangmei.com>");
			output.flush();
			System.out.println(input.readLine());
			//收件人
			output.println("rcpt to: <" + this.user + ">");
			output.flush();
			System.out.println(input.readLine());

			//内容
			output.println("data");
			output.flush();
			System.out.println(input.readLine());
			String con = "From: 网易邮箱<xxx@126.com\r\n";
			con += "To: <" + this.user + ">\r\n";
			con = con + "Subject: 网易邮箱提醒\r\n";
			con = con + "Content-Type: text/plain;charset=\"gb2312\"\r\n";
			con = con + "\r\n";
			con = con + "网易邮箱提醒您，有新邮件，请接收\r\n";
			con = con + ".\r\n";
			output.println(con);
			output.flush();
			System.out.println(input.readLine());
			System.out.println(input.readLine());
			socket.close();
			input.close();
			output.close();
			System.out.println("Done");

		} catch (Exception e) {
			System.out.println("Error " + e);
			return;
		}

	}

	public static void main(String[] args) {
		SendEmail client1 = new SendEmail();
	}

}