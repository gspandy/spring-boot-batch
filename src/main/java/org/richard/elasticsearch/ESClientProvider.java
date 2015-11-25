package org.richard.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 11/25/2015.
 */
//@Configuration
public class ESClientProvider implements InitializingBean, DisposableBean {
    private Client client;

    @Override
    public void destroy() throws Exception {
        client.close();
    }

    @Bean
    Client client() {
        return client;
    }

   /* @Beanpublic ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", "boole-cluster").build();
        client = new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));

    }
}
