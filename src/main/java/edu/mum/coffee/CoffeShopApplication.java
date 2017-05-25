package edu.mum.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableSpringWebFlow
//@AnnotationDrivenConfig
@EnableWebMvc
@ComponentScan(basePackages=" edu.mum.coffee")
public class CoffeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeShopApplication.class, args);
	}
}