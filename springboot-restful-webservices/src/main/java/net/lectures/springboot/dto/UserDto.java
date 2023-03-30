package net.lectures.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    //Hassas bilgileri DTO'ya koymamak lazım. (şifre gibi)

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
