package com.glsx.vasp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableSwagger2
@ComponentScan(basePackages = {
        "com.glsx.vasp.eshop",
        "com.glsx.vasp.weixin",
        "com.glsx.vasp.framework"
})
@EnableJpaRepositories(basePackages = "com.glsx.vasp.*.repository")
@EnableTransactionManagement
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class MobileConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileConsumerApplication.class, args);
    }

}
