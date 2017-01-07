package ssmdemo.common;

public interface Constants {

	public static boolean SUCCESS = true;

	public static boolean FAIL = false;
	
	public static String ENCODEING = "UTF-8";

	// **************** 163邮件配置 ********************
	public static String EMAIL_163_SERVER = "email.163.server";
	public static String EMAIL_163_FROM = "email.163.from";
	public static String EMAIL_163_USER = "email.163.user";
	public static String EMAIL_163_NAME = "email.163.name";
	public static String EMAIL_163_PASSWORD = "email.163.password";
	public static String EMAIL_CONFIG_PATH = "resources/config/email.properties";
	
	// ****************** sms配置 ********************
	public static String SMS_OPEN_URL = "sms.open.url";
	public static String SMS_DATA_URL = "sms.data.url";
	public static String SMS_ACCOUNT = "sms.account";
	public static String SMS_AUTHKEY = "sms.authkey";
	public static String SMS_CGID = "sms.cgid";
	public static String SMS_CSID = "sms.csid";
	public static String SMS_MOBILE = "sms.mobile";
	public static String SMS_CONFIG_PATH = "resources/config/sms.properties";
	
	// ******************* cnzz配置************************
	public static String CNZZ_CONFIG_PATH = "resources/cnzz/cnzz.properties";
	
}
