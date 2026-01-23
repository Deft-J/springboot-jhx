package com.example.demo.controller;


import com.example.demo.dto.StudentDTO;
import com.example.demo.service.Response;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable int id) throws Exception {
        return Response.newSuccess(studentService.getStudentById(id));
    }


    @PostMapping("/student")
    public Response<Integer> addNewStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable int id) throws Exception {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateStudentById(@PathVariable int id,@RequestParam(required = false)
                        String name,@RequestParam(required = false) String email) throws Exception {
        return Response.newSuccess(studentService.updateStudentById(id,name,email));

    }



}
