package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ArticleDao;
import dao.UserDao;
import entity.Article;
import entity.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	ArticleDao articleDao;
	
	//根据用户名或邮箱获取用户
	public User getUserByNameOrEmail(String message) {
		//先根据用户名获取用户
		User user = userDao.getUserByName(message);
		//若根据用户名获取不到用户则用邮箱获取用户
		if(user == null) {
			userDao.getUserByEmail(message);
		}
		return user;
	}

	//更新用户
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	//根据id获取用户
	public User getUserById(Integer user_id) {
		User user = userDao.getUserById(user_id);
		return user;
	}

	//获取所有的用户
	public List<User> getAllUserWithArticle() {
		List<User> userList = userDao.getAllUser();
		for(int i = 0;i < userList.size();i++) {
			//根据用户id获取文章集合
			List<Article> articleList = articleDao.getArticleByUserId(userList.get(i).getUser_id());
			//封装文章集合
			userList.get(i).setArticleList(articleList);
		}
		return userList;
	}

	//获取用户总数
	public int getUserCount() {
		int count = userDao.getUserCount();
		return count;
	}

	//增加一个用户
	public void addUser(User user) {
		userDao.insertUser(user);
	}

	//根据id删除用户
	public void deleyeUserById(int user_id) {
		userDao.deleteUserById(user_id);
	}
	 
}
