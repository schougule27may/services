package com.sample.calculator.calculator.controlleer;

import com.sample.calculator.calculator.dto.RequestMathPayload;
import com.sample.calculator.calculator.dto.ResponseMathPayload;
import com.sample.calculator.calculator.dto.Student;
import com.sample.calculator.calculator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class HelloWorldController {


    @Autowired
    StudentService studentService;

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello World ..";
    }


    @GetMapping("/currentdate")
    public Date getDate() {
        Date currentDate  = new Date();
        return currentDate;
    }

    @GetMapping(value="/students1")
    public List<Student> getStudents1() {
        return studentService.getStudents();
    }
    @GetMapping(value="/students2", produces = { "application/json", "application/xml" })
    public List<Student> getStudents2() {
       return studentService.getStudents();
    }

    @PostMapping("calculator/add")
    public ResponseMathPayload performAdd(@RequestBody RequestMathPayload requestMathPayload){
        return studentService.peformSum(requestMathPayload);
    }
}
