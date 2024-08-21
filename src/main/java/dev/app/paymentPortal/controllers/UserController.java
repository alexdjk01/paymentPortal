package dev.app.paymentPortal.controllers;

import dev.app.paymentPortal.domain.dto.UserDto;
import dev.app.paymentPortal.domain.entities.User;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserService userService;

    private Mapper<User, UserDto> userMapper;

    public UserController(UserService userService, Mapper<User, UserDto> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto userDto)
    {
        User user = userMapper.mapFrom(userDto);
        User savedUser = userService.createUser(user);
        return userMapper.mapTo(savedUser);
    }

    @GetMapping(path = "/users")
    public List<UserDto> listUsers()
    {
        List<User> users = userService.findAll();
        return users.stream()
                .map(userMapper::mapTo)
                .collect(Collectors.toList());
    }

}
