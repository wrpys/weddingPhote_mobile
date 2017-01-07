package ssmdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssmdemo.model.ReservationsInfo;
import ssmdemo.service.ReservationsInfoService;

/**
 * 预定套餐
 * @author wrp
 *
 */
@Controller
@RequestMapping("reservationsInfoCtr")
public class ReservationsInfoCtr {               
	
	@Autowired
	private ReservationsInfoService reservationsInfoService;
	
	@RequestMapping(value="reservationsInfo", method={RequestMethod.GET, RequestMethod.POST})
	public String reservationsInfo(Model model, ReservationsInfo reservationsInfo, Integer type){
		boolean result = reservationsInfoService.reservationsInfo(reservationsInfo);
		if (result) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", -1);
		}
		model.addAttribute("comboId", reservationsInfo.getComboId());
		if (reservationsInfo.getComboId() == null) {
			return "redirect:/i_want_order";
		} else {
			if(type == 1){
				return "redirect:/product_info";
			} else if (type == 2) {
				return "redirect:/customer_pic_list";
			} else if (type == 3) {
				return "redirect:/exclusive_scene_list";
			} else {
				return "redirect:/index";
			}
		}
	}
	
}
