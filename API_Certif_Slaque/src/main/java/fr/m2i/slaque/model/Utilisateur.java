package fr.m2i.slaque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String login;

    @OneToMany(mappedBy="utilisateur", fetch = FetchType.LAZY)
    @JsonBackReference
	private List<Message> messages = new ArrayList<Message>();
	
	public Utilisateur() {
		
	}

	public Utilisateur(String login) {
		this.login = login;
	}
	
	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getLogin();
	}
	

}
