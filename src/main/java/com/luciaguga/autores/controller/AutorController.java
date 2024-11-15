package com.luciaguga.autores.controller;

import com.luciaguga.autores.dto.AutorDTO;
import com.luciaguga.autores.model.Autor;
import com.luciaguga.autores.service.IAutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private IAutorService autorService;
    
    @GetMapping("/traer")
    public List<Autor> traerAutores(){
        return autorService.getAutores();
    }
    
    @GetMapping("/traerDTO")
    public List<AutorDTO> traerAutoresDTO(){
        return autorService.getAutoresDTO();
    }
    
    @PostMapping("/crear")
    public String guardarAutor(@RequestBody Autor a){
        autorService.saveAutor(a);
        return "Autor creado correctamente";
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String eliminarAutorById(@PathVariable Long id){
        autorService.deleteAutorById(id);
        return "El autor con id: " + id + " ha sido eliminado correctamente.";
    }
    
    @PutMapping("/editar/{id}")
    public Autor editarAutor(@PathVariable Long id, 
                            @RequestBody Autor a){
        autorService.editAutor(id, a);
        return autorService.findAutorById(id);
    }
    
    @GetMapping("/traer/{id}")
    public Autor encontrarAutorById(@PathVariable Long id){
        return autorService.findAutorById(id);
    }
}
