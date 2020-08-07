import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ArticleDao;
import entity.Article;

public class Test {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		ArticleDao dao = factory.getBean(ArticleDao.class);
		
		Article article = new Article();
		article.setArticle_status(7);
		article.setArticle_id(1);
		
		dao.updateArticle(article);
	}
	
}
