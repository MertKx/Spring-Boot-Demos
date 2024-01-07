package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//ICityDal ı kullanmak için paketini import ettik
import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import com.javacourse.project.hibernateAndJpa.Repository.ICityRepository;

//Service yani iş katmanı olduğu belli olsun diye ekledik.
@Service
public class CityManager implements ICityService{
	@Autowired
	private ICityRepository cityRepository;
	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	public List<City>getAll(){
		return cityRepository.findAll();
	}
	
	@Override
	@Transactional
	public List<City> getAll() {
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		//burada iş kodları olacaktır. şartlar vs
		this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityDal.getById(id);
	}
}
