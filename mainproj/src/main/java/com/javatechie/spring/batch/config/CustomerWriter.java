package com.javatechie.spring.batch.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;

import com.javatechie.spring.batch.entity.Customer;

public class CustomerWriter implements ItemWriter<Customer>{

private String url = "http://localhost:8080/getAll";
    
    RestTemplate r = new RestTemplate();

	@Override
	public void write(List<? extends Customer> items) throws Exception {
		for(int i =0; i<items.size(); i++)
		{
			System.out.println(items.get(i));
		}
		
	}

	

	

	
	

}
