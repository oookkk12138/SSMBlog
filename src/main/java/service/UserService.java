package service;

import java.util.List;

import entity.User;

public interface UserService {
	//根据用户名或邮箱获取用户
	public User getUserByNameOrEmail(String message);
	//更新用户
	public void updateUser(User user);
	//根据id获取用户
	public User getUserById(Integer user_id);
	//获取所有的用户(封装article)
	public List<User> getAllUserWithArticle();
	//获取用户总数
	public int getUserCount();
	//增加一个用户
	public void addUser(User user);
	//根据id删除用户
	public void deleyeUserById(int user_id);
}
