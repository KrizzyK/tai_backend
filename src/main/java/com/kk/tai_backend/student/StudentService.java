package com.kk.tai_backend.student;

import com.kk.tai_backend.teacher.TeacherEntity;
import com.kk.tai_backend.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    final private StudentRepository repository;
    final private TeacherService teacherService;

    @Transactional
    public StudentEntity addStudent(StudentEntity newStudent, Long teacherId) {
        if(newStudent.getGradeAverage() == null) newStudent.setGradeAverage(3.0);

        TeacherEntity teacher = teacherService.getTeacher(teacherId);
        teacher.getStudents().add(newStudent);
//        teacherService.updateTeacher(teacher);

        newStudent.setTeacher(teacherService.getTeacher(teacherId));
        return repository.save(newStudent);
    }

    public StudentEntity getStudent(Long id) {
        return repository.findById(id).get();
    }

    public Set<StudentEntity> getAllStudents() { return repository.findAll().stream().collect(Collectors.toSet());}

    public StudentEntity updateStudent(StudentEntity postEntity) {
        return repository.save(postEntity);
    }

    void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
