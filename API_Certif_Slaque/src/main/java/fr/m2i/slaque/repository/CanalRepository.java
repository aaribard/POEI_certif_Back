package fr.m2i.slaque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.messagerie.model.Canal;

@Repository
public interface CanalRepository  extends JpaRepository<Canal, Long>{

}
