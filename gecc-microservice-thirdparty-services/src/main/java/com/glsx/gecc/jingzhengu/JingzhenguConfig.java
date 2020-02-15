package com.glsx.gecc.jingzhengu;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
//@ConfigurationProperties(prefix = "jingzhengu")
public class JingzhenguConfig {

    @Value("${jingzhengu.partnerId}")
    private String partnerId;

    @Value("${jingzhengu.key}")
    private String key;

    @Value("${jingzhengu.url}")
    private String url;

    @Value("${jingzhengu.guzhi.url}")
    private String guzhiUrl;

}
