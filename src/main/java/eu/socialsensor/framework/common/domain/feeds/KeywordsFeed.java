package eu.socialsensor.framework.common.domain.feeds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;
import eu.socialsensor.framework.common.domain.Keyword;

public class KeywordsFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054548274586004413L;

	@Expose
    @SerializedName(value = "keywords")
	private List<Keyword> keywords = new ArrayList<Keyword>();
	
	@Expose
    @SerializedName(value = "keyword")
	private Keyword keyword;
	
	private List<String> queryKeywords = new ArrayList<String>();
	
	public KeywordsFeed(Keyword keyword, Date since, String id) {
		super(since, Feed.FeedType.KEYWORDS);
		this.keyword = keyword;
		this.id = id;
		
	}
	
	public KeywordsFeed(List<String> keywords, Date since, String id) {
		super(since, Feed.FeedType.KEYWORDS);
		for(String key : keywords) {
			this.keywords.add(new Keyword(key, 0.0f));
		}
		
		this.id = id;
	}

	public Keyword getKeyword() {
		return this.keyword;
	}
	
	public List<Keyword> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<Keyword> keywords) {
		this.keywords.clear();
		this.keywords.addAll(keywords);
	}

	public void setQueryKeywords(List<String> queryKeywords) {
		this.queryKeywords = queryKeywords;
	}
	
	public void addQueryKeywords(List<String> queryKeywords) {
		this.queryKeywords.addAll(queryKeywords);
	}
	
	public void addQueryKeyword(String queryKeyword) {
		this.queryKeywords.add(queryKeyword);
	}
	
	public List<String> getQueryKeywords() {
		return queryKeywords;
	}
	
}
