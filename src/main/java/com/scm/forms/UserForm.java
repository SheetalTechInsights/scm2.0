package com.scm.forms;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "UserName is required")
    @Size(min=3,message = "Min 3 character is required")
    private String name;

    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min=6,message ="Min 6 characteris required" )
    private String password;

    @NotBlank(message = "About is required")
    private String about;

    @Size(min=8,max=12,message="Invalid Phone Number")
    private String phoneNumber;

}
