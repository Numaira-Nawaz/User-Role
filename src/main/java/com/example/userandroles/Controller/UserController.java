package com.example.userandroles.Controller;
import com.example.userandroles.DTO.ResponseDTOUser;
import com.example.userandroles.Entities.User;
import com.example.userandroles.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser1(user);
    }
    //UPDATE-USER
    @PutMapping("/updateuser/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return userService.update(id,user);
    }
    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    //GET-USER
    @GetMapping("/user/{id}")
    public ResponseDTOUser findUser(@PathVariable Long id){
        return userService.findUserById(id);

    }

    /*
    @GetMapping("/getuser")
    public List<User> findUser(){
        return userService.findAll();
    }*/
}
