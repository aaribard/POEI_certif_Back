package fr.m2i.slaque.service;

import java.util.List;

public interface ServiceInterface<T> {

	public List<T> getAll();
	public void save(T t);
	public void delete(Long id);
    public long count(); 
    public boolean existsById(Long id);
    public T findById(Long id);
}
