package net.lectures.springboot.repository;

import net.lectures.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    /*Entity, Type of the Primary Key -> yukarıdaki iki parametre
    CRUD metodları otomatik gelmiş oldu extend yaptıgımız için. Ve normalde
    @Repository annotation koymamız gerekiyordu fakat extendlediğimiz için gerek kalmadı.*/
}
