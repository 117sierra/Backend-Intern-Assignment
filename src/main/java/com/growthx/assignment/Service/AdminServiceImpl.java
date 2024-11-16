package com.growthx.assignment.Service;

import com.growthx.assignment.DTO.AdminRegisterDTO;
import com.growthx.assignment.Entity.Admin;
import com.growthx.assignment.Entity.Assignment;
import com.growthx.assignment.Repository.AdminRepository;
import com.growthx.assignment.Repository.AssignmentRepository;
import com.growthx.assignment.Util.APIResponse;
import com.growthx.assignment.Util.ResponseStatusEnum;
import com.growthx.assignment.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public ResponseEntity<APIResponse<Object>> adminRegistration(AdminRegisterDTO adminRegisterDTO) {
        try {
            Admin admin = Admin.builder().
                    name(adminRegisterDTO.getName()).
                    password(passwordEncoder.encode(adminRegisterDTO.getPassword()))
                    .build();
            adminRepository.save(admin);
            return ResponseUtil.getSuccessResponse("You have been successfully registered", ResponseStatusEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.getFailureResponse(e.getMessage(), ResponseStatusEnum.FAILED);
        }
    }

    @Override
    public ResponseEntity<APIResponse<Object>> taggedAssignments(String adminName) {
        try {
            return ResponseUtil.getSuccessResponse(assignmentRepository.findByAdminName(adminName), ResponseStatusEnum.SUCCESS);
        } catch (Exception e) {
            return ResponseUtil.getFailureResponse(e.getMessage(), ResponseStatusEnum.FAILED);
        }
    }

    @Override
    public ResponseEntity<APIResponse<Object>> assignementAcceptance(String assignementId) {
        try {
            Optional<Assignment> assignment = assignmentRepository.findById(assignementId);
            assignment.get().setIsAccepted(true);
            assignmentRepository.save(assignment.get());
            return ResponseUtil.getSuccessResponse("Assignment Accepted", ResponseStatusEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.getFailureResponse(e.getMessage(), ResponseStatusEnum.FAILED);
        }
    }
    @Override
    public ResponseEntity<APIResponse<Object>> assignementRejection(String assignementId) {
        try {
            Optional<Assignment> assignment = assignmentRepository.findById(assignementId);
            assignment.get().setIsAccepted(false);
            assignmentRepository.save(assignment.get());
            return ResponseUtil.getSuccessResponse("Assignment Rejected", ResponseStatusEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.getFailureResponse(e.getMessage(), ResponseStatusEnum.FAILED);
        }
    }
}
