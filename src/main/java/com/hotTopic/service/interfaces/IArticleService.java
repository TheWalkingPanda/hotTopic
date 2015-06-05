package com.hotTopic.service.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.hotTopic.domain.Article;

public interface IArticleService {
	public List<Article> getArticlesByDay(String dayStr) throws SQLException;
}
