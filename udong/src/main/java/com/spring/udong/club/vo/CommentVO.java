package com.spring.udong.club.vo;

import org.springframework.stereotype.Component;

@Component("commentVO")
public class CommentVO {
	private int articleNo;
	private String articleTitle;
	private String articleContent;
	private int articleLike;
	private int articleHate;
	
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public int getArticleLike() {
		return articleLike;
	}
	public void setArticleLike(int articleLike) {
		this.articleLike = articleLike;
	}
	public int getArticleHate() {
		return articleHate;
	}
	public void setArticleHate(int articleHate) {
		this.articleHate = articleHate;
	}
	
}
