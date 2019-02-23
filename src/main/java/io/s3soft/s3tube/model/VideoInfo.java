package io.s3soft.s3tube.model;

import java.util.Date;

public class VideoInfo {
	private String videoId;
	private String videoName;
	private Date uploadDate;
	private Date lastModifiedDate;
	private String description;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public VideoInfo() {
		super();
	}
	public VideoInfo(String videoId, String videoName, Date uploadDate, Date lastModifiedDate, String description) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.uploadDate = uploadDate;
		this.lastModifiedDate = lastModifiedDate;
		this.description = description;
	}
}
