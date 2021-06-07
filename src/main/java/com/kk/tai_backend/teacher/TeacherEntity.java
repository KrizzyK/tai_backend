package com.kk.tai_backend.teacher;

import com.kk.tai_backend.student.StudentEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherEntity {
    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="firstname", nullable = false)
    private String firstName;
    @Column(name="lastname", nullable = false)
    private String lastName;
    @Column(name="startedwork", nullable = false)
    private Timestamp startedWork;


    @OneToMany
    Set<StudentEntity> students = new HashSet<>();
}
