package com.poc.batchjob.batch.event;

import org.springframework.stereotype.Component;

import com.poc.batchjob.batch.eventhandler.UserProfileBatchEventHandler;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserProfileEventListener {

	private final UserProfileBatchEventHandler userProfileBatchEventHandler;
	
	
	@SqsListener(value = "USER-PROFILE-QUEUE", pollTimeoutSeconds = "5" )
	public void queueListener(String message) {
		log.info("UserProfileEventListener::queueListener:Start");
		userProfileBatchEventHandler.handle(message);
		log.info("UserProfileEventListener::queueListener:END");
	}

}
