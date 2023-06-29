package com.student.api.service;

import com.student.api.entity.Student;
import com.student.api.exception.GenericException;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    /**
     * Basic Add ,Get,Get By Id ,Update ,Delete,method
     * @param student
     * @return
     */
 ResponseEntity<?> addStudent(Student student)throws GenericException;
 ResponseEntity<?>getAllStudent()throws GenericException;
 ResponseEntity<?> getByIdStudent(long id)throws GenericException;
 ResponseEntity<?> updateStudent(Student student, long id)throws GenericException;
 ResponseEntity<?>deleteStudent(long id)throws GenericException;
 /**
  * custom finder methode
  * @param name
  * @return
  * @throws
  */
 ResponseEntity<?>getStudentByName(String name)throws GenericException;
 ResponseEntity<?> getStudentByEmail(String email)throws GenericException;
 ResponseEntity<?>getByStudentCity(String city)throws GenericException;
 ResponseEntity<?>getByStudentCountry(String country)throws GenericException;
 /**
  * sorting one by one Attribute
  */
 ResponseEntity<?>getByIdAsc()throws GenericException;
 ResponseEntity<?>getByIdDesc()throws GenericException;
 ResponseEntity<?> getByNameAscendingOrder()throws GenericException;
 ResponseEntity<?> getByNameDescendingOrder() throws GenericException;
 ResponseEntity<?> getByContactAscendingOrder()throws GenericException;
 ResponseEntity<?> getByContactDescendingOrder()throws GenericException;

 /**
  * Employee data filtering.....................
  */
 ResponseEntity<?> filterByName(String name)throws GenericException;
 ResponseEntity<?> filterByCity(String city)throws GenericException;
 ResponseEntity<?> filterGetByContact(String contact)throws GenericException;
 ResponseEntity<?> filterGetByEmail(String email)throws GenericException;
 ResponseEntity<?> filterGetByState(String state)throws GenericException;
 }