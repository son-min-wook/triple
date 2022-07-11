package com.triple.homework.board.domain;

import java.util.Date;

public class Review_mstVO {
	
	private String review_id;
	private String user_id;
	private String place_id;
	private Date review_tm;
	private String review_txt;
	
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public Date getReview_tm() {
		return review_tm;
	}
	public void setReview_tm(Date review_tm) {
		this.review_tm = review_tm;
	}
	public String getReview_txt() {
		return review_txt;
	}
	public void setReview_txt(String review_txt) {
		this.review_txt = review_txt;
	}
}
