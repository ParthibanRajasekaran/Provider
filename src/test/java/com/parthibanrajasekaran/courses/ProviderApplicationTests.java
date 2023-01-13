package com.parthibanrajasekaran.courses;

import com.parthibanrajasekaran.controller.AllCourseData;
import com.parthibanrajasekaran.controller.AllCourseDetailsController;
import com.parthibanrajasekaran.repository.CoursesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProviderApplicationTests {

    @Mock
    private CoursesRepository repository;

    @InjectMocks
    private AllCourseDetailsController controller;

    @Test
    public void testGetAllCourses() {
        // given
        List<AllCourseData> expectedCourses = Arrays.asList(
                new AllCourseData("1", "Spring Boot"),
                new AllCourseData("2", "Java")
        );
        when(repository.findAll()).thenReturn(expectedCourses);

        // when
        List<AllCourseData> courses = controller.getAllCourses();

        // then
        assertEquals(expectedCourses, courses);
    }

    @Test
    public void testGetCourseByName_Found() {
        // given
        String name = "Spring Boot";
        AllCourseData expectedCourse = new AllCourseData("1", "Spring Boot");
        when(repository.findById(name)).thenReturn(Optional.of(expectedCourse));

        // when
        AllCourseData course = controller.getCourseByName(name);

        // then
        assertEquals(expectedCourse, course);
    }

    @Test
    public void testGetCourseByName_NotFound() {
        // given
        String name = "Non-existing course";
        when(repository.findById(name)).thenReturn(Optional.empty());

        // when/then
        assertThrows(ResponseStatusException.class, () -> {
            controller.getCourseByName(name);
        });
    }
}

