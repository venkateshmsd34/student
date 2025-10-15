package com.rest.springboot.restapiproject.service;

import java.util.List;

import com.rest.springboot.restapiproject.dto.StudentRequest;
import com.rest.springboot.restapiproject.dto.StudentResponse;

public interface StudentService {
	StudentResponse save(StudentRequest request);

	StudentResponse update(Long id, StudentRequest request);
	
	StudentResponse patch(Long id, StudentRequest request);

	List<StudentResponse> findAll();

	StudentResponse findById(Long id);

	void delete(Long id);
}
