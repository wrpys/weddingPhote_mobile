package ssmdemo.utils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ssmdemo.common.Constants;

import com.shcm.bean.BalanceResultBean;
import com.shcm.bean.SendResultBean;
import com.shcm.send.DataApi;
import com.shcm.send.OpenApi;

/**
 * 发送短信
 * @author wrp
 */
public class SmsUtil {
	
	private static Log logger = LogFactory.getLog(SmsUtil.class);
	
	/*
	 * 发送短信
	 */
	public static int sendSms(String content) throws IOException {
		
		Properties smsProperties = Util.getProperties(Constants.SMS_CONFIG_PATH);
		String sOpenUrl = smsProperties.get(Constants.SMS_OPEN_URL).toString();
		String sDataUrl = smsProperties.get(Constants.SMS_DATA_URL).toString();
		// 接口帐号
		String account = smsProperties.get(Constants.SMS_ACCOUNT).toString();
		// 接口密钥
		String authkey = smsProperties.get(Constants.SMS_AUTHKEY).toString();
		// 通道组编号
		int cgid = Integer.valueOf(smsProperties.get(Constants.SMS_CGID).toString());
		// 默认使用的签名编号(未指定签名编号时传此值到服务器)
		int csid = Integer.valueOf(smsProperties.get(Constants.SMS_CSID).toString());
		// 默认发送的手机号
		String mobile = smsProperties.get(Constants.SMS_MOBILE).toString();
		
		// 发送参数
		OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);
		// 状态及回复参数
		DataApi.initialzeAccount(sDataUrl, account, authkey);
		// 取帐户余额
		BalanceResultBean br = OpenApi.getBalance();
		if(br == null) {
			System.out.println("获取可用余额时发生异常!");
			return 0;
		}
		if(br.getResult() < 1) {
			System.out.println("获取可用余额失败: " + br.getErrMsg());
			return 1;
		}
		logger.info("可用条数: " + br.getRemain());
		
		List<SendResultBean> srb = null;
		if (br.getRemain() < 50) {
			String msg = "[账户可用短信数量只剩：" + br.getRemain() + ",请及时充值！]";
			content += msg;
			srb = OpenApi.sendOnce(mobile, content, 0, 0, null);
		} else {
			srb = OpenApi.sendOnce(mobile, content, 0, 0, null);
		}
		if (srb != null) {
			for (SendResultBean t : srb) {
				if (t.getResult() < 1) {
					logger.info("发送提交失败: " + t.getErrMsg());
					return 2;
				}
				logger.info("发送成功: 消息编号<" + t.getMsgId() + "> 总数<" + t.getTotal() + "> 余额<" + t.getRemain() + ">");
			}
			return 3;
		} else {
			return 2;
		}
	}

}
