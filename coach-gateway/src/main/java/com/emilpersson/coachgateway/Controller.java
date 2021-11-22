package com.emilpersson.coachgateway;

import com.emilpersson.coachgateway.model.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class Controller {

    @Autowired
    private final TopicProducer topicProducer;

    @PostMapping(value = "/send")
    public void send(@RequestBody Round round) {
        this.topicProducer.send(round);
    }
}

