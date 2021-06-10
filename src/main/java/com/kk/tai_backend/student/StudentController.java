package com.kk.tai_backend.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("api/student")
@CrossOrigin
public class StudentController {

    final private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity studentEntity, @RequestParam(name = "teacherId") Long assignedTeacherId) {
        try {
            return new ResponseEntity<>(studentService.addStudent(studentEntity, assignedTeacherId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        try {
            return new ResponseEntity<>( studentService.getAllStudents(), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity studentEntity) {
        try {
            return new ResponseEntity<>(studentService.updateStudent(studentEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
