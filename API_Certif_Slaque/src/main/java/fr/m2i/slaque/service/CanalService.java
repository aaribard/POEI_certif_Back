package fr.m2i.slaque.service;

import org.springframework.stereotype.Service;

import fr.m2i.slaque.model.Canal;

@Service
public class CanalService extends ServiceObject<Canal> {

	@Override
	public void delete(Long id) {
		System.out.println("Suppression Canal " + id);
		if (repository.findById(id).get().getIsroot() == 0) repository.deleteById(id);
	}

}
