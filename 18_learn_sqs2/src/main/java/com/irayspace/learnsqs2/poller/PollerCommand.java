package com.irayspace.learnsqs2.poller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.irayspace.learnsqs2.queue.QueueService;

import software.amazon.awssdk.services.sqs.model.Message;

@ShellComponent
public class PollerCommand {

    private static final Logger LOG = LoggerFactory.getLogger(PollerCommand.class);

    @Autowired
    private QueueService queueService;

    // @ShellMethod(key = "poll")
    // public Object pollSqs() {
    //     final List<Message> messages = queueService.pollQueue();
    //     messages.forEach(message -> {
    //         processMessage(message);
    //     });
    //     return messages;
    // }

    private void processMessage(Message message) {
        LOG.info("Processing {}", message.body());
        queueService.deleteMessage(message);
    }

}
