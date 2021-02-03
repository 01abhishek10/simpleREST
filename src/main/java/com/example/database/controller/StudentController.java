package com.example.database.controller;

import com.example.database.dao.StudentRepo;
import com.example.database.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/insertData")
    public String insertData(@RequestParam Student s, Model model) {
        try {
            repo.save(s);
            return "/login";
        }
        catch (IllegalArgumentException ie) {
            String failed = "Data is not saved, please re-enter the data";
            model.addAttribute(failed);
            return "/insertData";
        }

    }
    @GetMapping("/searchData")
    public String searchData() {
        return "searchData";
    }
    @GetMapping(path="/students")
    public List<Student> students() {
        return repo.findAll();
    }
    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudent(@PathVariable("studentId") int studentId){
        return repo.findById(studentId);
    }
    @PostMapping(path="/students")
    public Student students(@RequestBody Student s){
        repo.save(s);
        return s;
    }
    @DeleteMapping(path="/students/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        repo.deleteById(studentId);
        return "deleted";
    }
    @PutMapping(path="/students", consumes = {"application/json"})
    public Student saveOrUpdateStudent(@RequestBody Student s){
        repo.save(s);
        return s;
    }
}
