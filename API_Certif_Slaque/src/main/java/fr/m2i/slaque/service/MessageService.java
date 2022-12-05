package fr.m2i.slaque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.slaque.model.Message;
import fr.m2i.slaque.repository.MessageRepository;

@Service
public class MessageService extends ServiceObject<Message> {

	@Autowired
	MessageRepository mr;
	
	public List<Message> findByCanal(Long idcanal){
		return mr.findByCanal(idcanal);
	}
	
	public List<Message> findByUtilisateur(Long idutilisateur){
		return mr.findByUtilisateur(idutilisateur);
	}
}
