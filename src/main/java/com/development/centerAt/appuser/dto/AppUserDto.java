package com.development.centerAt.appuser.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserDto {

    @NotBlank
    @Size(max = 50, message = "Максимальное количество символов в логине - 50, " +
            "пожалуйста, проверьте правильность указанных данных")
    private String username;

    @NotBlank
    @Size(max = 50, message = "Максимальное количество символов в пароле - 50, " +
            "пожалуйста, проверьте правильность указанных данных")
    private String password;

    @Email
    @NotBlank
    @Size(min = 6, max = 250, message = "Минимальное количество символов в электронной почте пользователя - 6, " +
            "максимальное - 250, пожалуйста, проверьте правильность указанных данных")
    private String email;

    @NotBlank
    @Size(max = 50, message = "Максимальное количество символов в имени - 50, " +
            "пожалуйста, проверьте правильность указанных данных")
    private String firstName;

    @NotBlank
    @Size(max = 50, message = "Максимальное количество символов в фамилии - 50, " +
            "пожалуйста, проверьте правильность указанных данных")
    private String lastName;

    @Nullable
    private String role;
}
