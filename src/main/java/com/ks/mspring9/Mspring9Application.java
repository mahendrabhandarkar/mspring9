package com.ks.mspring9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableScheduling
public class Mspring9Application {

	public static void main(String[] args) {
		SpringApplication.run(Mspring9Application.class, args);
	}
	@GetMapping("/?continue")
	public String indexPage(Model model) {
		return "index";
	}
	@GetMapping("/dt")
	public String designTestPage(Model model) {
		return "my/designtest";
	}
}
