package com.hotTopic.service.impl;

import java.util.List;

import com.hotTopic.dao.interfaces.IArticleDAO;
import com.hotTopic.domain.Article;
import com.hotTopic.service.interfaces.IArticleService;

public class ArticleServiceImpl implements IArticleService {
	
	private IArticleDAO articleDao;
	
	public List<Article> getTodayArticles() {
		return articleDao.getTodayArticles();
	}

}
