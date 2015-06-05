package com.hotTopic.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotTopic.dao.interfaces.IArticleDAO;
import com.hotTopic.domain.Article;
import com.hotTopic.service.interfaces.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private IArticleDAO articleDao;

	public List<Article> getArticlesByDay(String dayStr) throws SQLException {
		String startTime = dayStr + " 00:00:00";
		String endTime = dayStr + " 23:59:59";
		return articleDao.getArticlesByCreateTime(startTime, endTime);
	}

}
