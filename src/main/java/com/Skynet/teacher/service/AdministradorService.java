package com.Skynet.teacher.service;

import com.Skynet.teacher.entities.Administrador;
import com.Skynet.teacher.repository.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador administradorPorEmailESenha( String email, String senha){
        try {
			Administrador adm = administradorRepository.findAdministradorByEmailAndSenha(email, senha);
            return adm;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }

    public Administrador inserirAdministrador(Administrador adm){
        try {
            Administrador admExistente = administradorRepository.findAdministradorByEmail(adm.getEmail());
            if(admExistente != null){ return null;}

            Administrador admInserido = administradorRepository.save(adm);
            
            return admInserido;
        } catch (Exception e) {
            
            return null;
        }
    }
}