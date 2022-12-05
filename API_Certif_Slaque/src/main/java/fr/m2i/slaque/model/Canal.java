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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "canal")
public class Canal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String nom;

	@Column(nullable = false, length = 10)
	private int isroot;

    @OneToMany(mappedBy="canal", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Message> messages  = new ArrayList<Message>();
	
	public Canal() {

	}

	public Canal(String nom) {
		this.setNom(nom);
		this.setIsroot(0);
	}

	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getNom() + " - " + this.getIsroot();
	}

}
