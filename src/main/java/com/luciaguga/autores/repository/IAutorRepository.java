package com.luciaguga.autores.repository;

import com.luciaguga.autores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long>{
    
}
