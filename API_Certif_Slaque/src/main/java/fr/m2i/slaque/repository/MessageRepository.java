package fr.m2i.slaque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.m2i.messagerie.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query("SELECT m FROM Message m WHERE idcanal = ?1")
	public List<Message> findByCanal(Long idcanal);
	
	@Query("SELECT m FROM Message m WHERE idutilisateur = ?1")
	public List<Message> findByUtilisateur(Long idutilisateur);
}
