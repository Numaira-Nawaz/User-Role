package com.example.userandroles.Service;

import com.example.userandroles.DTO.ResponseDTORole;

import com.example.userandroles.DTO.UserDTO;
import com.example.userandroles.Entities.Role;
import com.example.userandroles.Entities.User;
import com.example.userandroles.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;
    public Role addRole(Role role){
        return roleRepo.save(role);

    }
    public Role findRoleById1(Long id){
       return roleRepo.findById(id).get();
    }
    public ResponseDTORole findRoleById(Long id) {
        Role role = roleRepo.findById(id).get();
        List<UserDTO> user =new ArrayList<>();
        role.getUsers().forEach(user1 -> user.add(new UserDTO(user1.getId(),user1.getName(), user1.getPassword())));
        return new ResponseDTORole(role.getId(),role.getRole(),user);
    }
    public String delete(Long id){
        Role role = roleRepo.findById(id).get();
        roleRepo.delete(role);
        return "Deleted role # "+id;
    }
}
