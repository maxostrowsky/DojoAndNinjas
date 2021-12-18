package com.codingdojo.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.models.Ninja;
import com.codingdojo.dojosAndNinjas.respositories.DojoRepository;
import com.codingdojo.dojosAndNinjas.respositories.NinjaRepository;

@Service
public class MainService {
	
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	public Dojo oneDojo(Long id){
		Optional<Dojo> dojos = dojoRepo.findById(id);
		if(dojos.isPresent()) {
			return dojos.get();
		} else {
			return null;
		}
		
	}
	public List<Ninja> allNinja(){
		return ninjaRepo.findAll();
	}
	
}
