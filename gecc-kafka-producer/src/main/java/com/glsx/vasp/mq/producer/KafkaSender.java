package com.glsx.vasp.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息方法
    public void send(String body) {
        kafkaTemplate.send("testTopic", body);
        log.info("发送消息完成,内容 为:" + body);
    }

}
