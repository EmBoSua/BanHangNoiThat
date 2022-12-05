package com.example.banhangnoithat.security.rest;

import com.example.banhangnoithat.response.BHNTResponse;
import com.example.banhangnoithat.security.dto.UserDto;
import com.example.banhangnoithat.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/user/all")
    public BHNTResponse<List<UserDto>> getAll() {
        BHNTResponse<List<UserDto>> r = userService.getAll();
        return r;
    }

    @PostMapping("/user/add")
    public BHNTResponse<UserDto> saveUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
}
