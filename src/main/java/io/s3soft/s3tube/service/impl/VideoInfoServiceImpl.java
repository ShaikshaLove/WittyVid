package io.s3soft.s3tube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.s3soft.s3tube.dao.IVideoInfoDao;
import io.s3soft.s3tube.model.VideoInfo;
import io.s3soft.s3tube.service.IVideoInfoService;
@Service
public class VideoInfoServiceImpl implements IVideoInfoService{
	@Autowired
	private IVideoInfoDao dao;
	@Override
	public String saveVideo(VideoInfo videoInfo, MultipartFile file) {
		return dao.saveVideo(videoInfo, file);
	}

	@Override
	public VideoInfo getVideo(String productId, String path) {
		return null;
	}

	@Override
	public List<VideoInfo> getAllVideos() {
		return dao.getAllVideos();
	}

	@Override
	public void deleteVideo(String objectId) {

	}

	@Override
	public void updateVideo(VideoInfo videoInfo) {

	}

}
