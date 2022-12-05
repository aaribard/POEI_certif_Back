package fr.m2i.slaque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.m2i.slaque.model.Canal;

@Repository
public interface CanalRepository  extends JpaRepository<Canal, Long>{
	
	@Query("SELECT c FROM Canal c WHERE isroot > 0")
	public List<Canal> findGeneral();
}
