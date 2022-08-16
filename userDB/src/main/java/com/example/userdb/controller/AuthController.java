package com.example.userdb.controller;

import com.example.userdb.dto.ApiResponse;
import com.example.userdb.model.User;
import com.example.userdb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @GetMapping("/user")
    public ResponseEntity<List> getUsers(){
        List<User> users=authService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid User user){
        authService.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !",201));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody @Valid User user,@PathVariable Integer id){
        authService.updateUser(user,id);
        return ResponseEntity.status(201).body(new ApiResponse("User data updated !",201));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        authService.deleteUser(id);
        return ResponseEntity.status(201).body(new ApiResponse("User deleted !",201));
    }

}
