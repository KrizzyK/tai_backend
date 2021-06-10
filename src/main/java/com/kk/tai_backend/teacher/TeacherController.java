package com.kk.tai_backend.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/teacher")
@CrossOrigin
public class TeacherController {
    final private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherEntity> addTeacher(@RequestBody TeacherEntity teacherEntity) {
        try {
            return new ResponseEntity<>(teacherService.addTeacher(teacherEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherEntity> getTeacher(@PathVariable Long id) {
        try {
            return new ResponseEntity<>( teacherService.getTeacher(id), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<TeacherEntity>> getAllTeachers() {
        try {
            return new ResponseEntity<>( teacherService.getAllTeachers(), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<TeacherEntity> updateTeacher(@RequestBody TeacherEntity teacherEntity) {
        try {
            return new ResponseEntity<>(teacherService.updateTeacher(teacherEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable Long id) {
        try {
            teacherService.deleteTeacher(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
