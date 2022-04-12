package com.crudapp.myCRUDapp.Service;

import com.crudapp.myCRUDapp.Entity.Student;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface StudentService  {

    public Integer saveStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudentById(Integer studentNum);
    public void deleteStudent(Integer studentNum);




}
