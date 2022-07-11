package com.triple.homework.board.domain;

import java.util.Date;

public class Point_hstVO {
	
	private String user_id;
	private int hst_sq;
	private String review_id;
	private String place_id;
	private int change_point;
	private Date review_tm;
	private String change_status;
	
	public String getChange_status() {
		return change_status;
	}
	public void setChange_status(String change_status) {
		this.change_status = change_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getHst_sq() {
		return hst_sq;
	}
	public void setHst_sq(int hst_sq) {
		this.hst_sq = hst_sq;
	}
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public int getChange_point() {
		return change_point;
	}
	public void setChange_point(int change_point) {
		this.change_point = change_point;
	}
	public Date getReview_tm() {
		return review_tm;
	}
	public void setReview_tm(Date review_tm) {
		this.review_tm = review_tm;
	}
}
