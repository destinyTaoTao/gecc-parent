package com.glsx.vasp.admin.modules;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-provider")
public interface HelloService {

    @RequestMapping("/test")
    String hello(@RequestParam String param);

}
