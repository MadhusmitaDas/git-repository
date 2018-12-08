package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.HospitalBean;
import com.nareshit.dao.HospitalDao;
import com.nareshit.domain.Hospital;
import com.nareshit.utility.HospitalMapper;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalDao hospDao;
	
	@Override
	public HospitalBean saveHospital(HospitalBean hospBean) {
	Hospital hosp	=HospitalMapper.mapBeanToDomain(hospBean);
		Hospital hospDoamin = hospDao.addHospital(hosp);
		return HospitalMapper.mapDomainToBean(hospDoamin);
	}

	@Override
	public List<HospitalBean> getAllHospitals() {
		List<Hospital> hospList = hospDao.getAllHospitals();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospList.iterator());
		return hospBeanList;
	}

	@Override
	public HospitalBean getHospitalById(int id) {
		 Hospital hosp = hospDao.getHospitalByid(id);
			return HospitalMapper.mapDomainToBean(hosp);
	}

	

	@Override
	public void delete(int id) {
		hospDao.deleteHospitalById(id);
	}

	@Override
	public List<HospitalBean> findHospitalByName(String name) {
		List<Hospital> hosp=hospDao.getHospitalByName(name);
		return HospitalMapper.mapDomainListToBean(hosp.iterator());
	}

	@Override
	public HospitalBean updateHospital(HospitalBean hospBean) {
			Hospital hosp=HospitalMapper.mapBeanToDomain(hospBean); 
			hosp = hospDao.updateHospital(hosp);
				return HospitalMapper.mapDomainToBean(hosp);
		
	}

}