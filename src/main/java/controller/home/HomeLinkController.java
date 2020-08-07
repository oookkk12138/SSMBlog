package controller.home;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Link;
import enums.LinkEnum;
import service.LinkService;

@Controller
public class HomeLinkController {
	
	@Autowired
	LinkService linkService;
	
	//提交友链申请
	@RequestMapping("/home/applyLinkSubmit")
	@ResponseBody
	public String applyLinkSubmit(Link link) {
		link.setLink_create_time(new Date());
		link.setLink_status(LinkEnum.waitReview);
		link.setLink_order(0);
		linkService.insertLink(link);
		return null;
	}
}
