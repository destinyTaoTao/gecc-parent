package com.glsx.vasp.test;//package com.hflw.vasp.admin;

import com.glsx.vasp.mq.ProducerApplication;
import com.glsx.vasp.mq.producer.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @Autowired
    private KafkaSender sender;

    @Test
    public void test() {
        sender.send("this a test!");
    }

}