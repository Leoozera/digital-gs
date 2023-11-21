package com.fiap.gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication()
public class GsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsApplication.class, args);
	}

}
