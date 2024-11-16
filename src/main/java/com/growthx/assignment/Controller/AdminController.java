package com.growthx.assignment.Controller;

import com.growthx.assignment.DTO.AdminRegisterDTO;
import com.growthx.assignment.Service.AdminService;
import com.growthx.assignment.Util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/v1")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse<Object>> adminRegister(@RequestBody @Validated AdminRegisterDTO adminRegisterDTO){
        return adminService.adminRegistration(adminRegisterDTO);
    }

    @GetMapping("/getAssignments")
    public ResponseEntity<APIResponse<Object>> taggedAssignments(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return adminService.taggedAssignments(authentication.getName());
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<APIResponse<Object>> assignmentacceptance(@PathVariable String id){
        return adminService.assignementAcceptance(id);
    }
    @PostMapping("/assignments/{id}/reject")
    public ResponseEntity<APIResponse<Object>> assignmentrejection(@PathVariable String id){
        return adminService.assignementRejection(id);
    }

}
