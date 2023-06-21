package com.demo.services;

import java.util.Optional;

import com.demo.entity.Etudiant;

public interface EtudiantService {
	public Iterable<Etudiant> findAll();
	public Etudiant findByIdEt(Integer id);
	public void saveEt(Etudiant etudiant);
	public void deleteEt(Etudiant etudiant);

}
