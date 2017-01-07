package ssmdemo.model;


/**
 * 预定信息
 * @author wrp
 *
 */
public class ReservationsInfo {
	
	private String userName;
	private Integer sex;
	private String mobile;
	private String reservationsTime;
	private Long comboId;
	private String desc;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getReservationsTime() {
		return reservationsTime;
	}
	public void setReservationsTime(String reservationsTime) {
		this.reservationsTime = reservationsTime;
	}
	public Long getComboId() {
		return comboId;
	}
	public void setComboId(Long comboId) {
		this.comboId = comboId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
