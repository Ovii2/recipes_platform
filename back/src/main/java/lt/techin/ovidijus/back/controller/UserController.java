package lt.techin.ovidijus.back.controller;

import lt.techin.ovidijus.back.dto.LoginDTO;
import lt.techin.ovidijus.back.dto.ResponseLoginDTO;
import lt.techin.ovidijus.back.dto.UserDTO;
import lt.techin.ovidijus.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody LoginDTO loginDTO) {
        ResponseLoginDTO loggedUser = userService.loginUser(loginDTO);
        if (loggedUser.getToken() == null) {
            return ResponseEntity.badRequest().body(loggedUser);
        }
        return ResponseEntity.ok(loggedUser);
    }

    @GetMapping("/emails")
    public ResponseEntity<List<String>> getAllUserEmails() {
        List<String> emails = userService.getAllUserEmails();
        return ResponseEntity.ok(emails);
    }
}
