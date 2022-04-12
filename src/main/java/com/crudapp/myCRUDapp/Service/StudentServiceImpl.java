package com.crudapp.myCRUDapp.Service;

import com.crudapp.myCRUDapp.Entity.Student;
import com.crudapp.myCRUDapp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Integer saveStudent(Student student) {
        return studentRepository.save(student).getStudentNum();
    }

    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }



    @Override
    public Student getStudentById(Integer studentNum) {
        return studentRepository.findById(studentNum).get();
    }

    @Override
    public void deleteStudent(Integer studentNum) {
        studentRepository.deleteById(studentNum);

    }
}
