package com.example.userandroles.Repository;

import com.example.userandroles.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Long> {
//@Query(value = "SELECT user.* ,role.* from user JOIN user_roles on user.id = user_role.user_id " +
//        "JOIN role on user_role.role_id =role.id where user.id =: id",nativeQuery = true)
//    public User getUserById(@Param("id") Long id);
}
