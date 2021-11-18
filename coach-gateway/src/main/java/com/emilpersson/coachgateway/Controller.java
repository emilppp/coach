package com.emilpersson.coachgateway;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class Controller {
    private final TopicProducer topicProducer;
    @GetMapping (value = "/send/{msg}")
    public void send(@PathVariable String msg) {
        topicProducer.send(msg);
    }
}

