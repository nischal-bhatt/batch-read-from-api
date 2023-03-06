package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerClass {

	@GetMapping("/getAll")
	public List<Customer> getAll()
	{
		List<Customer> a = new ArrayList<>();
		
		Customer a1 = new Customer();
		a1.setId(1234);
		
		Customer a2 = new Customer();
		a2.setId(2222);
		
		Customer a3 = new Customer();
		a3.setId(666);
		
		Customer a4 = new Customer();
		a4.setId(6667);
		
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		
		return a;
		
		
	}
}
