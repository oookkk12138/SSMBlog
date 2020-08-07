package controller.home;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeUserController {
	//跳转到登录页面
	@RequestMapping("/home/user/login")
	public String userLogin() {
		return "/home/login";
	}
	
	//退出登录
	@RequestMapping("/home/user/logout")
	public String logout(HttpSession session) {
		//清除session
		session.removeAttribute("user");
		//销毁session
		session.invalidate();
		//此处的重定向是重定向到controller的login（由login再转发到login.jsp）
		return "redirect:/home/index";
	}
}
