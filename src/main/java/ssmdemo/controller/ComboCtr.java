package ssmdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssmdemo.common.Constants;
import ssmdemo.common.ResultBean;
import ssmdemo.model.Combo;
import ssmdemo.service.ComboService;

/**
 * 套餐
 * @author wrp
 *
 */
@Controller
@RequestMapping("comboCtr")
public class ComboCtr {               
	
	@Autowired
	private ComboService comboService;
	
	@RequestMapping(value="clickLike", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Boolean clickLike(Long comboId){
		return comboService.clickLike(comboId);
	}
	
	@RequestMapping(value="getClickLikeNum", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Integer getClickLikeNum(Long comboId){
		return comboService.getClickLikeNum(comboId);
	}
	
	@RequestMapping(value="findCombo", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultBean findCombo(){
		ResultBean rb = new ResultBean();
		Combo comboParams = new Combo();
		comboParams.setType(1);
		List<Combo> combos = comboService.findByParams(comboParams, 0);
		rb.setRows(combos);
		rb.setTotal(combos.size());
		return rb;
	}
	
	@RequestMapping(value="updateCombo", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultBean updateCombo(Combo combo){
		ResultBean rb = new ResultBean();
		comboService.updateCombo(combo);
		rb.setSuccess(Constants.SUCCESS);
		return rb;
	}
	
	@RequestMapping(value="getCombo", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultBean getCombo(Long comboId){
		ResultBean rb = new ResultBean();
		Combo combo = comboService.getCombo(comboId);
		rb.setResultObj(combo);
		rb.setSuccess(Constants.SUCCESS);
		return rb;
	}
	
	
}
