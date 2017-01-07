package ssmdemo.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import ssmdemo.common.Constants;

/**
 * 邮件发送
 * 
 * @author wrp
 * 
 */
public class EmailUtil {

	public static boolean sendEmail(String subject, String message) throws IOException, EmailException {  
        // 发送email  
        HtmlEmail email = new HtmlEmail(); 
    	Properties emailProperties = Util.getProperties(Constants.EMAIL_CONFIG_PATH);
        // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"  
        email.setHostName(emailProperties.getProperty(Constants.EMAIL_163_SERVER));  
        // 字符编码集的设置  
        email.setCharset(Constants.ENCODEING);  
        // 收件人的邮箱  
        email.addTo(emailProperties.getProperty(Constants.EMAIL_163_FROM));  
        // 发送人的邮箱  
        email.setFrom(emailProperties.getProperty(Constants.EMAIL_163_USER), 
        		emailProperties.getProperty(Constants.EMAIL_163_NAME));  
        // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码  
        email.setAuthentication(emailProperties.getProperty(Constants.EMAIL_163_USER),
        		emailProperties.getProperty(Constants.EMAIL_163_PASSWORD));  
        // 要发送的邮件主题  
        email.setSubject(subject);  
        // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签  
        email.setCharset(Constants.ENCODEING);
        email.setMsg(message);  
        // 发送  
        email.send();  
        return true;  
    }
	
	public static void main(String[] args) {
    	try {
			EmailUtil.sendEmail("标题", "内容");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmailException e) {
			e.printStackTrace();
		}  
	}

}
