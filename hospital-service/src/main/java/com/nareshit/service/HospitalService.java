package com.nareshit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;


public interface HospitalService {

	public HospitalBean saveHospital(HospitalBean hospBean);
	public List<HospitalBean> getAllHospitals();
	public HospitalBean getHospitalById(int id);
	public HospitalBean updateHospital(HospitalBean hospBean);
	public void delete(int id);
	public List<HospitalBean> findHospitalByName(String name);
	
}
