package com.growthx.assignment.Service;

import com.growthx.assignment.DTO.UserRegistrationDTO;
import com.growthx.assignment.Entity.Admin;
import com.growthx.assignment.Entity.Assignment;
import com.growthx.assignment.Entity.User;
import com.growthx.assignment.Repository.AdminRepository;
import com.growthx.assignment.Repository.AssignmentRepository;
import com.growthx.assignment.Repository.UserRepository;
import com.growthx.assignment.Util.APIResponse;
import com.growthx.assignment.Util.ResponseStatusEnum;
import com.growthx.assignment.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public ResponseEntity<APIResponse<Object>> userRegistration(UserRegistrationDTO userRegistrationDTO) {
        try {
            User user = User.builder().
                    name(userRegistrationDTO.getName()).
                    password(passwordEncoder.encode(userRegistrationDTO.getPassword()))
                    .build();
            userRepository.save(user);
            return ResponseUtil.getSuccessResponse("You have been successfully registered", ResponseStatusEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.getFailureResponse(e.getMessage(), ResponseStatusEnum.FAILED);
        }
    }

    @Override
    public ResponseEntity<APIResponse<Object>> getAllAdmins() {

        return ResponseUtil.getSuccessResponse(getAdmins(),ResponseStatusEnum.SUCCESS);
    }
    private List<String> getAdmins(){
        return adminRepository.findAll()
                .stream()
                .map(Admin::getName)
                .toList();
    }

    @Override
    public ResponseEntity<APIResponse<Object>> uploadAssignment(Assignment assignment, String name) {
        try {
            List<String> admins = getAdmins();
            Random random = new Random();
            assignment.setAdminName(admins.get(random.nextInt(admins.size())));
            assignment.setUserName(name);
            assignmentRepository.save(assignment);
            Optional<User> user = userRepository.findByName(name);
            List<Assignment> assignmentList;
            assignmentList = user.get().getTask() == null ? new ArrayList<>() : user.get().getTask();
            assignmentList.add(assignment);
            user.get().setTask(assignmentList);
            userRepository.save(user.get());
            return ResponseUtil.getSuccessResponse("Assignment Successfully Submitted",ResponseStatusEnum.SUCCESS);
        }catch (Exception e){
            return ResponseUtil.getSuccessResponse(e.getMessage(),ResponseStatusEnum.SUCCESS);
        }
    }
}
