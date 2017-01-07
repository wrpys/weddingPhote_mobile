package ssmdemo.dao;

import java.util.List;

import ssmdemo.model.ComboImg;

public interface ComboImgDao {
	
	int deleteByPrimaryKey(Long imgId);

    int insert(ComboImg record);

    int insertSelective(ComboImg record);

    ComboImg selectByPrimaryKey(Long imgId);

    int updateByPrimaryKeySelective(ComboImg record);

    int updateByPrimaryKey(ComboImg record);
	
	List<ComboImg> findByParams(ComboImg comboImg);

}