package com.yg.OnlineClinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineClinicApplication {

	public static void main(String[] args) {
		/*
		press command and hover mouse over .run
		public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class[]{primarySource}, args);
    }
		 */

		SpringApplication.run(OnlineClinicApplication.class, args);



	}
}
