package org.richard.elasticsearch;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 11/25/2015.
 */

@Configuration
@SpringBootApplication
public class ApplicationConfig implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

  /*  @Autowired
    Client client;*/

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*logger.debug("Started successfully.");
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

        IndexResponse response = client.prepareIndex("twitter", "tweet")
                .setSource(json)
                .get();

        // Index name
        String _index = response.getIndex();
// Type name
        String _type = response.getType();
// Document ID (generated or not)
        String _id = response.getId();
// Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
// isCreated() is true if the document is a new one, false if it has been updated
        boolean created = response.isCreated();

        logger.debug("Response from Indexing: _Index: {},\n _Type: {},\n _Id: {},\n Created: {},\n _version: {}",
                _index, _type, _id, created, _version);*/
    }
}
