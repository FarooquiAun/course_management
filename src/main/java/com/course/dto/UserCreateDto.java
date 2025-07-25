package com.course.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserCreateDto {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "email is required")
    @Email(message = "invalid email")
    private String email;
    @Size(min = 6, message = "Password must be of at least 6 characters")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
