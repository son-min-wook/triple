package com.triple.homework.board.domain;

import java.util.Date;
import java.util.List;

public class ReviewVO {
	
	private String type;
	private String action;
	private String review_id;
	private String user_id;
	private String place_id;
	private Date review_tm;
	private String content;
	private int img_sq;
	private List<String> attachedPhotoIds;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImg_sq() {
		return img_sq;
	}
	public void setImg_sq(int img_sq) {
		this.img_sq = img_sq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<String> getAttachedPhotoIds() {
		return attachedPhotoIds;
	}
	public void setAttachedPhotoIds(List<String> attachedPhotoIds) {
		this.attachedPhotoIds = attachedPhotoIds;
	}

}
