package com.example.userandroles.Service;

import com.example.userandroles.DTO.PermissionDTO;
import com.example.userandroles.DTO.RoleDTO;
import com.example.userandroles.Entities.Permissions;
import com.example.userandroles.Entities.Role;
import com.example.userandroles.Repository.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionRepo permissionRepo;
    @Autowired
    RoleService roleService;
    public List<Permissions> addAll(List<Permissions> permissions){
        permissionRepo.saveAll(permissions);
        return permissions;
    }
    public Permissions add(Permissions permission){

        return  permissionRepo.save(permission);
    }
    public Permissions addPermissionByRoleId(PermissionDTO permission){
    Permissions permissions = new Permissions();
    List<Role> roleList = new ArrayList<>();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        Collection<RoleDTO> roles = permission.getRoleDTOS();
        for (RoleDTO role:roles) {
            Role rol = roleService.findRoleById1(role.getId());
            roleDTOS.add(new RoleDTO(rol.getId(),rol.getRole()));
            roleList.add(rol);
        }
        permission.setRoleDTOS(roleDTOS);
        permissions.setPermission(permission.getPermission());
        permissions.setRoles(roleList);
        permissionRepo.save(permissions);
        return permissions;
    }
/*    public Permissions addById(Permissions permission){
       List<Role> roles = (permission.getRoles().stream().map(v->{
           Role role = roleService.findRoleById1(v.getId());
           role.getPermissions().add(permission);
           return role;
       }).collect(Collectors.toList()));
       permission.setRoles(roles);
        return permissionRepo.save(permission);
    }*/
}
