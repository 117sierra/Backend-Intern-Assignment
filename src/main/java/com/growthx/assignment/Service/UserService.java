package com.growthx.assignment.Service;

import com.growthx.assignment.DTO.UserRegistrationDTO;
import com.growthx.assignment.Entity.Assignment;
import com.growthx.assignment.Util.APIResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<APIResponse<Object>> userRegistration(UserRegistrationDTO userRegistrationDTO);

    ResponseEntity<APIResponse<Object>> getAllAdmins();

    ResponseEntity<APIResponse<Object>> uploadAssignment(Assignment assignment, String name);
}
