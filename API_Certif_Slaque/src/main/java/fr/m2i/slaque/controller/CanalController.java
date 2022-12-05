package fr.m2i.slaque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.messagerie.model.Canal;

@RestController
@RequestMapping(path = "/canal")
public class CanalController extends ControllerObject<Canal> {

}
