package com.student.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootApplication
public class StudentComApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(StudentComApplication.class, args);
		/**
		 * get ip address
		 */
		//	System.out.println("IP-"+Inet4Address.getLocalHost().getHostAddress());
	}

}
