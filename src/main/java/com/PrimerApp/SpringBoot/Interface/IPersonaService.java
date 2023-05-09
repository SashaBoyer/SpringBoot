package com.PrimerApp.SpringBoot.Interface;

import com.PrimerApp.SpringBoot.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> verPersonas ();
    
    public void crearPersona (Persona per);
    
    public void borrarPersona (int id);
    
    public Persona buscarPersona (int id);
    
    public void modificarPersona (Persona per);
    
}
