package io.s3soft.s3tube.dao.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;

import io.s3soft.s3tube.dao.IVideoInfoDao;
import io.s3soft.s3tube.model.VideoInfo;
@Repository
public class VideoInfoImpl implements IVideoInfoDao,ServletContextAware{
	private ServletContext servletContext;
	@Autowired
	private GridFsOperations operations;
	
	@Override
	public String saveVideo(VideoInfo videoInfo, MultipartFile file) {
		
		videoInfo.setVideoId((UUID.randomUUID().toString().replace("-", "").substring(1, 8)));
		InputStream is=null;
		try {
			is=file.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operations.store(is,file.getOriginalFilename(),file.getContentType(), videoInfo).toString();
	}

	@Override
	public VideoInfo getVideo(String productId, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoInfo> getAllVideos() {
		List<VideoInfo> videos=new ArrayList<VideoInfo>();
		InputStream is;
		String path=servletContext.getRealPath("/");

		GridFSFindIterable files=operations.find(new Query(GridFsCriteria.whereContentType().is("video/mp4")));
		MongoCursor<GridFSFile> cursors=files.iterator();
		while(cursors.hasNext()) {
			GridFSFile file=cursors.next();
			// creating product object and adding it to ArrayList
			Document document=file.getMetadata();
			VideoInfo vidInfo=new VideoInfo();
			vidInfo.setVideoName("./videos/"+document.get("videoName").toString());
			vidInfo.setVideoId(document.get("videoId").toString());
			vidInfo.setDescription(document.get("description").toString());
			vidInfo.setUploadDate(file.getUploadDate());
			videos.add(vidInfo);

			//saving file at /webapp/videos
			try {
				is=operations.getResource(file).getInputStream();	
				File directory=new File(path,"videos");
				if(!directory.exists()) {
					directory.mkdir();
				}
				File video=new File(directory,document.get("videoName").toString());
				if(!video.exists()) {
					video.createNewFile();
				    @SuppressWarnings("resource")
				    FileOutputStream fos=new FileOutputStream(video);
			     	int i=is.read();
				    while(i!=-1) {
					   fos.write(i);
					   i=is.read();
				    }

				   fos.flush();		
				}

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return videos;
	}

	@Override
	public void deleteVideo(String objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVideo(VideoInfo videoInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;		
	}

}
