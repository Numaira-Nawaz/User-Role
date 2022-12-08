package com.example.userandroles.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTOUser {
    private Long id;
    private String name;
    private String password;
    private List<RoleDTO> roles;


}
