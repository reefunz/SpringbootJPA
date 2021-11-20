package com.example.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demos")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewStudent(@RequestParam String name, @RequestParam String className, 
        @RequestParam Integer age, @RequestParam String birthday) {
            Student student = new Student();
            student.setName(name);
            student.setClassName(className);
            student.setAge(age);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            Date bd = null;
            try {
                bd = df.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            student.setBirthday(bd);
            studentRepository.save(student);
            return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudens() {
        return studentRepository.findAll();
    }
}
