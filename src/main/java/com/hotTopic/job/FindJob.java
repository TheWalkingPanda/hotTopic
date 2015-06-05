package com.hotTopic.job;

import java.util.List;

import com.hotTopic.domain.Article;
import com.hotTopic.service.interfaces.IArticleService;
import com.hotTopic.util.TopicUtil;

public class FindJob {
	private IArticleService articleService;
	
	public void progress(){
		//取出今天所有的Article
		List<Article> todayArticles = articleService.getTodayArticles();
		
		//取出todayArticles 的“词”
		TopicUtil.cluster(todayArticles);
		
		//df过程
		
		//**过程
		
		//获得当天话题
		
		//更新HistoryTopic（融合或新增话题）
		TopicUtil.updateHistoryTopics(todayArticles);
		
		//获取今天的热点话题
		List<Article> todayHotTopics = TopicUtil.getTodayHotTopics();
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}
