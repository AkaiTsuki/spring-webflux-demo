package org.example.reactive.model.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private Long registeredOn;
    private Integer status;
}
