package fr.m2i.slaque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ServiceObject<T> implements ServiceInterface<T> {
	
	@Autowired
	protected JpaRepository<T, Long> repository;

	public List<T> getAll(){
		return repository.findAll();
	}
	
	public void save(T t) {
		repository.save(t);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
    public long count() {
    	return repository.count();
    }

    public boolean existsById(Long id) {
    	return repository.existsById(id);
    }

	public T findById(Long id) {
    	return (T) repository.findById(id);
    }
}
