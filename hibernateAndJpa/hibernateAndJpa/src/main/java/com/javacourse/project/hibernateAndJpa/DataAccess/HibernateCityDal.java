package com.javacourse.project.hibernateAndJpa.DataAccess;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//City classını kullanmak için entities paketini import ettik.
import com.javacourse.project.hibernateAndJpa.Entities.City;
//Entity manageri kullanmak için bu paketi import ettim.
import jakarta.persistence.EntityManager;

@Repository
public class HibernateCityDal implements ICityDal {
	//Hibernate daki sessionfactory ve session nesnesini otomatik oluşturan metoddur.
	//jpadan gelip sessiona karşılık gelen classtır.
	private EntityManager entityManager;
	
	//@Autowired anotasyonu bizim için otomatik olarak hibernate enjeksiyonunu yapıcak
	//Bir constructor injection yaptık ve springe autowired la bu entitymanagerin
	//karşılığının ne olduğunu bul ve gerekli paketleri indir dedik.
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	//add unimplemented methods diyerek aşağıdaki overrideları çektim
	
	
	@Override
	//Transactional ise bu getAll işleminin başında ve sonunda 
	//sesionun açılıp kapanma işlevini yapar.
	@Transactional 
	public List<City> getAll() {
		//entity managera diyoruz ki bize bir hibernate sessionu ver
		Session session = entityManager.unwrap(Session.class);
		
		//Query(sorgu) yazıcaz
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		//operasyonda bir sıkıntı olabilir diye session açıp
		//işlemi sonra yapıyoruz
		Session session = entityManager.unwrap(Session.class);
		//SaveorUpdate: id veritabanında varsa günceller yoksa ekler
		session.saveOrUpdate(city);
		
	}

	@Override
	public void update(City city) {
		//operasyonda bir sıkıntı olabilir diye session açıp
		//işlemi sonra yapıyoruz
		Session session = entityManager.unwrap(Session.class);
		//SaveorUpdate: id veritabanında varsa günceller yoksa ekler
		session.saveOrUpdate(city);
				
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);
		
	}


	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		return city;
	}

}
