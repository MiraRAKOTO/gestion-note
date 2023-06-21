package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{

}
