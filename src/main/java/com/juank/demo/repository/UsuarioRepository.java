package com.juank.demo.repository;

import com.juank.demo.documentos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario,Integer> {

    
}
