package ssmdemo.model;
/**
 * 套餐图片
 * @ClassName:comboImg
 * @Description: 
 * @author   wrp
 * @Date	 2016年5月5日  下午4:35:04
 */
public class ComboImg {
	
	private Long imgId;	// 图片ID
	
	private Long comboId; // 套餐ID
	
	private Integer imgType; // 图片类型
	
	private String imgName; // 图片名称
	
	private String imgDesc; // 图片描述

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public Long getComboId() {
		return comboId;
	}

	public void setComboId(Long comboId) {
		this.comboId = comboId;
	}

	public Integer getImgType() {
		return imgType;
	}

	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	
}
