package ssmdemo.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * 套餐信息
 *
 * @ClassName:Combo
 * @Description: 
 * @author   wrp
 * @Date	 2016年5月5日  下午3:14:23
 */
public class Combo {
	
    private Long comboId;// 套餐ID
    
    private Integer type;// 类别，1：套餐，2：客照

    private String comboName;// 套餐名称
    
    private Integer clickLikeNum;// 点赞次数

    private Integer price;// 价格

    private Integer originalPrice;// 原价
    
    private String discountInt;// 折扣 整数
    
    private String discountDouble;// 折扣 两位小数
    
    private String imgPath;// 图片路径
    
    private String comboDesc;// 描述
    
    private String userNames;// 客照人物名称 Mr蔡 &amp; Miss候
    
    private Date createTime;// 客照拍摄时间
    
    private Integer imgCount;// pc端详情图数量
    
    private Integer mobileImgCount;// 移动端详情图数量
    
    private List<ComboImg> detailImgs;// 套餐详情图

	public Long getComboId() {
		return comboId;
	}

	public void setComboId(Long comboId) {
		this.comboId = comboId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}

	public Integer getClickLikeNum() {
		return clickLikeNum;
	}

	public void setClickLikeNum(Integer clickLikeNum) {
		this.clickLikeNum = clickLikeNum;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getDiscountInt() {
		return discountInt;
	}

	public void setDiscountInt(String discountInt) {
		this.discountInt = discountInt;
	}

	public String getDiscountDouble() {
		return discountDouble;
	}

	public void setDiscountDouble(String discountDouble) {
		this.discountDouble = discountDouble;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getComboDesc() {
		return comboDesc;
	}

	public void setComboDesc(String comboDesc) {
		this.comboDesc = comboDesc;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<ComboImg> getDetailImgs() {
		return detailImgs;
	}

	public void setDetailImgs(List<ComboImg> detailImgs) {
		this.detailImgs = detailImgs;
	}

	public Integer getImgCount() {
		return imgCount;
	}

	public void setImgCount(Integer imgCount) {
		this.imgCount = imgCount;
	}

	public Integer getMobileImgCount() {
		return mobileImgCount;
	}

	public void setMobileImgCount(Integer mobileImgCount) {
		this.mobileImgCount = mobileImgCount;
	}

}