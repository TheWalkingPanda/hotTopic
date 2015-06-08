package com.hotTopic.domain;

import java.util.List;
import java.util.Map;

public class SysResult {
	private List<ArticleExt> articleExts;
	private Map<String, Integer> wordsDF;
	private List<Topic> topics;
	
	public List<ArticleExt> getArticleExts() {
		return articleExts;
	}
	public void setArticleExts(List<ArticleExt> articleExts) {
		this.articleExts = articleExts;
	}
	public Map<String, Integer> getWordsDF() {
		return wordsDF;
	}
	public void setWordsDF(Map<String, Integer> wordsDF) {
		this.wordsDF = wordsDF;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
}
