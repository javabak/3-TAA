package com.example.architecture.controller;

import com.example.architecture.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }


    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Integer> createUser(@RequestParam(name = "name", required = true) String name) {
        int res = userService.createUser(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(res);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getById(id));
    }
}
