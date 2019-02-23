package io.s3soft.s3tube.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.s3soft.s3tube.model.VideoInfo;
import io.s3soft.s3tube.service.IVideoInfoService;

@RestController
@RequestMapping("/api/videos")
public class VideoResource {
	@Autowired
	private IVideoInfoService videoInfoService;
	
	@PostMapping(produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveVideo(@ModelAttribute VideoInfo videoInfo,@RequestParam("video")MultipartFile file) {
	    videoInfo.setVideoName(file.getOriginalFilename());
		String id=videoInfoService.saveVideo(videoInfo, file);
		return new ResponseEntity<String>("The video has been uploaded successfully with id "+id,HttpStatus.CREATED);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VideoInfo>> getAllProducts(){
		return new ResponseEntity<List<VideoInfo>>(videoInfoService.getAllVideos(),HttpStatus.OK);
	}

}
