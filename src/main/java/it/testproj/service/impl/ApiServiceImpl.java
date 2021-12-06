package it.testproj.service.impl;

import it.testproj.entity.Student;
import it.testproj.service.IApiService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiServiceImpl implements IApiService {

    @Override
    public Optional<Student> getStudentByName(String name) {
        if (name.equals("foo")) {
            Student student = new Student(
                    "foo",
                    "bar",
                    18);
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }
}
