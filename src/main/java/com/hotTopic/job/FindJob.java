package com.hotTopic.job;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotTopic.domain.Article;
import com.hotTopic.domain.ArticleExt;
import com.hotTopic.domain.SysResult;
import com.hotTopic.domain.Word;
import com.hotTopic.service.interfaces.IArticleService;
import com.hotTopic.util.TopicUtil;

public class FindJob {
	
	@Autowired
	private IArticleService articleService;
	
	public void progress(String date){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		IArticleService articleService = ac.getBean(IArticleService.class);
		try {
			List<Article> todayArticles = articleService.getArticlesByDay(date);
			SysResult sysResult = new SysResult();
			
			List<ArticleExt> articleExts = new ArrayList<ArticleExt>();
			for(Article article : todayArticles){
				ArticleExt resultArticleExt = articleHandle(article);
				articleExts.add(resultArticleExt);
			}
			sysResult.setArticleExts(articleExts);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对文章进行分词，并计算每个Word的tf
	 */
	public ArticleExt articleHandle(Article article){
		ArticleExt articleExt = new ArticleExt();
		articleExt.setId(article.getId());
		
		List<Term> terms = NlpAnalysis.parse(article.getContent());
		
		Map<String, Word> wordsMap = new HashMap<String, Word>();
		for(Term term : terms){
			String word = TopicUtil.filterWord(term);
			if(word == null){
				continue;
			}
			if(wordsMap.containsKey(word)){
				Word wordObj = wordsMap.get(word);
				wordObj.setTF(wordObj.getTF()+1);
			}else{
				Word newWord = new Word();
				newWord.setValue(word);
				newWord.setTF(1);
				
				wordsMap.put(word, newWord);
			}
		}
		articleExt.setWords(wordsMap);
		return articleExt;
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		FindJob findJob = new FindJob();
		findJob.progress("2015-06-05");
	}
}
