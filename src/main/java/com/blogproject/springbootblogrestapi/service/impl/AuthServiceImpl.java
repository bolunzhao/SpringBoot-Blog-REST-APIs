package com.blogproject.springbootblogrestapi.service.impl;

import com.blogproject.springbootblogrestapi.entity.Role;
import com.blogproject.springbootblogrestapi.entity.User;
import com.blogproject.springbootblogrestapi.exception.BlogAPIException;
import com.blogproject.springbootblogrestapi.payload.LoginDto;
import com.blogproject.springbootblogrestapi.payload.RegisterDto;
import com.blogproject.springbootblogrestapi.repository.RoleRepository;
import com.blogproject.springbootblogrestapi.repository.UserRepository;
import com.blogproject.springbootblogrestapi.security.JwtTokenProvider;
import com.blogproject.springbootblogrestapi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        // add check for username exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already existed!");
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already existed!");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        long userCount = userRepository.count();

        Set<Role> roles = new HashSet<>();
        if (userCount == 0) {
            // FIRST user => admin
            Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new BlogAPIException(
                            HttpStatus.NOT_FOUND, "ROLE_ADMIN not found in database!"
                    ));
            roles.add(adminRole);

            // Optionally add ROLE_USER as well if you want them to have both
            // Role userRole = roleRepository.findByName("ROLE_USER").get();
            // roles.add(userRole);
        } else {
            // Not the first user => normal user
            Role userRole = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new BlogAPIException(
                            HttpStatus.NOT_FOUND, "ROLE_USER not found in database!"
                    ));
            roles.add(userRole);
        }

        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!";
    }
}
