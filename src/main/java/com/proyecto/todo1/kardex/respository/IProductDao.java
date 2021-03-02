package com.proyecto.todo1.kardex.respository;


import com.proyecto.todo1.kardex.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM PRODUCT l WHERE l.name=:name", nativeQuery = true)
    public abstract Product findProduct(@Param("name") String name);

    @Query(value = "SELECT * FROM PRODUCT l WHERE l.name=:name", nativeQuery = true)
    public abstract Product findProductbyName(@Param("name") String name);

}
