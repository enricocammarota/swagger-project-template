package it.testproj.service;

import it.testproj.entity.Student;

import java.util.Optional;

public interface IApiService {

    Optional<Student> getStudentByName(String name);
}
