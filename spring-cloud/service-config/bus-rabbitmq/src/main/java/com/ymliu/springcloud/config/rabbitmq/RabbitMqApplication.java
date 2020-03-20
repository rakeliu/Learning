package com.ymliu.springcloud.config.rabbitmq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过总线通知，自动刷新配置变更。
 *
 * @author LYM
 * @version 1.0
 * @date 2020-3-19
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
public class RabbitMqApplication
{
	private static final Logger logger = LogManager.getLogger(RabbitMqApplication.class);

	@Value("${foo}")
	String foo;

	public static void main(String[] args)
	{
		logger.info("启动总线通知刷新...");
		SpringApplication.run(RabbitMqApplication.class);
	}

	@RequestMapping(value = "/hi")
	public String hi()
	{
		return foo;
	}
}
