package com.example.userandroles.Service;

import com.example.userandroles.DTO.PermissionDTO;
import com.example.userandroles.DTO.ResponseDTORole;

import com.example.userandroles.DTO.UserDTO;
import com.example.userandroles.Entities.Permissions;
import com.example.userandroles.Entities.Role;
import com.example.userandroles.Repository.PermissionRepo;
import com.example.userandroles.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PermissionRepo permissionRepo;
    public Role addRole(Role role){
        return roleRepo.save(role);
    }
    public Role findRoleById1(Long id){
       return roleRepo.findById(id).get();
    }
    /*public ResponseDTORole findRoleById(Long id) {
        Role role = roleRepo.findById(id).get();
        List<UserDTO> user =new ArrayList<>();
        List<PermissionDTO> permissions = new ArrayList<>();
        role.getUsers().forEach(user1 -> user.add(new UserDTO(user1.getId(),user1.getName(), user1.getPassword())));
        role.getPermissions().forEach(permissions1 -> permissions.add(new PermissionDTO(permissions1.getId(), permissions1.getPermission())));
        return new ResponseDTORole(role.getId(),role.getRole(),user,permissions);
    }*/
    public String delete(Long id){
        Role role = roleRepo.findById(id).get();
        roleRepo.delete(role);
        return "Deleted role # "+id;
    }

    public Role addRoleByPermissionId(Role role){

        List<Permissions> permissionsList = (role.getPermissions().stream().map(v->{
            Permissions permissions = permissionRepo.findById(v.getId()).get();
            permissions.getRoles().add(role);
            return permissions;
        }).collect(Collectors.toList()));
        role.setPermissions(permissionsList);
        return roleRepo.save(role);
    }
}
