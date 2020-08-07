package controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Article_Category_Ref;
import entity.Category;
import service.Article_Category_Ref_Service;
import service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	Article_Category_Ref_Service article_Category_Ref_Service;
	
	//跳转到全部分类页面
	@RequestMapping("/admin/category/index")
	public ModelAndView categoryIndexPage() {
		//获取所有的分类
		List<Category> categoryList = categoryService.getAllCategoryWithArticle();
		ModelAndView mav = new ModelAndView("/admin/category/index");
		mav.addObject(categoryList);
		return mav;
	}
	
	//添加分类提交
	@RequestMapping("/admin/category/insertSubmit")
	public String categoryInsertSubmit(Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/category/index";
	}
	
	//删除分类
	@RequestMapping("/admin/category/delete/{id}")
	public String categoryDelete(@PathVariable("id") int category_id) {
		//根据categoryId查询是否有文章，若有文章则不能删除
		List<Article_Category_Ref> article_Category_Ref_List = article_Category_Ref_Service.get_Article_Category_Ref_ByCategoryId(category_id);
		//若改分类存在关联的文章则不能删除（数据库中没有外键就从java代码中进行安全性控制）
		if(article_Category_Ref_List.size() != 0) {
			return "redirect:/admin/category/index";
		}else {
			categoryService.deleteCategoryById(category_id);
			return "redirect:/admin/category/index";
		}
	}
	
	//跳转到编辑分类页面
	@RequestMapping("/admin/category/edit/{id}")
	public ModelAndView categoryEdit(@PathVariable("id") int category_id) {
		//根据categrory_id获取分类
		Category category = categoryService.getCategoryById(category_id);
		//获取所有的分类
		List<Category> categoryList = categoryService.getAllCategoryWithArticle();
		ModelAndView mav = new ModelAndView("/admin/category/edit");
		mav.addObject("category",category);
		mav.addObject("categoryList",categoryList);
		return mav;
	}
	
	//修改分类提交
	@RequestMapping("/admin/category/editSubmit")
	public String categoryEditSubmit(Category category) {
		categoryService.updateCategory(category);
		return "redirect:/admin/category/index";
	}
	
}
