package com.javacourse.project.hibernateAndJpa.Entities;
import jakarta.persistence.*;

//Entity anotasyonu bunun bir veritabanı verisi olduğunu gösterir.
@Entity
//Table anotasyonu veritabanında (yoksa) bir tablo oluşturur.
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="city")
	private String city;
	
	public City() {}
	
	public City(Long id, String city) {
		this.id = id;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}
}