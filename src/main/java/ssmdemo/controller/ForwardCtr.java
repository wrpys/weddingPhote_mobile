package ssmdemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssmdemo.common.Constants;
import ssmdemo.common.ResultBean;
import ssmdemo.model.Combo;
import ssmdemo.service.ComboService;
import ssmdemo.utils.Util;

/**
 * 主页面跳转
 * @author wrp
 *
 */
@Controller
@RequestMapping("/")
public class ForwardCtr {
	
	@Autowired
	private ComboService comboService;
	
	/**
	 * 首页
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(HttpSession session, Model model){
		Properties cznnProperties = null;
		try {
			cznnProperties = Util.getProperties(Constants.CNZZ_CONFIG_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String cznnNo = cznnProperties.getProperty("cnzz.no");
		session.setAttribute("cnzzNo", cznnNo);
		return buildData(model);
	}
	
	@RequestMapping(value="{path}")
	public String toIndex(@PathVariable("path") String path, HttpSession session, Model model){
		Properties cznnProperties = null;
		try {
			cznnProperties = Util.getProperties(Constants.CNZZ_CONFIG_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (path == null || "".equals(path.trim()) || "index".equals(path.trim())) {
			String cznnNo = cznnProperties.getProperty("cnzz.no");
			session.setAttribute("cnzzNo", cznnNo);
		} else {
			String cznnNo = cznnProperties.getProperty("cnzz." + path.trim());
			if (cznnNo == null || "".equals(cznnNo.trim())) {
				cznnNo = cznnProperties.getProperty("cnzz.no");
			}
			session.setAttribute("cnzzNo", cznnNo);
		}
		return buildData(model);
	}
	
	private String buildData(Model model){
		// 查询4套点赞最多的套餐
		Combo comboParams = new Combo();
		comboParams.setType(1);
		List<Combo> taocanCombos = comboService.findByParams(comboParams, 4);
		model.addAttribute("taocanCombos", taocanCombos);
		// 查询4套点赞最多的客照
		comboParams = new Combo();
		comboParams.setType(2);
		List<Combo> kezhaoCombos = comboService.findByParams(comboParams, 4);
		model.addAttribute("kezhaoCombos", kezhaoCombos);
		// 查询4套点赞最多的独家场景
		comboParams = new Combo();
		comboParams.setType(3);
		List<Combo> dujiaCombos = comboService.findByParams(comboParams, 2);
		model.addAttribute("dujiaCombos", dujiaCombos);
		model.addAttribute("index", "cur");
		return "front/index";
	}
	
	/**
	 * 推荐套餐 套餐列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="product_packages2", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultBean recom_product_package2(String orderBy, String orderByType){
		ResultBean rb = new ResultBean();
		// 获取所有套餐
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", 1);
		String orderByStr = "";
		if (null != orderBy && !"".equals(orderBy) && null != orderByType && !"".equals(orderByType)) {
			orderByStr = " t." + orderBy + " " + orderByType;
		} else {
			orderByStr = " t.click_like_num DESC,t.price DESC";
		}
		params.put("orderByStr", orderByStr);
		rb.setSuccess(Constants.SUCCESS);
		rb.setResultObj(comboService.findComboByParams(params));
		return rb;
	}
	
	/**
	 * 推荐套餐 套餐列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="product_packages", method={RequestMethod.GET, RequestMethod.POST})
	public String recom_product_package(Model model, String orderBy, String orderByType){
		// 获取所有套餐
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", 1);
		String orderByStr = "";
		String priceOrdeBy = "";
		String clickLikeNumOrdeBy = "";
		if (null != orderBy && !"".equals(orderBy) && null != orderByType && !"".equals(orderByType)) {
			orderByStr = " t." + orderBy + " " + orderByType;
			if ("price".equals(orderBy)) {
				if ("asc".equals(orderByType)) {
					priceOrdeBy = "desc";
				} else {
					priceOrdeBy = "asc";
				}
				clickLikeNumOrdeBy = "desc";
			}
			if ("click_like_num".equals(orderBy)) {
				if ("asc".equals(orderByType)) {
					clickLikeNumOrdeBy = "desc";
				} else {
					clickLikeNumOrdeBy = "asc";
				}
				priceOrdeBy = "desc";
			} 
		} else {
			orderByStr = " t.click_like_num DESC,t.price DESC";
			priceOrdeBy = "asc";
			clickLikeNumOrdeBy = "asc";
		}
		params.put("orderByStr", orderByStr);
		List<Combo> combos = comboService.findComboByParams(params);
		model.addAttribute("combos", combos);
		model.addAttribute("priceOrdeBy", priceOrdeBy);
		model.addAttribute("clickLikeNumOrdeBy", clickLikeNumOrdeBy);
		model.addAttribute("product_packages", "cur");
		return "front/product_packages";
	}
	
	/**
	 * 套餐详情  根据comboId查询出对应的信息,进行页面展示
	 * @param model
	 * @param comboId
	 * @return
	 */
	@RequestMapping(value="product_info", method={RequestMethod.GET, RequestMethod.POST})
	public String product_info(Model model, Long comboId ,Integer result){
		Combo combo = comboService.getCombo(comboId);
		model.addAttribute("combo", combo);
		model.addAttribute("result", result);
		model.addAttribute("product_packages", "cur");
		return "front/product_info";
	}
	
