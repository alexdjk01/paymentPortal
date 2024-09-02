package dev.app.paymentPortal.controllers;

import dev.app.paymentPortal.domain.dto.UserDto;
import dev.app.paymentPortal.domain.entities.User;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping(path = "/users/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
    {
        Optional<User> userFound = userService.findUserByEmail(email);
        if(userFound.isPresent())
        {
            UserDto userDtoFound = userMapper.mapTo(userFound.get());
            return new ResponseEntity<>(userDtoFound,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/users/address/{fullAddress}")
    public ResponseEntity<UserDto> getUserByAddress(@PathVariable String fullAddress)
    {
        System.out.println("Received fullAddress: " + fullAddress);
        Optional<User> userFound = userService.findUserByAddress(fullAddress);
        if(userFound.isPresent())
        {
            UserDto userDtoFound = userMapper.mapTo(userFound.get());
            return new ResponseEntity<>(userDtoFound, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<UserDto> createUpdateUser(@PathVariable Long id, @RequestBody UserDto userDto)
    {

        User user = userMapper.mapFrom(userDto);
        boolean userExists = userService.isExists(id);
        User updatedUser = userService.createUpdateUser(id,user);
        UserDto updatedUserDto = userMapper.mapTo(updatedUser);
        if(userExists)
        {
            return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(updatedUserDto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id)
    {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User succesfully DELETED", HttpStatus.OK);
    }

}
