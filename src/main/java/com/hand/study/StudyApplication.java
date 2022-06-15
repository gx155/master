package com.hand.study;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
/**
 * 资金调拨单管理
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-13 11:05:22
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableChoerodonResourceServer
public class StudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }
}