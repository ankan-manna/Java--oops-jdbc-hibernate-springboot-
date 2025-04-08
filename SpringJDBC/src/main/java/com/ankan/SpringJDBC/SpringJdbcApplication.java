package com.ankan.SpringJDBC;

import com.ankan.SpringJDBC.model.Developer;
import com.ankan.SpringJDBC.repository.DeveloperRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

	ApplicationContext context= SpringApplication.run(SpringJdbcApplication.class, args);
		Developer developer = new Developer();
		//Developer developer = context.getBean(Developer.class);
		developer.setId(111);
		developer.setName("Ankan");
		developer.setTech("Spring JDBC");


		DeveloperRepo developerRepo = context.getBean(DeveloperRepo.class);
		developerRepo.save(developer);
		System.out.println(developerRepo.findAll());
	}

}
