package com.hotTopic.service.interfaces;

import java.util.List;

import com.hotTopic.domain.Article;

public interface IArticleService {
	public List<Article> getTodayArticles();
}
