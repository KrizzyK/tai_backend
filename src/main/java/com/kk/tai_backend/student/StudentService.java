package com.kk.tai_backend.student;

import com.kk.tai_backend.NotFoundException;
import com.kk.tai_backend.teacher.TeacherEntity;
import com.kk.tai_backend.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

        return repository.save(newStudent);
    }

    public StudentEntity getStudent(Long id) {
        return repository.findById(id).get();
    }

    public List<StudentEntity> getAllStudents() { return repository.findAll().stream().collect(Collectors.toList());}

    public StudentEntity updateStudent(StudentEntity studentNew) {
        StudentEntity entityToUpdate = repository.findById(studentNew.getId()).orElseThrow(NotFoundException::new);

        if(studentNew.getFirstName() != null) entityToUpdate.setFirstName(studentNew.getFirstName());
        if(studentNew.getLastName() != null) entityToUpdate.setLastName(studentNew.getLastName());
        if(studentNew.getGradeAverage() != null) entityToUpdate.setGradeAverage(studentNew.getGradeAverage());

        return repository.save(entityToUpdate);
    }

    void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
