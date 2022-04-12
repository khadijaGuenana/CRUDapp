package com.crudapp.myCRUDapp.Repository;

import com.crudapp.myCRUDapp.Entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
