package com.irayspace.learnsqs2.poller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.irayspace.learnsqs2.queue.QueueService;

import software.amazon.awssdk.services.sqs.model.Message;

@Component
public class PollerTask {

    private static final Logger LOG = LoggerFactory.getLogger(PollerTask.class);

    @Autowired
    private QueueService queueService;

    @Scheduled(fixedRate = 10000)
    public void pollQueue() {
        final List<Message> messages = queueService.pollQueue();
        LOG.info("Polled queue, found {} messages", messages.size());
        messages.stream().forEach(message -> {
            try {
                processMessage(message);
            } catch (Exception e) {
                handleError(message, e);
            }
        });
    }

    private void processMessage(Message message) throws Exception {
        LOG.info("Processing: {}", message.body());

        // TODO: Logic for processing here
        Thread.sleep(1000);

        queueService.deleteMessage(message);        
        LOG.info("Finished, deleted message: {}", message.body());
    }

    private void handleError(Message message, Exception e) {
        LOG.error("Failed: {}, Error: {}", message, e);
    }
}
