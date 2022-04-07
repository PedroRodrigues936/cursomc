package com.pedrorodrigues.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrorodrigues.cursomc.domain.Categoria;
import com.pedrorodrigues.cursomc.repositories.CategoriaRepository;
import com.pedrorodrigues.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id){
		Optional<Categoria> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
		} 
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
