package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.TurmaDisciplina;

@Repository
public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplina, Long>{

}
