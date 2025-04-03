package com.irayspace.learnsqs.submitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@Service
public class SubmitterService {

    private final static Logger LOG = LoggerFactory.getLogger(SubmitterService.class);

    @Value("${aws.queueName}")
    private String queueName;

    @Autowired
    private SqsClient sqsClient;

    public void sendMessage(SubmitterRequest submitterRequest) {
        final GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder()
            .queueName(queueName)
            .build();
        final String queueUrl = sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl();
        LOG.info("{}", queueUrl);

        final SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
            .queueUrl(queueUrl)
            .messageBody(submitterRequest.message())
            .delaySeconds(5)
            .build();

        final SendMessageResponse response = sqsClient.sendMessage(sendMessageRequest);
        LOG.info("{}", response);
    }

}
