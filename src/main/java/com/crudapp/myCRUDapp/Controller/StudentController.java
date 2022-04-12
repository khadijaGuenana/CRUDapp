package com.crudapp.myCRUDapp.Controller;

import com.crudapp.myCRUDapp.Entity.Student;
import com.crudapp.myCRUDapp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentDetails")
public class StudentController {
   @Autowired
    private StudentService studentService;
   @PostMapping("/saveStudent")
   public ResponseEntity<String> saveStudent (@RequestBody Student student){
     Integer id =  studentService.saveStudent(student);
      return new ResponseEntity<String>("Student with id '" + id +"' has been saved ", HttpStatus.OK);
   }
@GetMapping("/studentList")
   public ResponseEntity<List<Student>>getAllStudent(){
      List<Student>list=studentService.getAllStudent();
       return new ResponseEntity<List<Student>>(list,HttpStatus.OK);

   }
   @GetMapping("/getStudentById/{studentNum}")
   public ResponseEntity<Student>getStudentById(@PathVariable("studentNum") Integer studentNum){
       Student student=studentService.getStudentById(studentNum);
       return new ResponseEntity<Student>(student,HttpStatus.OK);
   }
@PutMapping("/updateStudent/{studentNum}")
   public ResponseEntity<String> updateStudent(@PathVariable("studentNum") Integer studentNum ,@RequestBody Student student){
       Student studentdFromDB=studentService.getStudentById(studentNum);
       studentdFromDB.setStudentClass(student.getStudentClass());
       studentdFromDB.setStudentName(student.getStudentName());
       studentdFromDB.setStudentSchool(student.getStudentSchool());
       studentdFromDB.setStudentNum(student.getStudentNum());
      Integer id = studentService.saveStudent(studentdFromDB);
      return new ResponseEntity<String>("student with id '"+id+"' has been updated ",HttpStatus.OK);
   }
 @DeleteMapping("/deleteStudent/{studentNum}")
   public ResponseEntity<String> deleteStudent(@PathVariable("studentNum") Integer studentNum){
       studentService.deleteStudent(studentNum);
       return new ResponseEntity<String>("Student with '"+studentNum+" has been deleted ",HttpStatus.OK);

   }





}
