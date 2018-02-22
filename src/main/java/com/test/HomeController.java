package com.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World2";
    }
    
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getEmployee() throws RestClientException, IOException {
		System.out.println("111111111111");
		String baseUrl = "http://employee:8080/employee";
		System.out.println("4444e");
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println("22222222222222");
			System.out.println(ex);
		}
		System.out.println("333333333333333");
		System.out.println(response.getBody());
		String abc=response.getBody();
		return(abc);
	}
	
	@RequestMapping(value = "/show2", method = RequestMethod.GET)
	public String getEmployee2() throws RestClientException, IOException {
		System.out.println("111111111111");
		String baseUrl2 = "http://employee/employee";
		System.out.println("4444e");
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response2=null;
		try{
		response2=restTemplate.exchange(baseUrl2,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println("22222222222222");
			System.out.println(ex);
		}
		System.out.println("333333333333333");
		System.out.println(response2.getBody());
		String abc2=response2.getBody();
		return(abc2);
	}
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}