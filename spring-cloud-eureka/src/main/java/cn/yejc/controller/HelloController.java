package cn.yejc.controller;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Resource
	private DiscoveryClient client;
	
	@RequestMapping(value = "/hello")
	public String index() {
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return "hello";
	}
}
