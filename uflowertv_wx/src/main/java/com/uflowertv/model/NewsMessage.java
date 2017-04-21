package com.uflowertv.model;

import lombok.Data;
import org.nutz.lang.Lang;

import java.util.List;
public class NewsMessage extends SendCustom{
	
	private NewsMessage news;
	private List<News> articles;

	public NewsMessage getNews() {
		return news;
	}

	public void setNews(NewsMessage news) {
		this.news = news;
	}

	public List<News> getArticles() {
		if (!Lang.isEmpty(articles) && articles.size() > 8) {
			this.articles = articles.subList(0, 8);
		}
		return articles;
	}

	public void setArticles(List<News> articles) {
		this.articles = articles;
	}
}
