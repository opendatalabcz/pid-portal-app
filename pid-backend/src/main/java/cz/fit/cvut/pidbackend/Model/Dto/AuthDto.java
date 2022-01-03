package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.User;
import cz.fit.cvut.pidbackend.Security.Dto.JWTAuthResponse;

public class AuthDto {
    private JWTAuthResponse jwtAuthResponse;
    private User user;

    public AuthDto(JWTAuthResponse jwtAuthResponse, User user) {
        this.jwtAuthResponse = jwtAuthResponse;
        this.user = user;
    }

    public JWTAuthResponse getJwtAuthResponse() {
        return jwtAuthResponse;
    }

    public void setJwtAuthResponse(JWTAuthResponse jwtAuthResponse) {
        this.jwtAuthResponse = jwtAuthResponse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
