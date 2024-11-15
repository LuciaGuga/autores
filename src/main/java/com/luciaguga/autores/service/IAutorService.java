package com.luciaguga.autores.service;

import com.luciaguga.autores.dto.AutorDTO;
import com.luciaguga.autores.model.Autor;
import java.util.List;

public interface IAutorService {
    public List<Autor> getAutores();
    public List<AutorDTO> getAutoresDTO();
    public void saveAutor(Autor a);
    public void deleteAutorById(Long id);
    public Autor editAutor(Long id, Autor a);
    public Autor findAutorById(Long id);
}
