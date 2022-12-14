package com.example.userandroles.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String permission;
   @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission",joinColumns =
            {@JoinColumn(name = "role_id")},inverseJoinColumns =
            {@JoinColumn(name = "permission_id")})
    @JsonIgnore
    private Collection<Role> roles = new ArrayList<>();


}
