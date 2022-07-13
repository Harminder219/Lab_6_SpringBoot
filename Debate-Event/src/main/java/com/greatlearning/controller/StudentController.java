package com.greatlearning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.entity.Student;
import com.greatlearning.entity.User;
import com.greatlearning.repository.UserRepository;
import com.greatlearning.security.MyUserDetails;
import com.greatlearning.service.StudentServiceImpl;
import com.greatlearning.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@Autowired
	UserDetailsServiceImpl detailsServiceImpl;
	

	

	@RequestMapping("/list")
	public String showStudentDetails(Model model) {


		

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		
		List<Student> students = studentServiceImpl.getStudentdetails();
   
		
		model.addAttribute("students", students);
		
		model.addAttribute("username", auth.getName());
  
		
		return "liststudents";
	}

	@RequestMapping("/showFormForAdd")
	public String showStudentAddForm() {

		return "studentaddform";
	}

	@RequestMapping("/showFormForUpdate")
	public String showStudentUpdateForm(Model model, @RequestParam("id") int id) {
		Student student = studentServiceImpl.getStudentById(id).get();

		model.addAttribute("student", student);

		return "updatedetails";

	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		Student newStudent;

		if (student.getId() != 0) {
			newStudent = studentServiceImpl.getStudentById(student.getId()).get();
			newStudent.setFirstName(student.getFirstName());
			newStudent.setLastName(student.getLastName());
			newStudent.setCourse(student.getCourse());
			newStudent.setCountry(student.getCountry());

			student = newStudent;

		}

		studentServiceImpl.saveStudentDetails(student);

		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {

		studentServiceImpl.deleteStudent(id);

		return "redirect:/student/list";
	}

	@RequestMapping(value = "403")
	public ModelAndView accessDenied(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();

		if (principal != null) {

			modelAndView.addObject("msg",
					"Hello " + principal.getName() + " You dont have permission to access this page");

		} else {

			modelAndView.addObject("msg", " You dont have permission to access this page");

		}

		modelAndView.setViewName("403");
		return modelAndView;

	}

}
