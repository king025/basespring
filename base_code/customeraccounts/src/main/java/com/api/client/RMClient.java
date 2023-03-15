package com.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "${client.rm.name}", url = "${client.rm.url}")
public interface RMClient {
	
//	@PostMapping("/inqRMTrailers2")
//	Object inqRMTrailers2(@RequestBody RMRequest rmRequest);
    @GetMapping("/employees")
    Object inqRMTrailers2();

}
