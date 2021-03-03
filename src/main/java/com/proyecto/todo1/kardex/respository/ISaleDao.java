package com.proyecto.todo1.kardex.respository;

import com.proyecto.todo1.kardex.dto.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDao extends JpaRepository<Sale, Integer> {


}
