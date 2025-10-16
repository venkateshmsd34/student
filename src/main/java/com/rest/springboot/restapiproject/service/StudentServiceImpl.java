package com.rest.springboot.restapiproject.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.restapiproject.dto.StudentRequest;
import com.rest.springboot.restapiproject.dto.StudentResponse;
import com.rest.springboot.restapiproject.entity.Student;
import com.rest.springboot.restapiproject.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentResponse save(StudentRequest request) {
		Student student = modelMapper.map(request, Student.class);
		
		studentRepository.save(student);
		
		
		//Student student = new Student();
		
		
//		student.setName(request.getName());
//		student.setAddress(request.getAddress());
//		student.setUsername(request.getUsername());
//		student.setPassword(request.getPassword());
//
//		Student savedStudent = studentRepository.save(student);
//
//		StudentResponse response = new StudentResponse();
//		response.setId(savedStudent.getId());
//		response.setName(savedStudent.getName());
//		response.setAddress(savedStudent.getAddress());
//		response.setUsername(savedStudent.getUsername());

		return modelMapper.map(student, StudentResponse.class);
	}

	@Override
	public StudentResponse update(Long id, StudentRequest request) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student no found"));

//		student.setName(request.getName());
//		student.setAddress(request.getAddress());
//		student.setUsername(request.getUsername());
//		student.setPassword(request.getPassword());
		
		modelMapper.map(request, student);

		Student updatedStudent = studentRepository.save(student);

//		StudentResponse response = new StudentResponse();
//		response.setId(savedStudent.getId());
//		response.setName(savedStudent.getName());
//		response.setAddress(savedStudent.getAddress());
//		response.setUsername(savedStudent.getUsername());

		return modelMapper.map(updatedStudent, StudentResponse.class);
	}

	@Override
	public List<StudentResponse> findAll() {
		List<Student> students = studentRepository.findAll();
		
		// convert student list to student response
		
		List<StudentResponse> response = students
				.stream()
				.map(student -> modelMapper.map(student, StudentResponse.class))
				.toList();
		
		return response;
	}

	@Override
	public StudentResponse findById(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));

//		StudentResponse response = new StudentResponse();
//
//		response.setId(student.getId());
//		response.setName(student.getName());
//		response.setAddress(student.getAddress());
//		response.setUsername(student.getUsername());
//
//		return response;
		
		StudentResponse response = modelMapper.map(student, StudentResponse.class);
		return response;
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public StudentResponse patch(Long id, StudentRequest request) {
		 Student student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        // ✅ Apply only non-null fields from request to student
	        modelMapper.map(request, student);

	        Student savedStudent = studentRepository.save(student);

	        // ✅ Convert back to response DTO
	        return modelMapper.map(savedStudent, StudentResponse.class);
		
		
		
		
		
		
		
		
		
		
		
		
//		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
//
//		if (request.getName() != null)
//			student.setName(request.getName());
//		if (request.getAddress() != null)
//			student.setAddress(request.getAddress());
//		if (request.getUsername() != null)
//			student.setUsername(request.getUsername());
//		if (request.getPassword() != null)
//			student.setPassword(request.getPassword());
//
//		Student savedStudent = studentRepository.save(student);
//
//		StudentResponse response = new StudentResponse();
//
//		response.setId(savedStudent.getId());
//		response.setName(savedStudent.getName());
//		response.setAddress(savedStudent.getAddress());
//		response.setUsername(savedStudent.getUsername());
//
//		return response;
	}

}
