package com.student.api.controller;

import com.student.api.entity.Student;
import com.student.api.exception.GenericException;
import com.student.api.repo.StudentRepository;
import com.student.api.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    @PostMapping("/add")
    ResponseEntity<?> addStudent(@Valid @RequestBody Student student) throws GenericException {
        return studentService.addStudent(student);
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllStudent() throws GenericException {

        return studentService.getAllStudent();

    }
    @GetMapping("/student/{id}")
    ResponseEntity<?> getByIdStudent(@PathVariable long id) throws GenericException {
        return  studentService.getByIdStudent(id);
    }
    @PutMapping("/update/{id}")
    ResponseEntity<?> updateStudent(@Valid @RequestBody Student student,@PathVariable long id) throws GenericException {
        return studentService.updateStudent(student ,id);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deleteStudent(@PathVariable("id") long id) throws GenericException {
        return  studentService.deleteStudent(id);
    }
    /**
     * custom finder methode
     * @param name
     * @return
     * @throws
     */
    @GetMapping("/fetch By Name/{name}")
    ResponseEntity<?>getStudentByName(@PathVariable("name") String name)throws GenericException{
      return studentService.getStudentByName(name);
    }
    @GetMapping("/fetch by mail/{email}")
    ResponseEntity<?> getStudentByEmail(@PathVariable("email") String email)throws GenericException{
        return studentService.getStudentByEmail(email);
    }
    @GetMapping("/fetch by city/{city}")
    ResponseEntity<?>getByStudentCity(@PathVariable("city") String city)throws GenericException{
        return studentService.getByStudentCity(city);
    }
    @GetMapping("/fetch by country/{country}")
    ResponseEntity<?>getByStudentCountry(@PathVariable("country") String country)throws GenericException{
        return studentService.getByStudentCountry(country);
    }
    /**
     * sorting one by one Attribute
     */

    @GetMapping("/id/asc")
    ResponseEntity<?>getByIdAsc()throws GenericException{
        return studentService.getByIdAsc();
    }
    @GetMapping("/id/desc")
    ResponseEntity<?>getByIdDesc()throws GenericException{
        return studentService.getByIdDesc();
    }
    @GetMapping("/name/asc")
    ResponseEntity<?> getByNameAscendingOrder()throws GenericException{
        return studentService.getByNameAscendingOrder();
    }
    @GetMapping("/name/desc")
    ResponseEntity<?> getByNameDescendingOrder() throws GenericException{
        return studentService.getByNameDescendingOrder();
    }
    @GetMapping("/contact/asc")
    ResponseEntity<?> getByContactAscendingOrder()throws GenericException{
        return studentService.getByContactAscendingOrder();
    }
    @GetMapping("/contact/desc")
    ResponseEntity<?> getByContactDescendingOrder()throws GenericException{
        return studentService.getByContactDescendingOrder();
    }

    /**
     * Employee data filtering.....................
     */

    /**
    @GetMapping("/name/{name}")
    ResponseEntity<?> filterByName(@PathVariable("name") String name)throws GenericException{
        return studentService.filterByName(name);
    }
    @GetMapping("/city/{city}")
    ResponseEntity<?> filterByCity(@PathVariable String city)throws GenericException{
        return studentService.filterByCity(city);
    }
    @GetMapping("/contact/{contact}")
    ResponseEntity<?> filterGetByContact(@PathVariable String contact)throws GenericException{
        return studentService.filterGetByContact(contact);
    }
    @GetMapping("/email/{email}")
    ResponseEntity<?> filterGetByEmail(@PathVariable("email") String email)throws GenericException{
        return studentService.filterGetByContact(email);
    }
    @GetMapping("/state/{state}")
    ResponseEntity<?> filterGetByState(@PathVariable String state)throws GenericException{
        return studentService.filterGetByState(state);
    }
    */
}
