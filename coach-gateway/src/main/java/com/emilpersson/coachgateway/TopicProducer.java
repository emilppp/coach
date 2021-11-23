package com.emilpersson.coachgateway;

import com.emilpersson.coachgateway.model.Round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${producer.kafka.topic}")
    private String topic;
    
    private final KafkaTemplate<String, Round> kafkaTemplate;

    public TopicProducer(KafkaTemplate<String, Round> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    } 

    public void send(Round msg) {
        LOGGER.info("\n ===== Producing message in JSON ===== \n" +
                "{}", msg);
        Message<Round> message = MessageBuilder
                .withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        this.kafkaTemplate.send(message);
    }

}