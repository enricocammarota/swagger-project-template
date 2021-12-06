package it.testproj.entity;

import io.swagger.annotations.ApiModelProperty;

public class Student {

    @ApiModelProperty(notes = "Student name", name = "name", required = true, value = "foo")
    private String name;

    @ApiModelProperty(notes = "Student surname", name = "surname", required = true, value = "bar")
    private String surname;

    @ApiModelProperty(notes = "Student age", name = "age", required = true, value = "18")
    private Integer age;

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
