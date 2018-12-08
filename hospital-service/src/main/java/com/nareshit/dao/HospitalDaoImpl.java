package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Hospital;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public Hospital addHospital(Hospital hosp) {
		Session ses = sf.openSession();
		ses.save(hosp);
		ses.beginTransaction().commit();
		return hosp;
	}

	@Override
	public Hospital getHospitalByid(int id) {
		Session ses = sf.openSession();
		Hospital hosp = ses.get(Hospital.class, id);
		return hosp;
	}

	@Override
	public List<Hospital> getAllHospitals() {
		Session ses = sf.openSession();
		String hql ="from Hospital";
		Query q = ses.createQuery(hql);
		return q.list();
	}

	@Override
	public List<Hospital> searchHospital(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHospitalById(int id) {
		Session ses=sf.openSession();
		Hospital hosp=ses.load(Hospital.class, id);
		ses.delete(hosp);
		ses.beginTransaction().commit();
	}

	@Override
	public Hospital updateHospital(Hospital hosp) {
		Session ses=sf.openSession();
		ses.update(hosp);
		return hosp;
	}

	@Override
	public List<Hospital> getHospitalByName(String name) {
		Session ses = sf.openSession();
		String getHospitalByName = "from Hospital where name like :name";
		Query q = ses.createQuery(getHospitalByName);
		q.setString("name",name);
		return q.list();
	}

}
