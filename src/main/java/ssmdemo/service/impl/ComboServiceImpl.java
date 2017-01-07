package ssmdemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssmdemo.dao.ComboDao;
import ssmdemo.dao.ComboImgDao;
import ssmdemo.model.Combo;
import ssmdemo.model.ComboImg;
import ssmdemo.service.ComboService;

import com.github.pagehelper.PageHelper;

/**
 * 套餐
 * @author wrp
 *
 */
@Service
public class ComboServiceImpl implements ComboService {
	
	@Autowired
	private ComboDao comboDao;
	@Autowired
	private ComboImgDao comboImgDao;
	
	/**
	 * 点赞
	 */
	public Boolean clickLike(Long comboId) {
		Combo combo = comboDao.selectByPrimaryKey(comboId);
		if (combo == null) {
			combo = new Combo();
			combo.setComboId(comboId);
			combo.setClickLikeNum(1);
			comboDao.insert(combo);
		}else {
			combo.setClickLikeNum(combo.getClickLikeNum() + 1);
			comboDao.updateByPrimaryKeySelective(combo);
		}
		return true;
	}

	/**
	 * 返回点赞次数
	 */
	public Integer getClickLikeNum(Long comboId) {
		Combo combo = comboDao.selectByPrimaryKey(comboId);
		if (combo != null) {
			return combo.getClickLikeNum();
		}
		return 0;
	}

	/**
	 * 查询所有
	 */
	public List<Combo> findByParams(Combo combo, int pageSize) {
		if (pageSize == 0) {
			return comboDao.findByParams(combo);
		}
		PageHelper.startPage(1, pageSize);
		return comboDao.findByParams(combo);
	}

	/**
	 * 修改
	 */
	public void updateCombo(Combo combo) {
		comboDao.updateByPrimaryKeySelective(combo);
	}

	/**
	 * 获取套餐信息
	 */
	public Combo getCombo(Long comboId) {
		Combo combo = comboDao.selectByPrimaryKey(comboId);
		buildCombo(false, combo);
		return combo;
	}

	/**
	 * type=1:
	 * 获取前三条热门套餐信息（点赞次数）
	 * 第二名在第一个，第一名在第二个，第三名在第三个
	 * type=2:
	 * 获取前五条热门套餐信息（点赞次数）
	 */
	public List<Combo> getPopularCombo(int type, int pageSize) {
		if (type == 1) {
			List<Combo> combos = new ArrayList<Combo>();
			PageHelper.startPage(1, 3);
			List<Combo> combos2 = comboDao.findByParams(new Combo());
			for (Combo combo : combos2) {
				buildCombo(false, combo);
			}
			combos.add(combos2.get(1));
			combos.add(combos2.get(0));
			combos.add(combos2.get(2));
			return combos;
		} else if (type == 2) {
			PageHelper.startPage(1, 4);
			return comboDao.findByParams(new Combo());
		} else {
			return null;
		}
	}
	
	/**
	 * 补全套餐信息 折扣，详情图片
	 * @param combo
	 */
	private void buildCombo(boolean flag, Combo combo) {
		// 折扣
		Integer price = combo.getPrice();
		Integer originalPrice = combo.getOriginalPrice();
		double discount = price/(double)originalPrice * 10;
		int discountInt = (int) discount;
		combo.setDiscountInt(String.valueOf(discountInt));
		double discountDouble = discount - discountInt;
		String str = String.valueOf(discountDouble);
		String[] strs = str.split("\\.");
		if (strs.length == 2) {
			str = strs[1];
		} else {
			str = strs[0];
		}
		if (str.length() >= 2) {
			str = str.substring(0, 2);
		}
		combo.setDiscountDouble(str);
		// 详情图片
		if (flag) {
			ComboImg comboImgParams = new ComboImg();
			comboImgParams.setComboId(combo.getComboId());
			comboImgParams.setImgType(1);
			combo.setDetailImgs(comboImgDao.findByParams(comboImgParams));
		}
	}

	public List<Combo> findComboByParams(Map<String, Object> params) {
		return comboDao.findComboByParams(params);
	}

}
