package com.uflowertv.model;

import lombok.Data;
import org.nutz.lang.Lang;

import java.util.List;
@Data
public class NewsMessage extends SendCustom{
	
	private NewsMessage news;
	private List<News> articles;

	public List<News> getArticles() {
		if (!Lang.isEmpty(articles) && articles.size() > 8) {
	        this.articles = articles.subList(0, 8);
	    }
		return articles;
	}
}
