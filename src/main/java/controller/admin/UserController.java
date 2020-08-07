package controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Article;
import entity.Comment;
import entity.User;
import service.ArticleService;
import service.CommentService;
import service.UserService;
import util.MyUtils;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CommentService commentService;
	
	//跳转到登录界面
	@RequestMapping("/admin/login")
	public String logePage() {
		return "/admin/login";
	}
	
	//通过AJAX返回数据验证用户用户名是否合理
	@RequestMapping("/admin/loginVerify")
	@ResponseBody
	public String loginVerify(String username,String password,boolean rememberme,HttpServletRequest request,HttpServletResponse response) {
		User user = userService.getUserByNameOrEmail(username);
		//若用户不存在返回用户名无效
		if(user == null) {
			return "userName_error";
		}
		//若用户存在且密码不对返回密码错误
		else if(!user.getUser_password().equals(password)) {
			return "userPassword_error"; 
		}
		//若用户状态为0则提示用户被禁用
		else if(user.getUser_status() == 0){
			return "userStatus_error";
		}
		else {
			//登录成功则把用户保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			//若用户勾选了记住密码
			if(rememberme) {
				//创建两个cookie对象
				Cookie nameCookie = new Cookie("username",username);
				//设置cookie的有效期为3天
				nameCookie.setMaxAge(60 * 60 * 24 * 3);
				Cookie passwordCookie = new Cookie("password",password);
				passwordCookie.setMaxAge(60 * 60 * 24 * 3);
				response.addCookie(nameCookie);
				response.addCookie(passwordCookie);
			}
			//更新user的最后登录时间和登录ip
			user.setUser_last_login_time(new Date());
			user.setUser_last_login_ip(MyUtils.getIpAddress(request));
			userService.updateUser(user);
			return null;
		}
	}
	
	//跳转到主页
	@RequestMapping("/admin/index")
	public ModelAndView indexPage(HttpSession session) {
		User user = (User) session.getAttribute("user");
		//若session中有用户的数据则跳到主页
		if(user != null) {
			ModelAndView mav = new ModelAndView("/admin/index");
			//获取最后的5个文章和评论
			List<Article> articleList = articleService.getAllArticleDesc();
			List<Comment> commentList = commentService.getLastFiveComment();
			//获取最后的5个评论对应的文章
			List<Article> commentArticleList = articleService.getFiveArticleByFiveComment(commentList);
			mav.addObject("articleList",articleList);
			mav.addObject("commentList",commentList);
			mav.addObject("commentArticleList",commentArticleList);
			return mav;
		}else {
			//session中没有用户数据则跳到登录页
			ModelAndView mav = new ModelAndView("/admin/login");
			return mav;
		}
	}
	
	//退出登录
	@RequestMapping("/admin/user/logout")
	public String logout(HttpSession session) {
		//清除session
		session.removeAttribute("user");
		//销毁session
		session.invalidate();
		//此处的重定向是重定向到controller的login（由login再转发到login.jsp）
		return "redirect:/admin/login";
	}
	
	//用户基本资料页面
	@RequestMapping("/admin/user/profile")
	public ModelAndView profilePage(HttpSession session) {
		User user = (User) session.getAttribute("user");
		ModelAndView mav = new ModelAndView("/admin/user/profile");
		mav.addObject("user",user);
		return mav;
	}
	
	//编辑用户界面
	@RequestMapping("/admin/user/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		ModelAndView mav = new ModelAndView("/admin/user/edit");
		mav.addObject("user",user);
		return mav;
	}
	
	//在个人信息中修改用户信息或在用户模块中修改用户信息
	@RequestMapping(value="/admin/user/editSubmit",method=RequestMethod.POST)
	public String userEditSubmit(User user,HttpSession session) {
		//更新用户
		userService.updateUser(user);
		//判断若修改的用户是当前登录用户则修改session中对应的信息
		User sessionUser = (User) session.getAttribute("user");
		if(user.getUser_id() == sessionUser.getUser_id()) {
			//清除旧的session
			session.removeAttribute("user");
			//查询出新的user并保存到session中
			User user2 = userService.getUserById(user.getUser_id());
			session.setAttribute("user",user2);
			return "redirect:/admin/user/profile";
		}else {
			return "redirect:/admin/user/index";
		}
		
	}
	
	//全部用户页面
	@RequestMapping("/admin/user/index")
	public ModelAndView userIndex() {
		List<User> userList = userService.getAllUserWithArticle();
		ModelAndView mav = new ModelAndView("/admin/user/index");
		mav.addObject("userList",userList);
		return mav;
	}
	
	//后台添加用户页面
	@RequestMapping("/admin/user/insert")
	public String userInsert() {
		return "/admin/user/insert";
	}
	
	//添加用户提交
	@RequestMapping("/admin/user/insertSubmit")
	public String userInsertSubmit(User user) {
		user.setUser_register_time(new Date());
		user.setUser_status(1);
		userService.addUser(user);
		return "redirect:/admin/user/index";
	}
	
	//删除用户
	@RequestMapping("/admin/user/delete/{id}")
	public String userDelete(@PathVariable("id") int user_id) {
		userService.deleyeUserById(user_id);
		return "redirect:/admin/user/index";
	}
	
}
