package com.growthx.assignment.Controller;

import com.growthx.assignment.DTO.AdminRegisterDTO;
import com.growthx.assignment.DTO.UserRegistrationDTO;
import com.growthx.assignment.Entity.Assignment;
import com.growthx.assignment.Repository.AdminRepository;
import com.growthx.assignment.Service.UserService;
import com.growthx.assignment.Util.APIResponse;
import com.growthx.assignment.Util.ResponseStatusEnum;
import com.growthx.assignment.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse<Object>> adminRegister(@RequestBody @Validated UserRegistrationDTO userRegistrationDTO){
        return userService.userRegistration(userRegistrationDTO);
    }
    @GetMapping("/getAdmins")
    public ResponseEntity<APIResponse<Object>> getAdmins(){
        return userService.getAllAdmins();
    }
    @PostMapping("/uploadAssignment")
    public ResponseEntity<APIResponse<Object>> upload(@RequestBody @Validated Assignment assignment){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.uploadAssignment(assignment,authentication.getName());
    }
}
