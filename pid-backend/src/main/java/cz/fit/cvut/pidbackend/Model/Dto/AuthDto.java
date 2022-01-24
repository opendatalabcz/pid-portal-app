package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Security.Dto.JWTAuthResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AuthDto {
    private JWTAuthResponse jwtAuthResponse;
    private UserDto user;
}
