package com.example.userandroles.Service;

import com.example.userandroles.DTO.ResponseDTOUser;
import com.example.userandroles.DTO.RoleDTO;
import com.example.userandroles.Entities.Role;
import com.example.userandroles.Entities.User;
import com.example.userandroles.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleService roleService;

    public User addUser(User user){
        return userRepo.save(user);
    }
    public User addUser1(User user){

        List<Role> roles = (user.getRoles().stream().map(v->{
            Role role = roleService.findRoleById1(v.getId());
            role.getUsers().add(user);
            return role;
        }).collect(Collectors.toList()));
        user.setRoles(roles);
        return userRepo.save(user);
    }
    //get - by - id
/*    public List<User> findAll(){
       return userRepo.findAll();

    }*/
    public ResponseDTOUser findUserById(Long id){
        User user = userRepo.findById(id).get();
        List<RoleDTO> roles = new ArrayList<>();
        user.getRoles().forEach(role ->roles.add(new RoleDTO(role.getId(),role.getRole())));
        ResponseDTOUser responseDTO = new ResponseDTOUser(user.getId(),user.getName(),user.getPassword(),roles);
        return responseDTO;
    }
   /* public User getUser(Long id){
       return userRepo.getUserById(id);
    }*/

    //update - userl
    public User update(Long id,User user){
        User user1 = userRepo.findById(id).get();
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());
        return userRepo.save(user1);
    }
    //Delete-a-User
    public String delete(Long id){
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
        return "Deleted user # "+id;
    }


}
