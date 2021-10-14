package com.spring.udong.club.vo;

import org.springframework.stereotype.Component;

@Component("joinVO")
public class JoinVO {
	private int group_id;
	private String id;
	
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
