package org.example.reactive.model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("courses")
public class CourseDO {
    @Id
    @Column("id")
    private Long id;

    @Column("coursename")
    private String coursename;
}
