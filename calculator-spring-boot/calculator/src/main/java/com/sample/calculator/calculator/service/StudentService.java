package com.sample.calculator.calculator.service;

import com.sample.calculator.calculator.dto.RequestMathPayload;
import com.sample.calculator.calculator.dto.ResponseMathPayload;
import com.sample.calculator.calculator.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setID(1);
        student1.setName("Rahul");
        student1.setAddress("ABC Street");
        students.add(student1);

        Student student2 = new Student();
        student2.setID(1);
        student2.setName("Sandeep");
        student2.setAddress("XYZ Street");
        students.add(student2);
        return students;
    }


    public ResponseMathPayload peformSum(RequestMathPayload requestMathPayload) {
        ResponseMathPayload responseMathPayload = new ResponseMathPayload();
        /*responseMathPayload.setA(requestMathPayload.getA());
        responseMathPayload.setB(requestMathPayload.getB());*/
        responseMathPayload.setSum(requestMathPayload.getA()+requestMathPayload.getB());
        return responseMathPayload;
    }
}
