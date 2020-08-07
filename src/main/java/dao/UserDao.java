package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface UserDao {
	//根据用户名获取用户
	public User getUserByName(String name);
	//根据邮箱获取用户
	public User getUserByEmail(String email);
	//修改用户（动态SQL）
	public void updateUser(User user);
	//根据id获取用户
	public User getUserById(Integer user_id);
	//获取所有的用户
	public List<User> getAllUser();
	//获取用户总数
	public int getUserCount();
	//添加一个用户
	public void insertUser(User user);
	//根据id删除用户
	public void deleteUserById(int user_id);
}
