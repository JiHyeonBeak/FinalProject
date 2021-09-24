package com.spring.udong.club.vo;

import org.springframework.stereotype.Component;

@Component("commentVO")
public class CommentVO {
	private int article_no;
	private String article_title;
	private String article_content;
	private int article_like;
	private int article_hate;
	
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public int getArticle_like() {
		return article_like;
	}
	public void setArticle_like(int article_like) {
		this.article_like = article_like;
	}
	public int getArticle_hate() {
		return article_hate;
	}
	public void setArticle_hate(int article_hate) {
		this.article_hate = article_hate;
	}
	
}
