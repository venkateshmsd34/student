package com.rest.springboot.restapiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.restapiproject.dto.StudentRequest;
import com.rest.springboot.restapiproject.dto.StudentResponse;
import com.rest.springboot.restapiproject.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping
	public StudentResponse createstudent(@RequestBody StudentRequest studentRequest) {
		return studentService.save(studentRequest);
	}

	@GetMapping
	public List<StudentResponse> getAllStudents() {
		return studentService.findAll();
	}

	@GetMapping("/{id}")
	public StudentResponse findById(@PathVariable Long id) {
		return studentService.findById(id);
	}

	@PutMapping("/{id}")
	public StudentResponse updateById(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
		return studentService.update(id, studentRequest);
	}

	@PatchMapping("/{id}")
	public StudentResponse patch(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
		return studentService.patch(id, studentRequest);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		studentService.delete(id);
		return "deleted with the " + id;
	}

	// @GetMapping("/")
	// public List<Student> findAll() {
	// return studentService.findAll();
	//
	// }
	//
	// @PostMapping("/")
	// public Student save(@RequestBody Student student) {
	// return studentService.save(student);
	// }
	//
	// @PutMapping("/") // replace the entire object
	// public String update(@RequestBody Student student) {
	// studentService.update(student);
	// return "successfully upadted a record";
	// }
	//
	// // using id we are updating replace the entire object
	// @PutMapping("/{id}")
	// public Student updateByid(@PathVariable long id, @RequestBody Student
	// student) {
	// Student student1 = studentService.findById(id);
	//
	// if (student1 != null) {
	// student1.setName(student.getName());
	// student1.setAddress(student.getAddress());
	// }
	// return studentService.update(student1);
	// }
	//
	// // patch method is used to update the single value or multiple value update
	// only
	// // some fields
	// @PatchMapping("/{id}")
	// public Student updateByid1(@PathVariable long id, @RequestBody Student
	// student) {
	// Student student1 = studentService.findById(id);
	// if (student.getName() != null) {
	// student1.setName(student.getName());
	// }
	// if (student.getAddress() != null) {
	// student1.setAddress(student.getAddress());
	// }
	//
	// return studentService.update(student1);
	// }
	//
	// @GetMapping("/{id}")
	// public Student getById(@PathVariable long id) {
	// return studentService.findById(id);
	//
	// }
	//
	// @DeleteMapping("/{id}")
	// public String delete(@PathVariable long id) {
	// studentService.delete(id);
	// return "deleted the record with " + id;
	// }
}
