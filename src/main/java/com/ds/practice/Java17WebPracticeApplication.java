package com.ds.practice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.practice.domain.Customer;
/**
 * 
 * @author d2s
 *
 */
@RestController
@SpringBootApplication
public class Java17WebPracticeApplication {

	private static Map<Long, Customer> customerSaved = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Java17WebPracticeApplication.class, args);
	}

	@GetMapping("/customers/{custId}")
	public Customer getCustomerById(@PathVariable("custId") Long custId) {

		return customerSaved.get(custId);
	}

	@GetMapping("/customers")
	public Collection<Customer> getAllCustomers() {

		return customerSaved.values();
	}

	@PostMapping("/customers")
	public void save(@RequestBody Customer customer) {
		customerSaved.put(customer.getId(), customer);

	}

}
