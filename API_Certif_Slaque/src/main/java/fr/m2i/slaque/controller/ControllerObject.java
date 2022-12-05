package fr.m2i.slaque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.messagerie.service.ServiceInterface;

@RestController
public abstract class ControllerObject<T> {

	@Autowired
	protected ServiceInterface<T> service; 
	
	@GetMapping(path="/list", produces={"application/json"})
	public List<T> getList() { 
		return service.getAll();
	}
	
	@PostMapping(path="/save", consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveTodo(@RequestBody T t) {
		service.save(t);
	}
	
	@DeleteMapping(path="/delete")
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void delete( @RequestParam("id") String id) {
		service.delete(Long.parseLong(id));
	}
	
	@GetMapping(path="/findbyid", produces={"application/json"})
	@ResponseStatus(code=HttpStatus.CREATED)	
	public T findById( @RequestParam("id") String id) {
		return this.service.findById(Long.parseLong(id));
	}
}
