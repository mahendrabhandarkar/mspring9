package com.ks.mspring9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Mspring9Application {

	public static void main(String[] args) {
		SpringApplication.run(Mspring9Application.class, args);
	}
	@GetMapping("/?continue")
	public String indexPage(Model model) {
		return "index";
	}
}
