package controller.home;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import entity.Article;
import entity.Article_Tag_Ref;
import entity.Tag;
import service.ArticleService;
import service.TagService;

@Controller
public class HomeTagController {
	
	@Autowired
	TagService tagService;
	
	@Autowired
	ArticleService articleService;
	
	//根据标签获取文章分页
	@RequestMapping("/home/articleListByTag/{tag_id}")
	public ModelAndView articleListByTag(@RequestParam(required=false,defaultValue="0") int start,@RequestParam(required=false,defaultValue="10") int number,@PathVariable("tag_id") int tag_id) {
		//根据tagId获取Tag
		Tag tag = tagService.getTagById(tag_id);
		//根据tagId获取分页的文章
		Map<String,Object> map = articleService.getArticleByTagForPaging(start,number,tag_id);
		//分页的文章
		List<Article> articleList = (List<Article>) map.get("articleList");
		//分页的数据
		PageInfo<Article_Tag_Ref> pageInfo = (PageInfo<Article_Tag_Ref>) map.get("pageInfo");
		//获取观看数最多的5条文章（热门文章）
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/articleListByTag");
		mav.addObject("tag",tag);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("articleList",articleList);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
}
