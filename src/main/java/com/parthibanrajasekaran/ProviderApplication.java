package com.parthibanrajasekaran;

import com.parthibanrajasekaran.controller.AllCourseData;
import com.parthibanrajasekaran.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
//public class ProviderApplication implements CommandLineRunner {
public class ProviderApplication {

    @Autowired
    CoursesRepository coursesRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

//    @Override
//
//    public void run(String[] args) {
//        List<AllCourseData> lib = coursesRepository.findAll();
//        System.out.println(lib.get(0).getCourse_name() + " is this");
//    }
}
