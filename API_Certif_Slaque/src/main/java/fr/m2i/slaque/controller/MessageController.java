package fr.m2i.slaque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.slaque.model.Message;

@RestController
@RequestMapping(path = "/message")
public class MessageController extends ControllerObject<Message> {
	
	@Autowired
	MessageService ms;
	
	@GetMapping(path="/findbycanal", produces={"application/json"})
	@ResponseStatus(code=HttpStatus.CREATED)	
	public List<Message> findByCanal( @RequestParam("id") String id) {
		return ms.findByCanal(Long.parseLong(id));
	}
}
