package com.javacourse.project.hibernateAndJpa.RESTApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.*;

//REST controller olması için bu anotasyonu ekledim
@RestController
//Bu classtaki tüm operasyonlar localhost3306/api ile başlayacak
@RequestMapping("/api")
public class CityController {
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {	
		this.cityService = cityService;
	}
	
	//localhost3306/api/cities dediğinde gelicek burası
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.getAll();
	}
	//GetMapping kullandık ama burada yalnızca veriyi çektik
	//ekleme gibi operasyonlarda işler değişecektir.
	
	@PostMapping("/add")
	//City öğesini gövdeden çekmek için anotasyon kullandık
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){
		return cityService.getById(id)
	}
}
