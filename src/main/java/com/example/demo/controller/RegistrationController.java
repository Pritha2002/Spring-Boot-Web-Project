package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.StudentRegistration;
import com.example.demo.service.IStudentRegisterService;

@Controller
public class RegistrationController {
	
	@Autowired
	private IStudentRegisterService service;
	
	@Autowired
	private StudentRegistration sr;

	@GetMapping("/")
	public String showForm() {
		return "index";
	}

	@GetMapping("/register")
	public String registeredStudent(@RequestParam(name = "fname") String firstName,
			@RequestParam(name = "lname") String lastName, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "quali") String qualification, @RequestParam(name = "contact") Long contactNum,
			Model model) throws Exception {

		
		sr.setStudentFirstName(firstName);
		sr.setStudentLastName(lastName);
		sr.setStudentGender(gender);
		sr.setStudentQualification(qualification);
		sr.setStduentContactNumber(contactNum);

		StudentRegistration student = service.addRegisteredStudent(sr);
		model.addAttribute("studentId",student.getStudentId());
		System.out.println(student);
		
		return "result";
	}
}
