package com.emilpersson.coachbackend;

import com.emilpersson.coachbackend.model.Round;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class Consumer {

    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "coach.topic", groupId = "group_one", containerFactory = "kafkaListenerContainerFactory")
    public void consumeUserMessage(@Payload Round msg, @Headers MessageHeaders headers) throws IOException {
        LOGGER.info("Received: {}", msg);
    }
}


