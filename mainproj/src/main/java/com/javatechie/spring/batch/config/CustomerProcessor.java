package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Customer;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        if(customer.getCountry().equals("United States")) {
        	customer.setId(ThreadLocalRandom.current().nextInt(0, 1000000));
        	customer.setEmail("iamccc@iamnish.com");
            return customer;
        }else{
            return null;
        }
    }
}
