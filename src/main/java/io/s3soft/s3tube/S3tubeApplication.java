package io.s3soft.s3tube;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import io.s3soft.s3tube.filters.CorsFilter;

@SpringBootApplication
public class S3tubeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(S3tubeApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> freg=new FilterRegistrationBean<CorsFilter>();
		freg.setFilter(new CorsFilter());
		ArrayList<String> al=new ArrayList<>();
		al.add("/*");
		freg.setUrlPatterns(al);
		return freg;
	}
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(S3tubeApplication.class);
	}

}
