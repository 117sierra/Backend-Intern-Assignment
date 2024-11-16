package com.growthx.assignment.Service;

import com.growthx.assignment.DTO.AdminRegisterDTO;
import com.growthx.assignment.Util.APIResponse;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<APIResponse<Object>> adminRegistration(AdminRegisterDTO adminRegisterDTO);
    ResponseEntity <APIResponse<Object>> taggedAssignments(String adminName);
    ResponseEntity<APIResponse<Object>> assignementAcceptance(String assignementId);

    ResponseEntity<APIResponse<Object>> assignementRejection(String assignementId);
}
