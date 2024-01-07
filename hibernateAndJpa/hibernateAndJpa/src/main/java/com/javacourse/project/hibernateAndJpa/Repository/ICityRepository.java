package com.javacourse.project.hibernateAndJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacourse.project.hibernateAndJpa.Entities.City;

public interface ICityRepository extends JpaRepository<City, Long>{

}
