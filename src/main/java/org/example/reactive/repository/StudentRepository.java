package org.example.reactive.repository;

import org.example.reactive.model.domain.StudentDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<StudentDO, Long> {
}
