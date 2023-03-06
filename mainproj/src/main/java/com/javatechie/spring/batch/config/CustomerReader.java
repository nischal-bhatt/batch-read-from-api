package com.javatechie.spring.batch.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.javatechie.spring.batch.entity.Customer;

public class CustomerReader implements ItemReader<Customer> {

	

	String url;
	RestTemplate r;
	
	private List<Customer> studentData;
	
	 private int nextStudentIndex;

	public CustomerReader(String url, RestTemplate restTemplate)
	{
		this.r = restTemplate;
		this.url = url;
		this.nextStudentIndex = 0;
		
	}
	
	
	@Override
	 public Customer read() throws Exception {
        if (studentDataIsNotInitialized()) {
            studentData = fetchStudentDataFromAPI();
        }
 
        Customer nextStudent = null;
 
        if (nextStudentIndex < studentData.size()) {
            nextStudent = studentData.get(nextStudentIndex);
            nextStudentIndex++;
        }
        else {
            nextStudentIndex = 0;
            studentData = null;
        }
 
        return nextStudent;
    }
 
    private boolean studentDataIsNotInitialized() {
        return this.studentData == null;
    }
 
    private List<Customer> fetchStudentDataFromAPI() {
        ResponseEntity<Customer[]> response = r.getForEntity(url,
                Customer[].class
        );
        Customer[] studentData = response.getBody();
        return Arrays.asList(studentData);
    }
		
		
		
		

	}

