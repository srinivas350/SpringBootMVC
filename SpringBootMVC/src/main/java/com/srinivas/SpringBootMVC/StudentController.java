package com.srinivas.SpringBootMVC;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepositroy repository;
	@RequestMapping("/")
	public String getStudentView()
	{
		return "student";
	}
	
	@RequestMapping("saveStudent")
	public String saveStudent(@RequestBody Student student,HttpSession session)
	{
		repository.save(student);
		session.setAttribute("status", "Student Object Saved Successfully");
		return "student";
	}
	@RequestMapping("getAllStudent")
	public ModelAndView getStudents()
	{
		List<Student> students=(List<Student>) repository.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("student",students);
		mav.setViewName("studentsView");
		return mav;
	}
	@RequestMapping("delete")
	public String deleteView() 
	{
		return "delete";
	}
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("studentId") int studentId) throws Exception
	{
		Student student=repository.findById(studentId).orElse(null);
		ModelAndView mav=new ModelAndView();
		if(student!=null)
		{
			repository.deleteById(studentId);
			mav.setViewName("delete");
			List<Student> students=(List<Student>) repository.findAll();
			mav.addObject("student",students);
		}
		else
		{
			List<Student> students=(List<Student>) repository.findAll();
			mav.setViewName("delete");
			mav.addObject("student",students);
		}
		
		return mav;
	}
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student)
	{
		Student student1=repository.findById(student.getStudentId()).orElse(null);
		student1.setStudentId(student.getStudentId());
		student1.setStudentName(student.getStudentName());
		student1.setStudentMarks(student.getStudentMarks());
		student1.setStudentClass(student.getStudentClass());
		student1.setStudentGrade(student.getStudentGrade());
		repository.save(student);
		List<Student> students=(List<Student>) repository.findAll();
		ModelAndView mav=new ModelAndView("student","student",students);
		return mav;
	}
	

}
