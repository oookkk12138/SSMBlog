package controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import entity.Article;
import entity.Article_Category_Ref;
import entity.Category;
import entity.Tag;
import entity.User;
import service.ArticleService;
import service.Article_Category_Ref_Service;
import service.Article_Tag_Ref_Service;
import service.CategoryService;
import service.TagService;

@Controller
public class ArticleController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	Article_Category_Ref_Service article_Category_Ref_Service;
	
	@Autowired
	Article_Tag_Ref_Service article_Tag_Ref_Service;
	
	//后台添加文章页面
	@RequestMapping("/admin/article/insert")
	public ModelAndView insertArticlePage() {
		List<Category> categoryList = categoryService.getAllCategory();
		List<Tag> tagList = tagService.getAllTag();
		ModelAndView mav = new ModelAndView("/admin/article/insert");
		mav.addObject(categoryList);
		mav.addObject(tagList);
		return mav;
	}
	
	//跳转到全部文章页面（分页查询）
	//@RequestParam:required:客户端是否必须传入参数，defaultValue：默认值
	@RequestMapping("/admin/article/index")
	public ModelAndView articleIndexPage(@RequestParam(required=false,defaultValue="0") int start,@RequestParam(required=false,defaultValue="10") int number) {
		//分页查询文章（倒序，已封装了分类）
		PageInfo<Article> articleList  = articleService.getArticleForPaging(start,number);
		//因为全部文章和评论公用一个分页模板，所以此处设置跳转链接
		String src = "/SSMBlog/admin/article/index";
		ModelAndView mav = new ModelAndView("/admin/article/index");
		//因为多个jsp公用一个分页，所以此处的名字要统一为pageInfo
		mav.addObject("pageInfo",articleList);
		mav.addObject("src",src);
		return mav;
	}
	
	//跳转到编辑文章页面
	@RequestMapping("/admin/article/edit/{article_id}")
	public ModelAndView editArticleView(@PathVariable("article_id") Integer article_id) {
		//根据id获取文章（已封装了分类和标签）
		Article article = articleService.getArticleByIdWithCategoryListAndTagList(article_id);
		List<Category> categoryList = categoryService.getAllCategory();
		List<Tag> tagList = tagService.getAllTag();
		ModelAndView mav = new ModelAndView("/admin/article/edit");
		mav.addObject("article",article);
		mav.addObject("categoryList",categoryList);
		mav.addObject("tagList",tagList);
		return mav;
	}
	
	//删除文章
	@RequestMapping("/admin/article/delete/{id}")
	@ResponseBody
	public String deleteArticle(@PathVariable("id") int article_id) {
		//删除文章
		articleService.deleteArticleById(article_id);
		//删除分类中间表(若不进行中间表的删除，在进行分类查询文章的时候就会出现空指针异常)
		article_Category_Ref_Service.delete_Article_Category_RefByArticleId(article_id);
		//删除标签中间表(若不进行中间表的删除，在进行分类查询文章的时候就会出现空指针异常)
		article_Tag_Ref_Service.delete_Article_Tag_RefByArticleId(article_id);
		return null;
	}
	
	//编辑文章提交
	@RequestMapping("/admin/article/editSubmit")
	public String articleEditSubmit(Article article,Integer articleParentCategoryId,Integer articleChildCategoryId,Integer[] articleTagIds) {
		//更新文章的修改时间
		article.setArticle_update_time(new Date());
		//封装分类
		List<Category> categoryList = new ArrayList<Category>();
		Category parentCategory = categoryService.getCategoryById(articleParentCategoryId);
		Category childCategory = categoryService.getCategoryById(articleChildCategoryId);
		categoryList.add(parentCategory);
		categoryList.add(childCategory);
		article.setCategoryList(categoryList);
		//封装标签
		List<Tag> tagList = null;
		if(articleTagIds != null) {
			tagList = new LinkedList<Tag>();
			for(int i = 0;i < articleTagIds.length;i++) {
				Tag tag = tagService.getTagById(articleTagIds[i]);
				tagList.add(tag);
			}
			article.setTagList(tagList);
		}
		//保存文章-分类中间表到数据库中
		if(categoryList.size() != 0){
			//根据文章id删除文章-分类中间表的对应数据
			article_Category_Ref_Service.delete_Article_Category_RefByArticleId(article.getArticle_id());
			//保存到数据库中
			for(int i = 0;i < categoryList.size();i++) {
				article_Category_Ref_Service.add_Article_Category_Ref(article.getArticle_id(),categoryList.get(i).getCategory_id());
			}
		}
		//保存文章-标签中间表到数据库中
		if(tagList.size() != 0) {
			//根据文章id删除文章-标签中间表的对应数据
			article_Tag_Ref_Service.delete_Article_Tag_RefByArticleId(article.getArticle_id());
			//保存到数据库中
			for(int i = 0;i < tagList.size();i++) {
				article_Tag_Ref_Service.add_Article_Tag_Ref(article.getArticle_id(),tagList.get(i).getTag_id());
			}
		}
		//保存文章信息到数据库中
		articleService.updateArticle(article);
		//跳转页面
		return "redirect:/admin/article/index";
	}
	
	//写文章提交
	@RequestMapping("/admin/article/insertSubmit")
	public String articleInsertSubmit(Article article,Integer articleParentCategoryId,Integer articleChildCategoryId,Integer[] articleTagIds,HttpSession session) {
		//封装分类
		List<Category> categoryList = new ArrayList<Category>();
		Category parentCategory = categoryService.getCategoryById(articleParentCategoryId);
		Category childCategory = categoryService.getCategoryById(articleChildCategoryId);
		categoryList.add(parentCategory);
		categoryList.add(childCategory);
		article.setCategoryList(categoryList);
		//封装标签
		List<Tag> tagList = null;
		if(articleTagIds != null) {
			tagList = new LinkedList<Tag>();
			for(int i = 0;i < articleTagIds.length;i++) {
				Tag tag = tagService.getTagById(articleTagIds[i]);
				tagList.add(tag);
			}
			article.setTagList(tagList);
		}
		//初始化文章信息
		User user = (User) session.getAttribute("user");
		article.setArticle_userid(user.getUser_id());
		article.setArticle_view_count(0);
		article.setArticle_comment_count(0);
		article.setArticle_like_count(0);
		article.setArticle_order(0);
		article.setArticle_create_time(new Date());
		//保存文章到数据库中
		articleService.addArticle(article);
		System.out.println(article);
		//保存文章-分类中间表到数据库中
		if(categoryList.size() != 0){
			//保存到数据库中
			for(int i = 0;i < categoryList.size();i++) {
				article_Category_Ref_Service.add_Article_Category_Ref(article.getArticle_id(),categoryList.get(i).getCategory_id());
			}
		}
		//保存文章-标签中间表到数据库中
		if(tagList.size() != 0) {
			//保存到数据库中
			for(int i = 0;i < tagList.size();i++) {
				article_Tag_Ref_Service.add_Article_Tag_Ref(article.getArticle_id(),tagList.get(i).getTag_id());
			}
		}
		//跳转页面
		return "redirect:/admin/article/index";
	}
	
	//首页中保存草稿
	@RequestMapping("/admin/article/insertDraftSubmit")
	public String articleInsertDraftSubmit(Article article,HttpSession session) {
		User user = (User) session.getAttribute("user");
		article.setArticle_userid(user.getUser_id());
		article.setArticle_create_time(new Date());
		articleService.addArticle(article);
		return "redirect:/admin/article/index";
	}
	
}
