package com.kk.tai_backend.teacher;

import com.kk.tai_backend.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    final private TeacherRepository repository;

    public TeacherEntity addTeacher(TeacherEntity newTeacher) {
        if(newTeacher.getStartedWork() == null) newTeacher.setStartedWork(Timestamp.from(Instant.now()));
        return repository.save(newTeacher);
    }

    public TeacherEntity getTeacher(Long id) {
        return repository.findById(id).get();
    }

    public List<TeacherEntity> getAllTeachers() { return repository.findAll().stream().collect(Collectors.toList());}

    public TeacherEntity updateTeacher(TeacherEntity teacherNew) {
        TeacherEntity entityToUpdate = repository.findById(teacherNew.getId()).orElseThrow(NotFoundException::new);

        if(teacherNew.getStudents() != null && !teacherNew.getStudents().isEmpty()) entityToUpdate.setStudents(teacherNew.getStudents());
        if(teacherNew.getFirstName() != null) entityToUpdate.setFirstName(teacherNew.getFirstName());
        if(teacherNew.getLastName() != null) entityToUpdate.setLastName(teacherNew.getLastName());

        return repository.save(entityToUpdate);
    }

    void deleteTeacher(Long id) {
        repository.deleteById(id);
    }


}
