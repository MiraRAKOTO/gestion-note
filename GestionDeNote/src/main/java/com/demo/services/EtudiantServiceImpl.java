package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.entity.Etudiant;
import com.demo.repository.EtudiantRepository;



@Service
public class EtudiantServiceImpl implements EtudiantService{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	
	@Override
	public Iterable<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}


	@Override
	public Etudiant findByIdEt(Integer id) {
		// TODO Auto-generated method stub
		return this.etudiantRepository.getById(id);
	}


	@Override
	public void saveEt(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiantRepository.save(etudiant);
		
	}


	@Override
	public void deleteEt(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiantRepository.delete(etudiant);;
	}
}
