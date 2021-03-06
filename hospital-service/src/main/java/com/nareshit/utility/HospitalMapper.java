package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;

public class HospitalMapper {

	public static Hospital mapBeanToDomain(HospitalBean hospBean) {
		Hospital hosp = new Hospital();
		if(hospBean.getHospId() > 0) {
			hosp.setId(hospBean.getHospId());
		}
		hosp.setEmail(hospBean.getEmail());
		hosp.setName(hospBean.getName());
		hosp.setFax(hospBean.getFax());
		hosp.setPhone(hospBean.getPhone());
		
		
		
		//hosp.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(hospBean.getStatus()))));
		hosp.setStatus(Boolean.parseBoolean(hospBean.getStatus()));
			return hosp;
		
	
	}
	
	public static HospitalBean mapDomainToBean(Hospital hospDomain) {
		HospitalBean hosp = new HospitalBean();
		hosp.setHospId(hospDomain.getId());
		hosp.setEmail(hospDomain.getEmail());
		hosp.setName(hospDomain.getName());
		hosp.setFax(hospDomain.getFax());
		hosp.setPhone(hospDomain.getPhone());
		
		boolean hospStatus = hospDomain.isStatus();
		
		hosp.setStatus(String.valueOf(hospStatus));
		return hosp;
	}
	
	public static List<HospitalBean> mapDomainListToBean(Iterator<Hospital> hospList){
		List<HospitalBean> hospBeansList = null;
		if(hospList != null) {
			hospBeansList = new ArrayList<HospitalBean>();
			while(hospList.hasNext()) {
				hospBeansList.add(mapDomainToBean(hospList.next()));
			}
		}
		return hospBeansList;
	}
		
}
