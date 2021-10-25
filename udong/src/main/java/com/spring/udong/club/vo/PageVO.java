package com.spring.udong.club.vo;

import org.springframework.stereotype.Component;

@Component("pageVO")
public class PageVO {
	private int nowPage,startPage,endPage,total,perPage,lastPage;
	private int end = 6;
	private int start = 0;
	private int cntPage = 5;
	
	public PageVO(){
		
	}
	
	public PageVO(int total, int nowPage, int perPage) {
		setNowPage(nowPage);
		setPerPage(perPage);
		setTotal(total);
		calcLastPage(getTotal(),getPerPage());
		calcStartEndPage(getNowPage(),cntPage);
		calcStartEnd(nowPage, perPage);
	}
	
	public void calcStartEnd(int nowPage, int perPage) {
		int end = nowPage * perPage;
		setEnd(end);
		setStart(getEnd() - perPage + 1);
		
	}

	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if(getStartPage() < 1) {
			setStartPage(1);
		}
	}

	public void calcLastPage(int total, int perPage) {
		setLastPage((int)Math.ceil((double)total / (double) perPage));
	}



	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCntPage() {
		return cntPage;
	}
	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	
}
