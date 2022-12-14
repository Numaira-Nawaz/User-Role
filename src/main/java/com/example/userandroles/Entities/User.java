package com.example.userandroles.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String password;
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "user_roles", joinColumns =
        @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns =
        @JoinColumn(name = "role_id", referencedColumnName = "id"))
   /* @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinTable(name = "user_roles",joinColumns =
            {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})*/
    private Collection<Role> roles = new ArrayList<>();


}
