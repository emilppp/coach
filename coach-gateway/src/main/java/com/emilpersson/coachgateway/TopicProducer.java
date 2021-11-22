package com.emilpersson.coachgateway;

import com.emilpersson.coachgateway.model.Round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class TopicProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducer.class);
    private static final String TOPIC = "coach.topic";

    @Autowired
    private KafkaTemplate<String, Round> kafkaTemplate;

    public void send(Round msg) {
        LOGGER.info(String.format("\n ===== Producing message in JSON ===== \n"+msg));
        Message<Round> message = MessageBuilder
                .withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();
        this.kafkaTemplate.send(message);
    }

}