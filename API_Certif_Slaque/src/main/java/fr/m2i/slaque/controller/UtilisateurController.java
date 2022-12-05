package fr.m2i.slaque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.slaque.model.Utilisateur;

@RestController
@RequestMapping(path = "/utilisateur")
public class UtilisateurController  extends ControllerObject<Utilisateur>{

}
