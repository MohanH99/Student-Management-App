package com.projects.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int admnNo){
        return db.get(admnNo);
    }


    //Adding Info
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        if(student == null)
            return "Invalid Student";
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student Added Successfully";
    }
}
