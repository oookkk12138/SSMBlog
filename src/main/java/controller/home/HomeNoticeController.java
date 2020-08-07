package controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Article;
import entity.Notice;
import service.ArticleService;
import service.NoticeService;

@Controller
public class HomeNoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ArticleService articleService;
	
	//跳转到通知详情页面
	@RequestMapping("/home/notice/noticeDetail/{id}")
	public ModelAndView noticeDetail(@PathVariable("id") int id) {
		//根据id获取公告
		Notice notice = noticeService.getNoticeById(id);
		//获取观看数最多的5条文章（热门文章）
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/noticeDetail");
		mav.addObject("notice",notice);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
}
