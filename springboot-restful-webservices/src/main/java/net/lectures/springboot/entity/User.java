package net.lectures.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//GETTER SETTER VE CONSTRUCTORLARI OTO OLUŞTURDU. LOMBOK!
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDLERI OTO ARTTIRICAK
    private Long id;
    @Column(nullable = false)
    private String firstName; //JPA oto first_name olarak vericek column name'i.
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
}
