package io.s3soft.s3tube.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.s3soft.s3tube.model.VideoInfo;

public interface IVideoInfoDao {
	   public String saveVideo(VideoInfo videoInfo,MultipartFile file);
	   public VideoInfo getVideo(String productId,String path);
	   public List<VideoInfo> getAllVideos();
	   public void deleteVideo(String objectId);
	   public void updateVideo(VideoInfo videoInfo);
}
