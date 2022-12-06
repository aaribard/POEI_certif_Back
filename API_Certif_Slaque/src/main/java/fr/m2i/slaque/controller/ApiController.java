package fr.m2i.slaque.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.slaque.model.Canal;
import fr.m2i.slaque.model.Message;
import fr.m2i.slaque.service.CanalService;
import fr.m2i.slaque.service.MessageService;

@RestController
public class ApiController {

	@Autowired
	private MessageService ms;
	
	@Autowired
	private CanalService cs;
	
	@GetMapping(path="/general", produces={"application/json"})
	public Map<String, Object> getGeneralEndpoint(Model model) { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Canal> canalList = cs.getAll();
		map.put("canalList", canalList);
		List<Message> generalListMessage = ms.findByCanal(cs.findGeneral().getId());
		map.put("generalListMessage", generalListMessage);
		return map;
	}
	
}
