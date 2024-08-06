package com.juank.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juank.demo.documentos.Usuario;
import com.juank.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepo; 

    /**
     * Metodo para agregar un usuario a la base de datos
     * @param usuario
     * @return la respuesta de ese ususario creado a la base de datos
     */
    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        try {
            Usuario userSave = usuarioRepo.save(usuario);
            return new ResponseEntity<Usuario>(userSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Obtiene la lista de usuario de la base de datos
     * @return la lista de los ususarios
     */
    @GetMapping
    public ResponseEntity<?> findAllUsuarios(){
        try {
            List<Usuario> usuarios = usuarioRepo.findAll();
            return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualiza los datos de un usuario
     * @param usuario
     * @return la respuesta con el usuario actualizado
     */
    @PutMapping
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario){
        try {
            Usuario userSave = usuarioRepo.save(usuario);
            return new ResponseEntity<Usuario>(userSave, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Elimina un usuario por su id
     * @param id
     * @return mensaje de avuso de que el usuario fue eliminado
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Integer id){
        try {
            usuarioRepo.deleteById(id);
            return new ResponseEntity<String>("Fue eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
