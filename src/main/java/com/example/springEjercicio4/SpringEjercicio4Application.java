package com.example.springEjercicio4;

import com.example.springEjercicio4.entities.Laptop;
import com.example.springEjercicio4.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringEjercicio4Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringEjercicio4Application.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Dell", "XPS", 15.6F);
		Laptop laptop2 = new Laptop(null, "Razer", "Blade", 17);
		repository.save(laptop1);
		repository.save(laptop2);
	}

}
