package com.PrimerApp.SpringBoot.controller;

import com.PrimerApp.SpringBoot.model.Persona;
import com.PrimerApp.SpringBoot.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"https://proyecto-frontend-deploy.web.app", "http://localhost:4200"})
public class PersonaController {
    
    @Autowired
    private IPersonaService personaServ;
    
    
//EndPoint    
    @PostMapping("/persona/crear")
    public void agregarPersona (@RequestBody Persona pers){
        //listaPersonas.add(pers); 
        personaServ.crearPersona(pers);
    }
    
//Consultar lista de personas
    @GetMapping ("/persona/ver")
    @ResponseBody//lo que devuelve esta funcion, quiero que me lo devuelvas en el cuerpo de la respuesta
    public List<Persona> verPersonas (){
        //return listaPersonas;
        return personaServ.verPersonas();
    }
    
    @DeleteMapping ("/persona/borrar/{id}")
    public void borrarPersona(@PathVariable int id){
        personaServ.borrarPersona(id);
    }
    
    @PutMapping("/persona/editar/{id}")
    public void modificarPersona(@PathVariable int id,
                             @RequestParam("nombre")String nuevoNombre,
                             @RequestParam("apellido")String nuevoApellido,
                             @RequestParam("img")String img,
                             @RequestParam("titulo")String titulo,
                             @RequestParam("descripcion")String nuevaDescripcion)
                             
    {
        Persona persona = personaServ.buscarPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(img);
        persona.setTitulo(titulo);
        persona.setDescripcion(nuevaDescripcion);
        
        personaServ.modificarPersona(persona);
    }
   
    @GetMapping("/persona/buscar/{id}")
    public Persona BuscarPersona(@PathVariable int id){
        return personaServ.buscarPersona(id);
    }
    
}
