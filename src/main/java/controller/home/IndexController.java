package controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import entity.Article;
import entity.Link;
import entity.Notice;
import entity.Tag;
import enums.LinkEnum;
import service.ArticleService;
import service.LinkService;
import service.NoticeService;
import service.TagService;

@Controller
public class IndexController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	LinkService linkService;
	
	@Autowired
	TagService tagService;
	
	//获取主页所需的数据并进行跳转
	@RequestMapping("/home/index")
	public ModelAndView indexPage(@RequestParam(required=false,defaultValue="0") Integer start,@RequestParam(required=false,defaultValue="10") int number) {
		//获取文章（需分页）
		PageInfo<Article> articleList = articleService.getArticleForPaging(start,number);
		//获取公告
		List<Notice> noticeList = noticeService.getAllNotice();
		//获取友情链接（获取通过审核的链接）
		List<Link> linkList = linkService.getAllLinkByStatus(LinkEnum.passReview);
		//获取标签
		List<Tag> tagList = tagService.getAllTag();
		//传递分页的url
		String url = "/SSMBlog/home/index";
		
		ModelAndView mav = new ModelAndView("/home/index");
		//因为文章和评论共用一个分页模板，所以要同一为pageInfo
		mav.addObject("pageInfo",articleList);
		mav.addObject("noticeList",noticeList);
		mav.addObject("linkList",linkList);
		mav.addObject("tagList",tagList);
		mav.addObject("url",url);
		return mav;
	}
}
