package com.news.news.model.dto;

import com.news.news.utils.Message;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    @NotNull(message = "Username Can't Be Null!")
    @Min(value = 6, message = Message.USER_NAME_IS_TOO_SHORT)
    @Max(value = 120, message = Message.USER_NAME_IS_TOO_LONG)
    private String username;
    @NotNull(message = "Password Can't Be Null!")
    @Min(value = 6, message = Message.PASSWORD_IS_TOO_SHORT)
    @Max(value = 20, message = Message.PASSWORD_IS_TOO_LONG)
    private String password;
}
