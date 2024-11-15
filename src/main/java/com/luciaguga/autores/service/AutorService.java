package com.luciaguga.autores.service;

import com.luciaguga.autores.dto.AutorDTO;
import com.luciaguga.autores.model.Autor;
import com.luciaguga.autores.repository.IAutorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IAutorService{
    @Autowired
    private IAutorRepository autorRepo;

    @Override
    public List<Autor> getAutores() {
        return autorRepo.findAll();
    }

    @Override
    public void saveAutor(Autor a) {
        autorRepo.save(a);
    }

    @Override
    public void deleteAutorById(Long id) {
        autorRepo.deleteById(id);
    }

    @Override
    public Autor editAutor(Long id, Autor a) {
        Autor autor = this.findAutorById(id);
        autor.setNombre_completo_autor(a.getNombre_completo_autor());
        autor.setFecha_nac(a.getFecha_nac());
        autor.setNacionalidad(a.getNacionalidad());
        autor.setIsbnsLibrosEscritos(a.getIsbnsLibrosEscritos());
        autorRepo.save(autor);
        return this.findAutorById(id);
    }

    @Override
    public Autor findAutorById(Long id) {
        return autorRepo.findById(id).orElse(null);
    }  

    @Override
    public List<AutorDTO> getAutoresDTO() {
        List<AutorDTO> listaDto = new ArrayList<>();
        List<Autor> lista = this.getAutores();
        for(Autor a : lista){
            AutorDTO autorDto = new AutorDTO();
            autorDto.setNombre(a.getNombre_completo_autor());
            autorDto.setNacionalidad(a.getNacionalidad());
            autorDto.setIsbnsLibrosEscritos(a.getIsbnsLibrosEscritos());
            listaDto.add(autorDto);
        }
        return listaDto;
    }
    
}
