package com.glsx.vasp.mq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaSender sender;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send(String param) {
        sender.send(param);
    }

}
