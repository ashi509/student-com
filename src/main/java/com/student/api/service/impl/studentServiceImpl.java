package com.student.api.service.impl;

import com.student.api.entity.Student;
import com.student.api.exception.GenericException;
import com.student.api.repo.StudentRepository;
import com.student.api.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class studentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    /**
     * Basic Add ,Get,Get By Id ,Update ,Delete,method
     * @param student
     * @return
     */
    @Override
    public ResponseEntity<?> addStudent(Student student) throws GenericException {
        student.setId(0);
        student.getAddress().setId(0);
        student.setCreatedDate(new Date());
       return ResponseEntity.ok().body(studentRepository.save(student));
    }
    @Override
    public ResponseEntity<?> getAllStudent() throws GenericException {
       var st=studentRepository.findAll();
       if(st==null)
            throw new GenericException(HttpStatus.NO_CONTENT.value(), "No any student find.");
            return ResponseEntity.ok().body(st);
    }
    @Override
    public ResponseEntity<?> getByIdStudent(long id) throws GenericException {
        var student=studentRepository.findById(id)
                .orElseThrow(()->new GenericException(HttpStatus.NOT_FOUND.value(),
                        "Id not match with given Id "+id));
        return ResponseEntity.ok().body(student);
    }
    @Override
    public ResponseEntity<?> updateStudent(Student student, long id) throws GenericException {
        var students=studentRepository.findById(id)
                .orElseThrow(()->new GenericException(HttpStatus.NOT_FOUND.value(),
                        "Id mismatch wit given id "+id));
        student.setId(id);
        student.getAddress().setId(id);
        student.setCreatedDate(new Date());
        students=studentRepository.save(student);
        if(students==null)
            throw new GenericException(HttpStatus.NO_CONTENT.value(),
                    "Something went wrong student does not update ");
        return ResponseEntity.ok().body(students);
    }
    @Override
    public ResponseEntity<?> deleteStudent(long id) throws GenericException {
        var students =studentRepository.findById(id)
                .orElseThrow(()->new GenericException(HttpStatus.NOT_FOUND.value(),
                        "Student not found with given id "+id));
        studentRepository.deleteById(id);
      return   ResponseEntity.status(HttpStatus.OK).body(students);
    }
    /**
     * custom finder method
     * @param name
     * @return
     */
    @Override
    public ResponseEntity<?> getStudentByName(String name) throws GenericException {
        var students=studentRepository.findByName(name);
        if(students==null)
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with given name "+name);
        return ResponseEntity.ok(students);

    }
    @Override
    public ResponseEntity<?> getStudentByEmail(String email) throws GenericException {
        var student=studentRepository.searchByEmail(email);
        if(student==null)
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with given email "+email);
        return ResponseEntity.ok(student);
    }
    @Override
    public ResponseEntity<?> getByStudentCity(String city) throws GenericException {
        var student=studentRepository.findAll();
                 student=student.stream()
                .filter(student1 -> student1.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        if(student.isEmpty())
            throw  new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Students not found with city name "+city);
        return ResponseEntity.ok(student);
    }
    @Override
    public ResponseEntity<?> getByStudentCountry(String country) throws GenericException {
        var students=studentRepository.findAll();
        students=students.stream().filter(student -> student.getAddress()
                .getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
        if(students.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with given country name"+country);
        return ResponseEntity.ok(students);
    }
    /**
     *  get student data Ascending and Descending order
     * @return
     * @throws GenericException
     */
    @Override
    public ResponseEntity<?> getByIdAsc() throws GenericException {
      var st=studentRepository.findAll();
      st=st.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
      if(st.isEmpty())
          throw new GenericException(HttpStatus.NOT_MODIFIED.value(), "Student not ascending order");
      return ResponseEntity.ok(st);
    }
    @Override
    public ResponseEntity<?> getByIdDesc() throws GenericException {
        var st=studentRepository.findAll();
        st=st.stream().sorted(Comparator.comparing(Student::getId)
                .reversed()).collect(Collectors.toList());
        if(st.isEmpty())
            throw new GenericException(HttpStatus.NOT_MODIFIED.value(), "Student not ascending order");
        return ResponseEntity.ok(st);
    }
    @Override
    public ResponseEntity<?> getByNameAscendingOrder() throws GenericException {
        var st=studentRepository.findAll();
        st=st.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        if(st.isEmpty())
            throw new GenericException(HttpStatus.NOT_MODIFIED.value(),
                    "Student not set name wise ascending order");
        return ResponseEntity.ok(st);
    }
    @Override
    public ResponseEntity<?> getByNameDescendingOrder() throws GenericException {
        var st=studentRepository.findAll();
        st=st.stream().sorted(Comparator.comparing(Student::getName)
                .reversed()).collect(Collectors.toList());
        if(st.isEmpty())
            throw new GenericException(HttpStatus.NOT_MODIFIED.value(),
                    "Student not set name wise ascending order");
        return ResponseEntity.ok(st);
    }
    @Override
    public ResponseEntity<?> getByContactAscendingOrder() throws GenericException {
        var st=studentRepository.findAll();
        st=st.stream().sorted(Comparator.comparing(Student::getContact))
                .collect(Collectors.toList());
        if(st.isEmpty())
            throw new GenericException(HttpStatus.NOT_MODIFIED.value(),
                    "Student not set contact wise ascending order");
        return ResponseEntity.ok(st);
    }
    @Override
    public ResponseEntity<?> getByContactDescendingOrder() throws GenericException {
        var st=studentRepository.findAll();
        st=st.stream().sorted(Comparator.comparing(Student::getContact)
                .reversed()).collect(Collectors.toList());
        if(st.isEmpty())
            throw new GenericException(HttpStatus.NOT_MODIFIED.value(),
                    "Student not set name wise ascending order");
        return ResponseEntity.ok(st);
    }
    /**
     * filter data
     * @param name
     * @return
     * @throws GenericException
     */
    @Override
    public ResponseEntity<?> filterByName(String name) throws GenericException {
      var student=studentRepository.findAll();
     student= student.stream().filter(student1 -> student1.getName()
             .equalsIgnoreCase(name)).collect(Collectors.toList());
        if(student.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with name "+name);
        return ResponseEntity.ok(student);
    }
    @Override
    public ResponseEntity<?> filterByCity(String city) throws GenericException {
        var student=studentRepository.findAll();
        student= student.stream().
                filter(student1 -> student1.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        if(student.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with city "+city);
        return ResponseEntity.ok(student);
    }
    @Override
    public ResponseEntity<?> filterGetByContact(String contact) throws GenericException {
        var student=studentRepository.findAll();
        student= student.stream().filter(student1 -> student1.getContact()
                .equalsIgnoreCase(contact)).collect(Collectors.toList());
        if(student.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with contact "+contact);
        return ResponseEntity.ok(student);
         }
    @Override
    public ResponseEntity<?> filterGetByEmail(String email) throws GenericException {
        var student=studentRepository.findAll();
        student= student.stream().filter(student1 -> student1
                .getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
        if(student.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with email "+email);
        return ResponseEntity.ok(student);
    }
    @Override
    public ResponseEntity<?> filterGetByState(String state) throws GenericException{
        var student=studentRepository.findAll();
        student= student.stream().filter(student1 -> student1.getAddress()
                .getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        if(student.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),
                    "Student not found with state "+state);
        return ResponseEntity.ok(student);
    }
}
