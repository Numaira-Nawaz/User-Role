package com.example.userandroles.Controller;

import com.example.userandroles.DTO.PermissionDTO;
import com.example.userandroles.Entities.Permissions;

import com.example.userandroles.Entities.Role;
import com.example.userandroles.Repository.PermissionRepo;
import com.example.userandroles.Service.PermissionService;
import com.example.userandroles.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;

    @PostMapping("/addAll")
    public List<Permissions> addAll(@RequestBody List<Permissions> permissions){
        return permissionService.addAll(permissions);
    }
    @PostMapping("/addpermission")
    public Permissions addpermission(@RequestBody Permissions permission){
        return permissionService.add(permission);
    }
    @PostMapping("/addpermisionbyroleid")
    public Permissions addById(@RequestBody PermissionDTO permission){
         return permissionService.addPermissionByRoleId(permission);

    }
}
