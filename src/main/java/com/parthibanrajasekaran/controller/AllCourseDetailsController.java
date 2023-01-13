package com.parthibanrajasekaran.controller;

import com.parthibanrajasekaran.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class AllCourseDetailsController {


    @Autowired
    CoursesRepository repository;

    @CrossOrigin
    @GetMapping("/allCourseDetails")
    public List<AllCourseData> getAllCourses() {
        return repository.findAll();
    }

    @CrossOrigin
    @RequestMapping("/getCourseByName/{name}")
    public AllCourseData getCourseByName(@PathVariable(value = "name") String name) {
        try {
            return repository.findById(name).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
