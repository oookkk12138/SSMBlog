package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OptionDao;
import entity.Option;
import service.OptionService;

@Service
public class OptionServiceImpl implements OptionService{

	@Autowired
	OptionDao optionDao;
	
	//获取所有的选项
	public Option getOptionFirst() {
		Option option = optionDao.getOptionFirst();
		return option;
	}

	//更新选项
	public void updateOption(Option option) {
		optionDao.updateOption(option);
	}
	
}
