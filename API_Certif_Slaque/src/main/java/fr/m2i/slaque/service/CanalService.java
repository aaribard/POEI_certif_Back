package fr.m2i.slaque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.slaque.model.Canal;
import fr.m2i.slaque.repository.CanalRepository;

@Service
public class CanalService extends ServiceObject<Canal> {

	@Autowired
	CanalRepository cn;
	
	@Override
	public void delete(Long id) {
		if (repository.findById(id).get().getIsroot() == 0) repository.deleteById(id);
	}
	
	public Canal findGeneral() {
		return cn.findGeneral().get(0);
	}
}
