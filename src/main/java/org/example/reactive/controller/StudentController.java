package org.example.reactive.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.reactive.model.domain.StudentDO;
import org.example.reactive.model.dto.StudentDTO;
import org.example.reactive.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/{studentId}")
    public Mono<StudentDTO> getStudent(@PathVariable("studentId") Long studentId) {
        return studentRepository.findById(studentId).map(studentDO -> {
            if(studentDO == null) {
                log.info("no student found");
            }
            StudentDTO dto = new StudentDTO();
            dto.setId(studentDO.getId());
            dto.setName(studentDO.getName());
            dto.setStatus(studentDO.getStatus());
            dto.setRegisteredOn(studentDO.getRegisteredOn());
            return dto;
        });
    }

    @GetMapping(value = "/students/listAll", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<StudentDTO> listAll() {
        return studentRepository.findAll().map(studentDO -> {
            StudentDTO dto = new StudentDTO();
            dto.setId(studentDO.getId());
            dto.setName(studentDO.getName());
            dto.setStatus(studentDO.getStatus());
            dto.setRegisteredOn(studentDO.getRegisteredOn());
            return dto;
        }).delayElements(Duration.ofSeconds(2L));
    }

    @GetMapping(value = "/students/testList")
    public Flux<Integer> testList() {
        return Flux.just(1,2,3,4,5,6,7,8).delayElements(Duration.ofSeconds(2L)).log();
    }

}
