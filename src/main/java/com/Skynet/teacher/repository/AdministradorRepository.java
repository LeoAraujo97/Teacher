package com.Skynet.teacher.repository;

import com.Skynet.teacher.entities.Administrador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    
    @Query(value = "SELECT * FROM administrador WHERE email =?1 AND senha =?2", nativeQuery = true)
    public Administrador findAdministradorByEmailAndSenha(String email, String senha);

    public Administrador findAdministradorByEmail(String email);
}