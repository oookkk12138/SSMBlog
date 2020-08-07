package controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Option;
import service.OptionService;

@Controller
public class OptionController {
	
	@Autowired
	OptionService optionService;
	
	//后台主要选项页面
	@RequestMapping("/admin/option/index")
	public ModelAndView optionsIndex() {
		Option option = optionService.getOptionFirst();
		ModelAndView mav = new ModelAndView("/admin/option/index");
		mav.addObject("option",option);
		return mav;
	}
	
	//修改选项
	@RequestMapping("/admin/option/editSubmit")
	public String optionEditSubmit(Option option) {
		optionService.updateOption(option);
		return "redirect:/admin/option/index";
	}
	
}
