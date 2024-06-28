package com.poc.batchjob.batch.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import io.awspring.cloud.sqs.listener.acknowledgement.handler.AcknowledgementMode;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;


@Configuration
public class SqsConfig {
	
    @Bean
    SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder().region(Region.US_WEST_2).build();
    }
    @Bean
    SqsMessageListenerContainerFactory<Object> defaultSqsListenerContainerFactory() {
        return SqsMessageListenerContainerFactory
                .builder()
                .configure(options -> options
                        .acknowledgementMode(AcknowledgementMode.ON_SUCCESS)
                )
                .sqsAsyncClient(sqsAsyncClient())
                .build();
    }
}
