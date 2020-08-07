package controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Article_Tag_Ref;
import entity.Category;
import entity.Tag;
import service.Article_Tag_Ref_Service;
import service.TagService;

@Controller
public class TagController {
	
	@Autowired
	TagService tagService;
	
	@Autowired
	Article_Tag_Ref_Service article_Tag_Ref_Service;
	
	//跳转到全部标签页面
	@RequestMapping("/admin/tag/index")
	public ModelAndView tagIndexPage() {
		List<Tag> tagList = tagService.getAllTagWithArticle();
		ModelAndView mav = new ModelAndView("/admin/tag/index");
		mav.addObject(tagList);
		return mav;
	}
	
	//添加标签提交
	@RequestMapping("/admin/tag/insertSubmit")
	public String tagInsertSubmit(Tag tag) {
		tagService.addTag(tag);
		return "redirect:/admin/tag/index";
	}
	
	//删除标签
	@RequestMapping("/admin/tag/delete/{id}")
	public String tagDelete(@PathVariable("id") int tag_id) {
		//根据tagId查询是否有文章，若有文章则不能删除
		List<Article_Tag_Ref> article_Tag_Ref_List = article_Tag_Ref_Service.get_Article_Tag_Ref_ByTagId(tag_id);
		//若该标签存在关联的文章则不能删除（数据库中没有外键就从java代码中进行安全性控制）
		if(article_Tag_Ref_List.size() != 0) {
			return "redirect:/admin/tag/index";
		}else {
			tagService.deleteTagById(tag_id);
			return "redirect:/admin/tag/index";
		}
	}
	
	//跳转到编辑标签页面
	@RequestMapping("/admin/tag/edit/{id}")
	public ModelAndView tagEdit(@PathVariable("id") int tag_id) {
		//根据tag_id获取标签
		Tag tag = tagService.getTagById(tag_id);
		//获取所有的标签
		List<Tag> tagList = tagService.getAllTagWithArticle();
		ModelAndView mav = new ModelAndView("/admin/tag/edit");
		mav.addObject("tag",tag);
		mav.addObject("tagList",tagList);
		return mav;
	}
	
	//修改标签提交
	@RequestMapping("/admin/tag/editSubmit")
	public String tagEditSubmit(Tag tag) {
		tagService.updateTag(tag);
		return "redirect:/admin/tag/index";
	}
	
}
