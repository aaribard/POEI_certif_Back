package fr.m2i.slaque.model;


import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

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

	@Nullable							//date non demandée pour créer le message(générée dans messageService)
	@Column(nullable = false)			//date nécéssaire dans la bdd
	private Date datecreation;
	
    @ManyToOne()
    @JoinColumn(name="id_canal", nullable=false)
    @JsonIncludeProperties(value = {"id"})
	private Canal canal;

    @ManyToOne()
    @JoinColumn(name="id_utilisateur", nullable=false)
    @JsonIncludeProperties(value = {"id", "login"})
    private Utilisateur utilisateur;
	
	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		return "[" + this.getId() + "] Canal " + this.getCanal().getId() + " - " + dateFormat.format(this.getDatecreation()) + " - " + this.getCorps();
	}
	
	
}