	/**
	 * 在线预约  根据comboId查询出对应的信息,进行页面展示
	 * @param model
	 * @param comboId
	 * @return
	 */
	@RequestMapping(value="online_order", method={RequestMethod.GET, RequestMethod.POST})
	public String online_order(Model model,Long comboId,Integer type){
		Combo combo = comboService.getCombo(comboId);
		model.addAttribute("combo", combo);
		model.addAttribute("type", type);
		if(type == 1) {
			model.addAttribute("product_packages", "cur");
		} else if (type ==2) {
			model.addAttribute("enjoy_customer_pic", "cur");
		} else if (type == 3) {
			model.addAttribute("exclusive_scene", "cur");
		}
		return "front/online_order";
	}
	
	/**
	 * 客照欣赏 客照列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="enjoy_customer_pic", method={RequestMethod.GET, RequestMethod.POST})
	public String enjoy_customer_pic(Model model){
		// 获取所有客照
		Combo comboParams = new Combo();
		comboParams.setType(2);
		List<Combo> combos = comboService.findByParams(comboParams, 0);
		model.addAttribute("combos", combos);
		model.addAttribute("enjoy_customer_pic", "cur");
		return "front/enjoy_customer_pic";
	}
	
	/**
	 * 客照详情  根据comboId查询出对应的信息,进行页面展示
	 * @param model
	 * @param comboId
	 * @return
	 */
	@RequestMapping(value="customer_pic_list", method={RequestMethod.GET, RequestMethod.POST})
	public String customer_pic_list(Model model, Long comboId, Integer result){
		Combo combo = comboService.getCombo(comboId);
		model.addAttribute("combo", combo);
		model.addAttribute("result", result);
		model.addAttribute("enjoy_customer_pic", "cur");
		return "front/customer_pic_list";
	}
	
	/**
	 * 独家场景 独家场景列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="exclusive_scene", method={RequestMethod.GET, RequestMethod.POST})
	public String exclusive_scene(Model model){
		// 获取所有客照
		Combo comboParams = new Combo();
		comboParams.setType(3);
		List<Combo> combos = comboService.findByParams(comboParams, 0);
		model.addAttribute("combos", combos);
		model.addAttribute("exclusive_scene", "cur");
		return "front/exclusive_scene";
	}

	/**
	 * 独家详情  根据comboId查询出对应的信息,进行页面展示
	 * @param model
	 * @param comboId
	 * @return
	 */
	@RequestMapping(value="exclusive_scene_list", method={RequestMethod.GET, RequestMethod.POST})
	public String exclusive_scene_list(Model model, Long comboId, Integer result){
		Combo combo = comboService.getCombo(comboId);
		model.addAttribute("combo", combo);
		model.addAttribute("result", result);
		model.addAttribute("exclusive_scene", "cur");
		return "front/exclusive_scene_list";
	}
	
	/**
	 * 预约咨询
	 * @return
	 */
	@RequestMapping(value="i_want_order", method={RequestMethod.GET, RequestMethod.POST})
	public String i_want_order(Model model, Integer result){
		model.addAttribute("result", result);
		model.addAttribute("i_want_order", "cur");
		return "front/i_want_order";
	}
	
}
