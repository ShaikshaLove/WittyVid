package io.s3soft.s3tube.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.database}")
    private String database;
	@Value("${spring.data.mongodb.uri}")
    private String uri;
	
	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	public MongoClient mongoClient() {
		return MongoClients.create(uri);
	}

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
}