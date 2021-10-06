package com.spring.udong.club.vo;

import org.springframework.stereotype.Component;

@Component("clubVO")
public class ClubVO {
	private int group_id;
	private String group_name;
	private String group_category;
	private String group_info;
	
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGroup_info() {
		return group_info;
	}
	public void setGroup_info(String group_info) {
		this.group_info = group_info;
	}
	
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
