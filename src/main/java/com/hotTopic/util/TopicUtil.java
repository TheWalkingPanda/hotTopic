package com.hotTopic.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ansj.domain.Term;

import com.hotTopic.domain.Article;
import com.hotTopic.domain.Word;

public class TopicUtil {
	
	/**
	 * 取出今天所有文章列表的“词”
	 */
	public static void cluster(List<Article> todayArticles){
		
	}
	
	/**
	 * 更新HistoryTopic（融合或新增话题）
	 */
	public static void updateHistoryTopics(List<Article> todayArticles){
		
	}
	
	/**
	 * 获取今天的热点话题
	 */
	public static List<Article> getTodayHotTopics(){
		
		return null;
	}
	
	/**
	 * 获取指定日期的热点话题
	 */
	public static List<Article> getHotTopics(String arg){
		
		return null;
	}
	
	public static Set<String> readDic(String dicPath){
		Set<String> stopWords = new HashSet<String>();
		try {
			InputStream in = new FileInputStream(dicPath);
			Reader reader = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while((line = br.readLine()) != null){
				stopWords.add(line.trim());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stopWords;
	}
	
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	
	public static String filterWord(Term term){
		if(term.getNatureStr().charAt(0)=='w'){
			return null;
		}
		String word = term.getName();			
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(word);
        word = m.replaceAll("");
		
        Set<String> stopWords = readDic(HotTopicStaticValue.STOP_WORDS_PATH);
        Set<String> noiseWord = readDic(HotTopicStaticValue.NOISE_WORDS_PATH);
        
        if(word.length()<2 || isNumeric(word) || stopWords.contains(word) || noiseWord.contains(word)){
        	return null;
        }
		return word;
	}
	
}
