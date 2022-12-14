package com.example.userandroles.Controller;

import com.example.userandroles.DTO.ResponseDTORole;
import com.example.userandroles.Entities.Permissions;
import com.example.userandroles.Entities.Role;
import com.example.userandroles.Service.PermissionService;
import com.example.userandroles.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @PostMapping("/role")
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
  /*  @GetMapping("/getrole/{id}")
    public ResponseDTORole getRoleById(@PathVariable Long id){
        return roleService.findRoleById1(id);
    }*/
    @DeleteMapping("/deleterole/{id}")
    public String delete(@PathVariable Long id){
        return roleService.delete(id);
    }
@PostMapping("/addrolebypermissionid")
    public Role addRoleByPermissionId(@RequestBody Role role){

    return roleService.addRoleByPermissionId(role);
}
}
