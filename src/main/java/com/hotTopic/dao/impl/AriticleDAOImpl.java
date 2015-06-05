package com.hotTopic.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.hotTopic.dao.interfaces.IArticleDAO;
import com.hotTopic.domain.Article;

@Repository
@SuppressWarnings("unchecked")
public class AriticleDAOImpl implements IArticleDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<Article> getArticlesByCreateTime(String startTime, String endTime) throws SQLException {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);
		return (List<Article>)sqlMapClientTemplate.queryForList("getArticlesByCreateTime", paramMap);
	}

}
