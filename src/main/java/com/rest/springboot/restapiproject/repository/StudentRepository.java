package com.rest.springboot.restapiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springboot.restapiproject.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
