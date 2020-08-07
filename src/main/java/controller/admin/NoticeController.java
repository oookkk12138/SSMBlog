package controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Notice;
import service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	//后台添加公告
	@RequestMapping("/admin/notice/insert")
	public String noticePage() {
		return "/admin/notice/insert";
	}
	
	//后台全部公告
	@RequestMapping("/admin/notice/index")
	public ModelAndView noticeIndex() {
		List<Notice> noticeList = noticeService.getAllNotice();
		ModelAndView mav = new ModelAndView("/admin/notice/index");
		mav.addObject("noticeList",noticeList);
		return mav;
	}
	
	//添加公告提交
	@RequestMapping("/admin/notice/insertSubmit")
	public String noticeInsertSubmit(Notice notice) {
		notice.setNotice_create_time(new Date());
		notice.setNotice_order(0);
		noticeService.addNotice(notice);
		return "redirect:/admin/notice/index";
	}
	
	//跳转到编辑公告页面
	@RequestMapping("/admin/notice/edit/{id}")
	public ModelAndView noticeEdit(@PathVariable("id") int notice_id) {
		Notice notice = noticeService.getNoticeById(notice_id);
		ModelAndView mav = new ModelAndView("/admin/notice/edit");
		mav.addObject("notice",notice);
		return mav;
	}
	
	//公告编辑提交
	@RequestMapping("/admin/notice/editSubmit")
	public String noticeEditSubmit(Notice notice) {
		System.out.println(notice);
		notice.setNotice_update_time(new Date());
		noticeService.updateNotice(notice);
		return "redirect:/admin/notice/index";
	}
	
	//删除公告
	@RequestMapping("/admin/notice/delete/{id}")
	public String noticeDelete(@PathVariable("id") int notice_id) {
		noticeService.deleteNoticeById(notice_id);
		return "redirect:/admin/notice/index";
	}
	
}
