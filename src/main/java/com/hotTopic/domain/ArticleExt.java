package com.hotTopic.domain;

import java.util.Map;

public class ArticleExt {
	private int id;
	private Map<String, Word> words;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Word> getWords() {
		return words;
	}
	public void setWords(Map<String, Word> words) {
		this.words = words;
	}
}
