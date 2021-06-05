package br.com.pronetdigital.hrpayroll.feignclients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pronetdigital.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
@LoadBalancerClient(name = "hr-worker")
public interface WorkerFeignClient {

	@LoadBalanced
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);

}
