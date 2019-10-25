package com.switchfully.funiversity.api.professors.dtos;

public class UpdateProfessorDto {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public UpdateProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateProfessorDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
