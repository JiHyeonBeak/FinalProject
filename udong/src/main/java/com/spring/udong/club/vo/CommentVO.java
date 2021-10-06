package com.spring.udong.club.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("commentVO")
public class CommentVO {
	private int articleNo;
	private String articleTitle;
	private String articleContent;
	private int articleLike;
	private int articleHate;
	private Date wdate;
	private String articleId;
	
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
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
