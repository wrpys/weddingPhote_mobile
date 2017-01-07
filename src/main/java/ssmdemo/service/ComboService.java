package ssmdemo.service;

import java.util.List;
import java.util.Map;

import ssmdemo.model.Combo;


public interface ComboService {
	
	Boolean clickLike(Long comboId);

	Integer getClickLikeNum(Long comboId);

	List<Combo> findByParams(Combo combo, int pageSize);

	void updateCombo(Combo combo);

	Combo getCombo(Long comboId);

	List<Combo> getPopularCombo(int type, int pageSize);

	List<Combo> findComboByParams(Map<String, Object> params);

}
