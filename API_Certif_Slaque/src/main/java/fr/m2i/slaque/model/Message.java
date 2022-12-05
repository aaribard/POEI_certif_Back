package fr.m2i.slaque.model;


import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "message")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 2000)
	private String corps;
	
	@Column(nullable = false)
	private Date datecreation;
	
    @ManyToOne
    @JoinColumn(name="id_canal", nullable=false)
    @JsonIncludeProperties(value = {"id"})
	private Canal canal;

    @ManyToOne
    @JoinColumn(name="id_utilisateur", nullable=false)
    @JsonIncludeProperties(value = {"id"})
    private Utilisateur utilisateur;
    
	public Message() {
		
	}

	public Message(String corps, Date datecreation, Canal canal) {
		this.corps = corps;
		this.datecreation = (Date) Date.from(Instant.now());
		this.canal = canal;
	}
	
	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		return "[" + this.getId() + "] Canal " + this.getCanal().getId() + " - " + dateFormat.format(this.getDatecreation()) + " - " + this.getCorps();
	}
	
	
}
