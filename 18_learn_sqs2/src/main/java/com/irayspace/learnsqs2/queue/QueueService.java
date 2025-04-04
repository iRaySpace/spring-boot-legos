package com.irayspace.learnsqs2.queue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageResponse;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

@Service
public class QueueService {

    private static final int MAX_NUMBER_OF_MESSAGES = 5;
    private static final int WAIT_TIME_SECONDS = 5;

    @Autowired
    private SqsClient sqsClient;

    @Value("${aws.queueName}")
    private String queueName;

    public List<Message> pollQueue() {
        final ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(getQueueUrl())
                .maxNumberOfMessages(MAX_NUMBER_OF_MESSAGES)
                .waitTimeSeconds(WAIT_TIME_SECONDS)
                .build();
        return sqsClient.receiveMessage(receiveMessageRequest).messages();
    }

    public DeleteMessageResponse deleteMessage(Message message) {
        final DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
            .queueUrl(getQueueUrl())
            .receiptHandle(message.receiptHandle())
            .build();
        return sqsClient.deleteMessage(deleteMessageRequest);
    }

    private String getQueueUrl() {
        final GetQueueUrlResponse getQueueUrlResponse = sqsClient
                .getQueueUrl(GetQueueUrlRequest.builder().queueName(queueName).build());
        return getQueueUrlResponse.queueUrl();
    }

}
