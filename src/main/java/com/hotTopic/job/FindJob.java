package com.hotTopic.job;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotTopic.domain.Article;
import com.hotTopic.service.interfaces.IArticleService;

public class FindJob {
	
	@Autowired
	private IArticleService articleService;
	
	public void progress(){
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		IArticleService articleService = ac.getBean(IArticleService.class);
		List<Article> todayArticles = articleService.getArticlesByDay("2015-06-05");
		System.out.println(todayArticles.size());
	}
}
