package com.springboot.demo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ProductsController {
	
	@GetMapping("/")
	public String get() {
		return "Denendi, onaylandı";
	}
	@GetMapping("/products")
	public String get2() {
		return "Denendi, onaylandı ve ikinci işleme geçti.";
	}
}
