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
public class ResponseDTORole {
    private Long id;
    private String role;
    private List<UserDTO> users;


}
