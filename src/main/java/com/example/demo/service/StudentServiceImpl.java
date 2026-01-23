package com.example.demo.service;


import com.example.demo.converter.StudentConverter;
import com.example.demo.dao.Student;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(int id) throws Exception {
        Student student=studentRepository.findById(id).orElseThrow(Exception::new);
        return StudentConverter.converterStudent(student);
    }

    @Override
    public Integer addNewStudent(StudentDTO studentDTO) throws Exception {
        List<Student> studentList=studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studentList)){
            throw new IllegalAccessException("email:"+studentDTO.getEmail()+" has been taken");
        }

        Student student =  studentRepository.save(StudentConverter.converterStudent(studentDTO));

        return student.getId();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id:"+ id +"does not exist"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentById(int id, String name, String email) {
        Student studentInDB=studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id:"+ id +"does not exist"));
        if(StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }
        if(StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        Student student=studentRepository.save(studentInDB);
        return StudentConverter.converterStudent(student);
    }


}
