package com.spring.udong.club.vo;

import org.springframework.stereotype.Component;

@Component("clubVO")
public class ClubVO {
	private String group_name;
	private String group_category;
	
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_category() {
		return group_category;
	}
	public void setGroup_category(String group_category) {
		this.group_category = group_category;
	}

}
