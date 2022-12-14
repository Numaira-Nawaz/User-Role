package com.example.userandroles.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String role;
    @JsonBackReference
    @ManyToMany(
           fetch = FetchType.EAGER,cascade = CascadeType.ALL)
            @JoinTable(name = "role_permission",joinColumns =
            {@JoinColumn(name = "role_id",referencedColumnName = "id")},inverseJoinColumns = {
            @JoinColumn(name = "permission_id",referencedColumnName = "id")})
    private Collection<Permissions> permissions = new ArrayList<>();
    @JsonManagedReference
//   @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade = {  CascadeType.PERSIST, CascadeType.MERGE})
            @JoinTable(name = "user_roles",joinColumns =
            {@JoinColumn(name = "role_id")},inverseJoinColumns =
            {@JoinColumn(name = "user_id")})
  @JsonIgnore
    private Collection<User> users = new ArrayList<>();


}
