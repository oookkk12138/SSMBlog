package controller.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import entity.Comment;
import service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	//分页查询评论（后台评论页面）
	@RequestMapping("/admin/comment/index")
	public ModelAndView commentIndex(@RequestParam(required=false,defaultValue="0") Integer start,@RequestParam(required=false,defaultValue="10") int number) {
		PageInfo<Comment> commentList = commentService.getAllCommentWithArticleForPaging(start,number);
		//因为全部文章和评论公用一个分页模板，所以此处设置跳转链接
		String src = "/SSMBlog/admin/comment/index";
		ModelAndView mav = new ModelAndView("/admin/comment/index");
		//因为多个jsp公用一个分页，所以此处的名字要统一为pageInfo
		mav.addObject("pageInfo",commentList);
		mav.addObject("src",src);
		return mav;
	}
	
	//删除评论
	@RequestMapping(value="/admin/comment/delete/{comment_id}",method=RequestMethod.POST)
	@ResponseBody
	public String commentDelete(@PathVariable("comment_id") Integer comment_id) {
		commentService.deleteCommentById(comment_id);
		return null;
	}
	
	//跳转到编辑评论页面
	@RequestMapping("/admin/comment/edit/{id}")
	public ModelAndView commentEdit(@PathVariable("id") int comment_id) {
		Comment comment = commentService.getCommentById(comment_id);
		ModelAndView mav = new ModelAndView("/admin/comment/edit");
		mav.addObject("comment",comment);
		System.out.println(comment);
		return mav;
	}
	
	//编辑评论提交
	@RequestMapping("/admin/comment/editSubmit")
	public String commentEditSubmit(Comment comment) {
		commentService.updateComment(comment);
		return "redirect:/admin/comment/index";
	}
	
}
