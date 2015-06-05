package com.hotTopic.dao.interfaces;

import java.util.List;

import com.hotTopic.domain.Article;

public interface IArticleDAO {
	public List<Article> getTodayArticles();
}
