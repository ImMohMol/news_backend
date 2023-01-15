package com.news.news.model.dto;

import com.news.news.utils.Message;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotNull(message = "FirstName Can't Be Null!")
    private String firstName;
    @NotNull(message = "LastName Can't Be Null!")
    private String lastName;
    @NotNull(message = "Age Can't Be Null!")
    private int age;
    @Min(value = 6, message = Message.USER_NAME_IS_TOO_SHORT)
    @Max(value = 120, message = Message.USER_NAME_IS_TOO_LONG)
    private String username;
    @Min(value = 6, message = Message.PASSWORD_IS_TOO_SHORT)
    @Max(value = 20, message = Message.PASSWORD_IS_TOO_LONG)
    private String password;
}
