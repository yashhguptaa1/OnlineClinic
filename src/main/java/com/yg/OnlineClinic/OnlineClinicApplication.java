package com.yg.OnlineClinic;

import com.yg.OnlineClinic.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OnlineClinicApplication {

	public static void main(String[] args) {
		/*
		press command and hover mouse over .run
		public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class[]{primarySource}, args);
    }
		 */

		ApplicationContext ctx=SpringApplication.run(OnlineClinicApplication.class, args);
		MyController myController=(MyController)ctx.getBean("myController");

		String greeting=myController.Hello();

		System.out.println(greeting);

	}
}
