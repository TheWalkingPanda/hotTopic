package com.hotTopic.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.hotTopic.domain.Article;

public interface IArticleDAO {
	public List<Article> getArticlesByCreateTime(String startTime, String endTime) throws SQLException;
}
