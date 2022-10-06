package org.example.reactive.model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("coursework")
public class CourseworkDO {
    @Id
    @Column("id")
    private Long id;

    @Column("student_id")
    private Long studentID;

    @Column("course_id")
    private Long courseID;

    @Column("marks")
    private Integer marks;
}
