package com.kk.tai_backend.teacher;

import com.kk.tai_backend.student.StudentEntity;
import com.kk.tai_backend.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;
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

    public Set<TeacherEntity> getAllTeachers() { return repository.findAll().stream().collect(Collectors.toSet());}

    public TeacherEntity updateTeacher(TeacherEntity postEntity) {
        return repository.save(postEntity);
    }

    void deleteTeacher(Long id) {
        repository.deleteById(id);
    }


}
