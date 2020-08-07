package dao;

import org.springframework.stereotype.Repository;

import entity.Option;

@Repository
public interface OptionDao {
	//获取第一个选项
	public Option getOptionFirst();
	//更新选项
	public void updateOption(Option option);
}
