package com.codingdojo.relationships.services;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.repositories.DojoRepository;
import com.codingdojo.relationships.repositories.NinjaRepository;

@Service
public class BootCampService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	private static final int PAGE_SIZE = 2;
	public BootCampService(DojoRepository dRepo, NinjaRepository nRepo) {
		this.dojoRepo = dRepo;
		this.ninjaRepo = nRepo;
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	//pagination:
	public Page<Object[]> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "firstName");
        Page<Object[]> ninjaswithdojo = (Page<Object[]>) ninjaRepo.getAllNinjasWithDojo(pageRequest);
        //return ninjaRepo.findAll(pageRequest);
        return ninjaswithdojo;
    }
}
