package service;

import entity.Option;

public interface OptionService {
	//获取第一个
	public Option getOptionFirst();
	//更新选项
	public void updateOption(Option option);
}
