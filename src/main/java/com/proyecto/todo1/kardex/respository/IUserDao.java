package com.proyecto.todo1.kardex.respository;

import com.proyecto.todo1.kardex.dto.Product;
import com.proyecto.todo1.kardex.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER u WHERE u.username=:username AND u.password=:password", nativeQuery = true)
    public abstract User findUser(@Param("username") String username, @Param("password") String password);

}
