package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Dto.AuthDto;
import cz.fit.cvut.pidbackend.Model.Dto.UserDto;
import cz.fit.cvut.pidbackend.Model.User;
import cz.fit.cvut.pidbackend.Repository.UserRepository;
import cz.fit.cvut.pidbackend.Security.AuthJwt.JwtTokenProvider;
import cz.fit.cvut.pidbackend.Security.Dto.JWTAuthResponse;
import cz.fit.cvut.pidbackend.Security.Dto.LoginDto;
import cz.fit.cvut.pidbackend.Security.Dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<AuthDto> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.generateToken(authentication);

        Optional<User> user = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail());
        if (user.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new AuthDto(new JWTAuthResponse(token), new UserDto(user.get())));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList()));
    }
}
