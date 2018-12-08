package com.nareshit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.service.HospitalService;
import com.nareshit.utility.HospitalMapper;

@RestController
//@Controller
@RequestMapping("/hospService")
public class HospitalController {

	@Autowired
	private HospitalService hospService;

	@PostMapping(value = "/addHospital", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<HospitalBean> addHospital(@RequestBody HospitalBean hospBean) {
		System.out.println("add hospital ");
		hospBean = hospService.saveHospital(hospBean);
		return new ResponseEntity<HospitalBean>(hospBean, HttpStatus.OK);

	}

//	@GetMapping(value="/searchAllHosp")
//	public String searchAllHosp(HttpServletRequest req,Model model) {
//		System.out.println("am in search all hsopiatls");
//		
//		
//		String searchVal = req.getParameter("searchValue");
//		String searchOption = req.getParameter("searchOption");
//		System.out.println("search val is:\t"+searchVal);
//		System.out.println("search option is:\t"+searchOption);
//		
//		if(searchOption != null && !searchOption.isEmpty()) {
//			if(searchOption.equals("Name")) {
//				List<HospitalBean> hospBeanList = hospService.findHospitalByName(searchVal.toLowerCase());
//				//List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainList.iterator());
//				model.addAttribute("hospList", hospBeanList);
//			}
//		}else {
//			model.addAttribute("errorMessage", "Search is not supplied.");
//		}
//		
//		return "hospBoard";
//				
//		
//	}
//	

//	@PostMapping(value="/addHospital")
//	public String addHospotal(@ModelAttribute("hospBean") HospitalBean hospBean, Model model) {
//		System.out.println("add hospital ");
//		System.out.println("hospal data is:\t"+hospBean.getStatus());
//		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
//		//hosp = hospRepo.save(hosp);
//		hospBean =  hospService.saveHospital(hosp);
//		//hospBean = HospitalMapper.mapDomainToBean(hosp);
//		List<HospitalBean> hospBeanList = hospService.getAllHospitals();
//		model.addAttribute("hospList", hospBeanList);
//		//return "addHospital";
//		
//		
//		
//		return "hospBoard";
//		
//	}

	@GetMapping(value = "/getAllHospitals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HospitalBean>> findHospital() {
		List<HospitalBean> hospBeanList = hospService.getAllHospitals();
		return new ResponseEntity<List<HospitalBean>>(hospBeanList, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HospitalBean> deleteHospital(@PathVariable("id") int id) {
		hospService.delete(id);
		// Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		// List<HospitalBean> hospBeanList = hospService.getAllHospitals();
		return new ResponseEntity<HospitalBean>(HttpStatus.OK);
	}

//	@GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<HospitalBean> findHospitalbyId(@PathVariable("id") int id) {
//		HospitalBean hospBeanList = hospService.getHospitalById(id);
//		return new ResponseEntity<HospitalBean>(hospBeanList, HttpStatus.OK);
//
//	}

//	@PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<HospitalBean> editHospotal(@RequestBody HospitalBean hospBean,@PathVariable("id") int id) {
//		HospitalBean newHospBean = hospService.getHospitalById(id);
//		newHospBean.setName(hospBean.getName());
//		newHospBean.setEmail(hospBean.getEmail());
//		newHospBean.setPhone(hospBean.getPhone());
//		newHospBean.setFax(hospBean.getFax());
//		newHospBean.setStatus(hospBean.getStatus());
//
//		hospBean = hospService.saveHospital(hospBean);
//		return new ResponseEntity<HospitalBean>(hospBean, HttpStatus.OK);
//	}

//	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<HospitalBean> updateHospital(@RequestBody HospitalBean hospBean) {
//		System.out.println("Update hospital ");
//		HospitalBean newHospBean = hospService.getHospitalById(hospBean.getHospId());
//		newHospBean.setName(hospBean.getName());
//		newHospBean.setEmail(hospBean.getEmail());
//		newHospBean.setPhone(hospBean.getPhone());
//		newHospBean.setFax(hospBean.getFax());
//		newHospBean.setStatus(hospBean.getStatus());
//
//		hospBean = hospService.saveHospital(hospBean);
//		return new ResponseEntity<HospitalBean>(hospBean, HttpStatus.OK);
//
////		System.out.println(hospBean.getHospId());
////		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
//////		hosp = hospRepo.save(hosp);
////		hospBean = hospService.saveHospital(hosp);
////		//return "addHospital";
////		return "redirect:./getAllHospitals";
//
//	}
}
