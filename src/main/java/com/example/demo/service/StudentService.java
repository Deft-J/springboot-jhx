package com.example.demo.service;

import com.example.demo.dto.StudentDTO;

public interface StudentService {

    StudentDTO getStudentById(int id) throws Exception;

    Integer addNewStudent(StudentDTO studentDTO) throws Exception;

    void deleteStudentById(int id);

    StudentDTO updateStudentById(int id, String name, String email);

}
