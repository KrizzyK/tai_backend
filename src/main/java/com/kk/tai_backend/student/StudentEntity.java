package com.kk.tai_backend.student;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kk.tai_backend.teacher.TeacherEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="firstname", nullable = false)
    private String firstName;

    @Column(name="lastname", nullable = false)
    private String lastName;

    @Column(name="gradeaverage", nullable = true)
    private Double gradeAverage;

    @ManyToOne
    @JoinColumn(name="teacher")
    @JsonBackReference
    private TeacherEntity teacher;

}
