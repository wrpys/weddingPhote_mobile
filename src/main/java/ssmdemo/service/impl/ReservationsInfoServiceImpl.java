package ssmdemo.service.impl;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssmdemo.dao.ComboDao;
import ssmdemo.model.Combo;
import ssmdemo.model.ReservationsInfo;
import ssmdemo.service.ReservationsInfoService;
import ssmdemo.utils.EmailUtil;

/**
 * 预约套餐
 * @author wrp
 *
 */
@Service
public class ReservationsInfoServiceImpl implements ReservationsInfoService {
	
	private Log logger = LogFactory.getLog(ReservationsInfoService.class);
	
	@Autowired
	private ComboDao comboDao;
	
	public boolean reservationsInfo(ReservationsInfo reservationsInfo) {
		String subject = "";
		String body = "";
		if(reservationsInfo.getComboId() != null) {
			Combo combo = comboDao.selectByPrimaryKey(reservationsInfo.getComboId());
			subject = "婚纱照预约邮件," + reservationsInfo.getUserName() + "预约";
			body = "姓名：" + reservationsInfo.getUserName() 
					+ ",手机号：" + reservationsInfo.getMobile()
					+ ",性别：" + (reservationsInfo.getSex() == 0 ? "男" : "女")
					+ ",预约套餐：" + combo.getComboName()
					+ ",预约时间：" + reservationsInfo.getReservationsTime();
		} else {
			subject = "婚纱照预约邮件,自定义预约";
			body = "姓名：" + reservationsInfo.getUserName() 
					+ ",手机号：" + reservationsInfo.getMobile()
					+ ",性别：" + (reservationsInfo.getSex() == 0 ? "男" : "女")
					+ ",预约信息：" + reservationsInfo.getDesc()
					+ ",预约时间：" + reservationsInfo.getReservationsTime();
		}
		/*logger.debug("预定套餐，发送短信 begin。。。");
		logger.debug("短信内容：" + body);
		try {
			int result = SmsUtil.sendSms(body);
			if (result == 3) {
				logger.debug("短信发送成功");
			} else {
				rb.setSuccess(Constants.FAIL);
				rb.setMsg("短信发送失败！");
				return rb;
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			logger.error("短信发送失败！");
			rb.setSuccess(Constants.FAIL);
			rb.setMsg("系统异常，请稍后重试！");
			return rb;
		} catch (IOException e1) {
			e1.printStackTrace();
			logger.error("读取文件失败！");
			rb.setSuccess(Constants.FAIL);
			rb.setMsg("系统异常，请稍后重试！");
			return rb;
		}*/
		logger.debug("预定套餐，发送邮件 begin。。。");
		logger.debug("邮件标题：" + subject);
		logger.debug("邮件内容：" + body);
		try {
			EmailUtil.sendEmail(subject, body);
			logger.debug("邮件发送成功");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("读取文件失败！");
			return false;
		} catch (EmailException e) {
			e.printStackTrace();
			logger.error("邮件发送失败！");
			return false;
		}
		return true;
	}
	
}
