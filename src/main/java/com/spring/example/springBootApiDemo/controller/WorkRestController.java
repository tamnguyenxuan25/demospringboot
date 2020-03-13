package com.spring.example.springBootApiDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.springBootApiDemo.entity.Work;
import com.spring.example.springBootApiDemo.service.WorkService;

@RestController
@RequestMapping("api/v1/works")
public class WorkRestController {
	
	@Autowired
	WorkService workService;
	
	@GetMapping
    public ResponseEntity<List<Work>> works(
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Work> works = workService.getAll(pageNo, pageSize, sortBy);
        if (works.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(works, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Work> getById(@PathVariable(value = "id") long workId) {
        Optional<Work> workOpt = workService.getById(workId);
        if (workOpt.isPresent()) {
            return new ResponseEntity<>(workOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Work> create(@RequestBody Work work) {
        try {
        	Work _work = workService.add(work);
            return new ResponseEntity<>(_work, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Work> update(@PathVariable("id") long id, @RequestBody Work work) {
        Optional<Work> workOptional = workService.getById(id);
        if (workOptional.isPresent()) {
            Work _work = workService.update(work);
            return new ResponseEntity<>(_work, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            workService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
