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

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        System.out.println("The user is added");
        return userService.addUser1(user);
    }
    //UPDATE-USER
    @PutMapping("/updateuser/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return userService.update(id,user);
    }
   /* @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }*/

    //GET-USER
    @GetMapping("/user/{id}")
    public ResponseDTOUser findUser(@PathVariable Long id){
        return userService.findUserById(id);

    }
    @DeleteMapping("/deleteuser/{id}")
    public String delete(@PathVariable Long id){
        return userService.delete(id);
    }

    /*
    @GetMapping("/getuser")
    public List<User> findUser(){
        return userService.findAll();
    }*/
}
