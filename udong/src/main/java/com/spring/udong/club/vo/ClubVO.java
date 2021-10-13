package com.spring.udong.club.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("clubVO")
public class ClubVO {
	private int group_id;
	private String group_name;
	private String group_category;
	private String group_info;
	private Date group_date;
	private String group_leader;
	
	public String getGroup_leader() {
		return group_leader;
	}
	public void setGroup_leader(String group_leader) {
		this.group_leader = group_leader;
	}
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
	public Date getGroup_date() {
		return group_date;
	}
	public void setGroup_date(Date group_date) {
		this.group_date = group_date;
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
