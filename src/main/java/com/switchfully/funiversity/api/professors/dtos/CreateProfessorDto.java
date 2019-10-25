package com.switchfully.funiversity.api.professors.dtos;

public class CreateProfessorDto {
    private String firstName;
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public CreateProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateProfessorDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
