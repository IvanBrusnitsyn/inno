package edu.innotech.inno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@SpringBootApplication
public class InnoApplication {
	public static void main(String[] args) {
		SpringApplication.run(InnoApplication.class, args);
	}
}