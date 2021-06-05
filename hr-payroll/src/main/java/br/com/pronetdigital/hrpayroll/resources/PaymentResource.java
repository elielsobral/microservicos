package br.com.pronetdigital.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pronetdigital.hrpayroll.entities.Payment;
import br.com.pronetdigital.hrpayroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{workerId}/days/{days}")
	@CircuitBreaker(name = "get", fallbackMethod = "getPaymentAlternative")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days, Throwable t) {
		Payment payment = new Payment("Circuit Breaker", 400.0, days);
		return ResponseEntity.ok(payment);
	}

}
