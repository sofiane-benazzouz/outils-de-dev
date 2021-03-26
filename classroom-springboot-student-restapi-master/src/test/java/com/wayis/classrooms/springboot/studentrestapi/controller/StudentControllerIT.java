package com.wayis.classrooms.springboot.studentrestapi.controller;

import com.wayis.classrooms.springboot.studentrestapi.StudentRestApiApplication;
import com.wayis.classrooms.springboot.studentrestapi.model.Course;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentRestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application.properties")
public class StudentControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Nested
    @DisplayName("GET /students/{student}/courses/{course}")
    class GetStudentCourse {

        @Test
        @DisplayName("should return a JSON course object")
        public void testRetrieveStudentCourse() throws JSONException {

            HttpEntity<String> entity = new HttpEntity<>(null, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    createURLWithPort("/students/S-001/courses/DEVE709"),
                    HttpMethod.GET, entity, String.class);

            String expected = "{id:DEVE709,name:IDE,description:\"Utilisation des IDE\"}";

            Assertions.assertEquals(200, response.getStatusCode().value());
            JSONAssert.assertEquals(expected, response.getBody(), false);
        }
    }

    @Nested
    @DisplayName("POST /students/{student}/courses")
    class PostStudentCourse {
        @Test
        @DisplayName("should create a course for the user")
        public void addCourse() {
            Course course = new Course("Course1", "SpringBoot", "IT", Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

            HttpEntity<Course> entity = new HttpEntity<>(course, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    createURLWithPort("/students/S-001/courses"),
                    HttpMethod.POST, entity, String.class);

            Assertions.assertEquals(201, response.getStatusCode().value());
            String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
            assertTrue(actual.contains("/students/S-001/courses/"));
        }
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
