package com.kechengsheji.modules.security.service;


import com.kechengsheji.exception.EntityNotFoundException;
import com.kechengsheji.model.Student;
import com.kechengsheji.modules.security.security.JwtUser;
import com.kechengsheji.service.StudentService;
import com.kechengsheji.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;


/**
 * @author jie
 * @date 2018-11-22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username){

        StudentDTO studentDTO = studentService.findByUsername(username);
        if (studentDTO == null) {
            throw new EntityNotFoundException(Student.class, "username", username);
        } else {
            return createJwtUser(studentDTO);
        }
    }




    public JwtUser createJwtUser(StudentDTO studentDTO) {
        return new JwtUser(
                studentDTO.getId(),
                studentDTO.getNumber(),
                studentDTO.getPassword(),
                studentDTO.getGrade(),
                studentDTO.getUsername(),
                studentDTO.getPhone(),
                studentDTO.getSex(),
                studentDTO.getDeptName(),
                studentDTO.getMajor(),
                studentDTO.getClassName(),
                studentDTO.getResetPasswordDate(),
                permissionService.mapToGrantedAuthorities("ADMIN")
        );
    }
}
