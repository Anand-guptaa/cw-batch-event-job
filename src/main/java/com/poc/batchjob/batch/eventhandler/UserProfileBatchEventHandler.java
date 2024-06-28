package com.poc.batchjob.batch.eventhandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class UserProfileBatchEventHandler {

    @Async
    public void handle(String eventName) {
    	log.info("UserProfileEventHandler::handle:Start: {}", eventName);
        //Integration code will come here
        log.info("UserProfileEventHandler::handle:end");
    }
}