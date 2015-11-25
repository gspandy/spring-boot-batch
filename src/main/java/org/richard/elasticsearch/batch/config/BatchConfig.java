package org.richard.elasticsearch.batch.config;

import org.richard.elasticsearch.batch.listener.ItemChunkListener;
import org.richard.elasticsearch.batch.processor.CustomItemProcessor;
import org.richard.elasticsearch.batch.reader.CustomItemReader;
import org.richard.elasticsearch.batch.writer.CustomItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created on 11/25/2015.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    //@Autowired CustomItemWriter customItemWriter;

    @Bean
    CustomItemReader customItemReader() {
        CustomItemReader itemReader = new CustomItemReader();
        itemReader.setBookNameList(Arrays.asList("Effective Java",
                "Design Patterns",
                "Refactoring",
                "Thinking in Java",
                "Head First Java"));
        return itemReader;
    }

    @Bean
    CustomItemProcessor customItemProcessor(){
        return new CustomItemProcessor();
    }

    /*@Bean
    CustomItemWriter customItemWriter(){
        return new CustomItemWriter();
    }*/

    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1, JobExecutionListener listener) {
        return jobs.get("importUserJob")
                //.incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, CustomItemReader customItemReader,
                     CustomItemWriter customItemWriter, CustomItemProcessor customItemProcessor,
                      ItemChunkListener chunkListener) {
        return stepBuilderFactory.get("step1")
                .<String, String> chunk(1)
                .reader(customItemReader)
                .processor(customItemProcessor)
                .writer(customItemWriter)
                .listener(chunkListener)
                .build();
    }
}
